package org.classLogic.datacell

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.io.File

class DataCellTest {

    private lateinit var dataCell: DataCell

    @BeforeEach
    fun setUp() {
        dataCell = DataCell("TestName")
    }

    @Test
    fun nameInit() {
        val nameValue = dataCell.getName()
        assertEquals("TestName", nameValue, "Name initialization failed")
    }

    @Test
    fun timestampUpdate() {
        val initialTimestamp = dataCell.getTimestamp()

        Thread.sleep(50) // 50 miliseconds
        dataCell.swapData("newLocation")

        val updatedTimestamp = dataCell.getTimestamp()
        assertTrue(updatedTimestamp > initialTimestamp, "Timestamp update failed")
    }

    @Test
    fun extractDataPathTest() {
        val examplePath: String = "right.here"
        dataCell.swapData(examplePath)
        assertEquals(examplePath, dataCell.accessData(), "Failed to set properly file path")
    }

    @Test
    fun removePreviousFileTest() {
        // this is wrong (i think) because I don't want to create files as it goes I want to sorta automate it
        // but that's also on the app level and that's like the last thing I'm probably gonna be doing
        // I'll leave it for now but this should also be handled on database level
        val oldFileLocation = "TestSet/oldFile"
        val newFileLocation = "TestSet/newFile"

        val oldFile = File(oldFileLocation)
        oldFile.parentFile.mkdirs()
        oldFile.createNewFile()
        assertTrue(oldFile.exists(), "Failed to create former data file")

        dataCell.swapData(oldFileLocation)
        assertEquals(oldFileLocation, dataCell.accessData(), "Failed to set properly old file path")
        
        val newFile = File(newFileLocation)
        newFile.parentFile.mkdirs()
        newFile.createNewFile()
        assertTrue(newFile.exists(), "Failed to create new data file")

        dataCell.swapData(newFileLocation)
        assertEquals(newFileLocation, dataCell.accessData(), "Failed to set properly new file path")
        assertFalse(oldFile.exists(), "Failed to remove previous file")
    }
}