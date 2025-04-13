package org.classLogic.classes.datacell

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
        val examplePath: String = "my/place/is/right.here"
        dataCell.swapData(examplePath)
        assertEquals(examplePath, dataCell.getData(), "Failed to set properly file path")
    }
}