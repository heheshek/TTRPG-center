package org.classLogic.classes.playermanager

import org.classLogic.classes.player.Player

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