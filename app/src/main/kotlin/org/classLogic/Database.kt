package org.classLogic.database

import org.classLogic.datacell.DataCell
import java.io.File

class Database {
    private val dataCells: MutableList<DataCell> = mutableListOf()
    val basePath: String

    constructor(folderPath: String) {
        basePath = "${folderPath}data"
        if (!File(basePath).exists()) {
            File(basePath).mkdirs()
        }
    }

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