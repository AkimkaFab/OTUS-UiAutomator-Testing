package com.example.homework_8

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayOutputStream

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun openPokedexAppTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        assertEquals("dev.marcosfarias.pokedex", device.currentPackageName.toString())

//        val h = ByteArrayOutputStream()
//        device.dumpWindowHierarchy(h)
//        println(h)

        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)

    }

    @Test
    fun openAllPokemonsTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        val openAllPoks = device.findObject(By.text("Pokedex"))
        openAllPoks.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)

        val h = ByteArrayOutputStream()
        device.dumpWindowHierarchy(h)

        if (h.toString().contains("Bulbasaur") || h.toString().contains("Ivysaur")
            || h.toString().contains("Venusaur") ) {
            assert(true)
        } else {
            assert(false)
        }

        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)
    }

    @Test
    fun openBulbasaurTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        val openAllPoks = device.findObject(By.text("Pokedex"))
        openAllPoks.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)
        val openBulb = device.findObject(By.text("Bulbasaur"))
        openBulb.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)

        val h = ByteArrayOutputStream()
        device.dumpWindowHierarchy(h)

        if (h.toString().contains("Bulbasaur can be seen napping in bright sunlight. There is a seed on its back") ) {
            assert(true)
        } else {
            assert(false)
        }

        Thread.sleep(200)
        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)

    }

    @Test
    fun openFirstNewsTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        val openAllPoks = device.findObject(By.text("Pokémon Rumble Rush Arrives Soon"))
        openAllPoks.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)

        val h = ByteArrayOutputStream()
        device.dumpWindowHierarchy(h)

        Thread.sleep(1000)
        if (h.toString().contains("Lorem ipsum dolor sit amet") ) {
            assert(true)
        } else {
            assert(false)
        }

        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)


    }

    @Test
    fun openPikachuFailTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        val openAllPoks = device.findObject(By.text("Pokedex"))
        openAllPoks.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)
        val openBulb = device.findObject(By.text("Bulbasaur"))
        openBulb.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)

        val h = ByteArrayOutputStream()
        device.dumpWindowHierarchy(h)

        //trying to find Pikachu ID
        var isPikachuFound = true
        if (h.toString().contains("#025") ) {
            isPikachuFound = true
        } else {
            isPikachuFound = false
        }

        Thread.sleep(200)
        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)

        assert(isPikachuFound)
    }

    @Test
    fun openSpeedDialTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        val openAllPoks = device.findObject(By.text("Pokedex"))
        openAllPoks.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)
        val speedDial = device.findObject(By.res("dev.marcosfarias.pokedex:id/speedDial"))
        speedDial.click()
        Thread.sleep(1000)

        val h = ByteArrayOutputStream()
        device.dumpWindowHierarchy(h)

        if (h.toString().contains("All Type") ) {
            assert(true)
        } else {
            assert(false)
        }

        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)

    }

    @Test
    fun openAllGenerationsTest() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val runApp = device.findObject(By.text("Pokedex"))
        runApp.clickAndWait(Until.newWindow(), 5000)
        Thread.sleep(1000)
        val openAllPoks = device.findObject(By.text("Pokedex"))
        openAllPoks.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)
        val speedDial = device.findObject(By.res("dev.marcosfarias.pokedex:id/speedDial"))
        speedDial.click()
        Thread.sleep(1000)
        val openAllGen = device.findObject(By.text("All Gen"))
        openAllGen.clickAndWait(Until.newWindow(),5000)
        Thread.sleep(1000)

        val h = ByteArrayOutputStream()
        device.dumpWindowHierarchy(h)

        if (h.toString().contains("Generation") ) {
            assert(true)
        } else {
            assert(false)
        }

        device.pressRecentApps()
        Thread.sleep(200)
        device.swipe(700,1800,700,100,10)
        Thread.sleep(200)
        device.click(1300,2400)


    }

}
