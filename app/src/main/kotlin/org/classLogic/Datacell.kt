package org.classLogic.datacell

import java.io.File

class DataCell(setName: String) {
    private var name: String = setName
    private var contentAccess: String? = null
    // the idea is contentAccess is location of a file that has the data
    private var timestamp: Long = System.currentTimeMillis()

    fun getName(): String? {
        return name
    }
    fun getTimestamp(): Long {
        return timestamp
    }

    fun swapData(newPos: String?) {
        if (contentAccess != null) {
            val file = File(contentAccess)
            if (file.exists()) {
                file.delete()
            }
        }
        timestamp = System.currentTimeMillis()
        contentAccess = newPos
    }

    fun accessData(): String? {
        return contentAccess
    }
}