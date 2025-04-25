package org.classLogic.playermanager

import org.classLogic.player.Player

class PlayerManager {
    private val players: MutableList<Player> = mutableListOf()

    constructor() {

    }
    fun addPlayer(player: Player) {

    }

    fun removePlayer(player: Player) {

    }

    fun getPlayers(): List<Player> {
        return players
    }

    fun getSize(): Int {
        return players.size
    }
}