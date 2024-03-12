package com.example.homework_8

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.io.ByteArrayOutputStream

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun startGameWithDefaultSettings() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Chess"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(3000)
        val play = device.findObject(By.text("Play"))
        play.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(500)
        val playComp = device.findObject(By.res("com.chess:id/tile_vs_computer"))
        playComp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(300)
        val chooseBot = device.findObject(By.res("com.chess:id/chooseBotButton"))
        chooseBot.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(300)
        val playChess = device.findObject(By.res("com.chess:id/playBotButton"))
        playChess.clickAndWait(Until.newWindow(), 5000)
        val s = ByteArrayOutputStream()
        device.dumpWindowHierarchy(s)
        if (!(s.toString().contains("com.chess:id/chessBoardView"))) {
            assert(false)
        }
        assertEquals(device.currentPackageName.toString(), "com.chess")
        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)
    }


    @Test
    fun doMoveAndGiveUp() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Chess"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(3000)
        val play = device.findObject(By.text("Play"))
        play.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(500)
        val playComp = device.findObject(By.res("com.chess:id/tile_vs_computer"))
        playComp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(300)
        val chooseBot = device.findObject(By.res("com.chess:id/chooseBotButton"))
        chooseBot.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(300)
        val playChess = device.findObject(By.res("com.chess:id/playBotButton"))
        playChess.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(4000)
        device.click(650, 2150)
        Thread.sleep(200)
        device.click(650, 1800)
        Thread.sleep(700)
        val new = device.findObject(By.res("com.chess:id/newControlView"))
        new.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(200)
        val endGame = device.findObject(By.res("android:id/button1"))
        endGame.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1500)
        val s = ByteArrayOutputStream()
        device.dumpWindowHierarchy(s)
        println(s)
        if (!(s.toString().contains("Game Over"))) {
            assert(false)
        }
        assertEquals(device.currentPackageName.toString(), "com.chess")
        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)
    }

    @Test
    fun rateApp() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Chess"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(3000)
        val set = device.findObject(By.res("com.chess:id/menu_item_settings"))
        set.clickAndWait(Until.newWindow(), 5000)
        val rate = device.findObject(By.text("Rate this App"))
        rate.clickAndWait(Until.newWindow(),5000)
        assertEquals(device.currentPackageName.toString(),"com.android.vending")
        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(500)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)
    }
}