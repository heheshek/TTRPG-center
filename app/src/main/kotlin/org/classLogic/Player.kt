package org.classLogic.player

import org.classLogic.playercharacter.PC
import org.classLogic.playercharacter.FiveEPC

class Player {
    private var nickname: String
    private var playerId: String
    enum class PType { GM, Player }
    private val status: PType

    private val characters: MutableList<PC> = mutableListOf()

    constructor(nickname: String, playerId: String) {
        this.nickname = nickname
        this.playerId = playerId
        this.status = PType.Player
    }
    
    private constructor(nickname: String, playerId: String, status: PType) {
        this.nickname = nickname
        this.playerId = playerId
        this.status = status
    }
    companion object {
        fun initializeGameMaster(nickname: String, playerId: String, status: PType): Player {
            return Player(nickname, playerId, status)
        }
    }

    fun getNickname(): String {
        return nickname
    }
    fun getId(): String {
        return playerId
    }
    fun getCharacters(): MutableList<PC> {
        return characters
    }
    fun addCharacter(character: String) {
        //characters.add(character)
    }
    fun addCharacter(character: PC) {
        if (!characters.contains(character))
            characters.add(character)
    }
    fun removeCharacter(character: String): Int {
        // return 0 on success, 1 if found duplicates
        return 0
    }
    fun removeCharacterSpecific(character: PC) {
        if (characters.contains(character))
            characters.remove(character)
    }

    fun isGameMaster(): Boolean {
        //return status == PType.GM
        return false
    }
}