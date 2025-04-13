package org.classLogic.classes.datacell

class DataCell(setName: String) {
    private var name: String = setName
    private var contentAccess: String? = null
    // the idea is contentAccess is location of a file that has the data
    private val timestamp: Long = System.currentTimeMillis()

    fun getName(): String? {
        return null
    }
    fun getTimestamp(): Long {
        return 0
    }
    fun getData(): String? {
        return null
    }

    fun swapData(newPos: String?) {

    }
    fun accessData(): String? {
        return null
    }
}