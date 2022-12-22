package com.example.mvvm_beatbox

import junit.framework.TestCase
import org.junit.Before
import javax.security.auth.Subject

class SoundViewModelTest : TestCase() {

    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    public override fun setUp() {
        super.setUp()
        sound = Sound("assetPath")
        subject = SoundViewModel()
        subject.sound = sound
    }
}