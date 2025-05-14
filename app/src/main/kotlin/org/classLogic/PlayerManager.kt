package org.classLogic.playermanager

import org.classLogic.player.Player

class PlayerManager {
    private val players: MutableList<Player> = mutableListOf()

    constructor() {

    }
    fun addPlayer(player: Player): Player? {
        // check if we're not trying to add a second DM
        if (player.isGameMaster()) {
            for (p in players) {
                if (p.isGameMaster()) {
                    return null
                }
            }
        }
        // check if we're not trying to add a duplicate
        for (p in players) {
            if (p.getId() == player.getId()) {
                return null
            }
        }
        // check if there's no conflicting playerID
        for (p in players) {
            if (p.getId() == player.getId()) {
                return null
            }
        }
        players.add(player)
        return player
    }

    fun removePlayer(player: Player): Boolean {
        // check if not deleting a GM
        if (player.isGameMaster()) {
            for (p in players) {
                if (p.isGameMaster() && p.getId() == player.getId()) {
                    return false
                }
            }
        }
        // check if is in the list
        for (p in players) {
            if (p.getId() == player.getId()) {
                players.remove(p)
                return true
            }
        }
        return false 
    }

    fun getPlayers(): List<Player> {
        return players
    }

    fun getSize(): Int {
        return players.size
    }
}