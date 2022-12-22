package com.example.mvvm_beatbox


import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SoundViewModelTest {

    private lateinit var beatBox: BeatBox
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setup() {
        beatBox = Mockito.mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle(){
        MatcherAssert.assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun callBeatBoxPlayOnButtonClicked(){
        subject.onButtonClick()

        Mockito.verify(beatBox).play(sound)
    }
}