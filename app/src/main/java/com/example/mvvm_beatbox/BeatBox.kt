package com.example.mvvm_beatbox

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.lang.Exception


private const val TAG = "BeatBox"
private const val SOUND_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

class BeatBox(private val assets:AssetManager) {

    val sounds : List<Sound>
    private val soundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()

    private fun load(sound: Sound){
        val afd: AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }

    init{
        sounds = loadSounds()
    }

    private fun loadSounds(): List<Sound> {
        val soundNames: Array<String>
        try {
            soundNames = assets.list(SOUND_FOLDER)!!

        } catch (e: Exception) {
            Log.e(TAG, "Could not list assets", e)

            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundNames.forEach{filename ->
            val assetPath =  "$SOUND_FOLDER/$filename"
            val sound = Sound(assetPath)
            sounds.add(sound)
        }
        return sounds
    }
}