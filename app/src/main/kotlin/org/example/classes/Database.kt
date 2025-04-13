package org.classLogic.classes.database

import org.classLogic.classes.datacell.DataCell

class Database {
    private val dataCells: MutableList<DataCell> = mutableListOf()

    fun addDataCell(cellName: DataCell) {

    }

    fun removeDataCell(cellName: DataCell) {

    }

    fun findData(): MutableList<DataCell> {
        return dataCells
    }
    fun findSize(): Int {
        return dataCells.size
    }
}