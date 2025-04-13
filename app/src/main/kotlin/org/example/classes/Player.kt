package org.classLogic.classes.player

import org.classLogic.classes.playercharacter.PC
import org.classLogic.classes.playercharacter.FiveEPC

class Player {
    private var nickname: String
    private var playerId: String
    enum class PType { GM, PLR }
    private val status: PType

    private val characters: MutableList<PC> = mutableListOf()

    constructor(nickname: String, playerId: String) {
        this.nickname = nickname
        this.playerId = playerId
        this.status = PType.PLR
    }

    fun getNickname(): String {
        return nickname
    }
    fun getId(): String {
        return playerId
    }
    fun getCharacters(): List<PC> {
        return characters
    }
    fun addCharacter(character: String) {
        //characters.add(character)
    }
    fun addCharacter(character: PC) {

    }
    fun removeCharacter(character: String) {
        //characters.remove(character)
    }
    fun removeCharacterSpecific(character: PC) {
        // in case of ambiguity
        //characters.remove(character)
    }

    fun isGameMaster(): Boolean {
        //return status == PType.GM
        return false
    }
}