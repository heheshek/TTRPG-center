package org.classLogic.classes.database

import org.classLogic.classes.datacell.DataCell

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DatabaseTest {

    private lateinit var database: Database

    @BeforeEach
    fun setUp() {
        database = Database()
    }

    @Test
    fun databaseInitTest() {
        assertNotNull(database, "Database returned null")
        assertTrue(database.findData().isEmpty(), "Database is not empty on initialization")
    }

    @Test
    fun insertDataTest() {
        val dataCell = DataCell("test")
        database.addDataCell(dataCell)

        //assertEquals(1, database.getData().size, "Database failed to add data cell")
        assertTrue(database.findData().contains(dataCell), "Data cell not found in database")
    }

    @Test
    fun removeDataTest() {
        val dataCell = DataCell("test")

        database.addDataCell(dataCell)
        val beforeSize: Int = database.findData().size

        database.removeDataCell(dataCell)
        assertTrue(database.findData().size < beforeSize, "Database failed to remove data cell")
        assertFalse(database.findData().contains(dataCell), "Data cell not removed from database")
    }

    @Test
    fun removeNonexistentDataTest() {
        val dataCell = DataCell("test")
        database.removeDataCell(dataCell)

        assertTrue(database.findData().isEmpty(), "Database should be empty after removing nonexistent data cell")
    }

    @Test
    fun addConflictingDataNameTest() {
        val dataCell1 = DataCell("TestName")
        val dataCell2 = DataCell("TestName")

        database.addDataCell(dataCell1)
        database.addDataCell(dataCell2)

        assertEquals(1, database.findSize(), "Database should not allow duplicate data cell names")
    }
}