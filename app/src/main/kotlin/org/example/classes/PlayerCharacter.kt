package org.classLogic.classes.playercharacter

enum class PCType {
    NONE, DND5E
}

abstract class PC {
    protected var name: String = ""
    protected var playerGame: PCType = PCType.NONE
    protected var characterID: Int = 0
    protected var aboutCharacter: String = ""

    protected val characteristics: MutableMap<String, String> = mutableMapOf()
    // Name, Text: e.g. Class, Paladin    
    protected val skills: MutableMap<String, MutableMap<String, Int>> = mutableMapOf()
    // Name, <Skill, Value>: e.g. Ability Score, <Athletics, 5>

    fun mgetName(): String {
        return ""//name
    }
    fun mgetPlayerGame(): PCType {
        return PCType.NONE //playerGame
    }
    fun mgetCharacteristics(): Map<String, String>? {
        return null//characteristics
    }
    fun mgetSkills(): Map<String, Map<String, Int>>? {
        return null//skills
    }
    fun mgetAboutCharacter(): String {
        return ""//aboutCharacter
    }
    
    fun addCharacteristic(name: String, value: String) {
        //characteristics[name] = value
    }
    fun addSkill(name: String, skill: String, value: Int) {
        // if skills[name] exists, append to it, else create a new one
    }
    fun addBackgound(path: String) {
        //background = path
    }
}

// 5e character class
class FiveEPC(setName: String) : PC() {
    init {
        this.name = setName
        this.playerGame = PCType.DND5E
    }

    fun statCheck(stat: String): Int {
        return 0
    }
}