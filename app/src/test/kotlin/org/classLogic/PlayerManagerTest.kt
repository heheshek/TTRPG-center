package org.classLogic.playermanager

import org.classLogic.player.Player

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlayerManagerTest {

    private lateinit var playerManager: PlayerManager
    private lateinit var player1: Player
    private lateinit var player2: Player

    @BeforeEach
    fun setUp() {
        playerManager = PlayerManager()
        player1 = Player("Player1", "12345")
        player2 = Player("Player2", "54321")
    }

    @Test
    fun addPlayerTest() {
        playerManager.addPlayer(player1)
        assertEquals(1, playerManager.getSize())
        assertTrue(playerManager.getPlayers().contains(player1), "Failed to add player")
    }

    @Test
    fun removePlayerTest() {
        playerManager.addPlayer(player1)
        playerManager.addPlayer(player2)
        playerManager.removePlayer(player1)
        assertEquals(1, playerManager.getSize())
        assertFalse(playerManager.getPlayers().contains(player1), "Failed to remove player")
        assertTrue(playerManager.getPlayers().contains(player2), "Another player not found")
    }

    @Test
    fun preventDuplicatesTest() {
        playerManager.addPlayer(player1)
        playerManager.addPlayer(player1)
        assertEquals(1, playerManager.getSize(), "Duplicate player added")
    }

    @Test
    fun removeNonexistentPlayerTest() {
        playerManager.addPlayer(player1)
        playerManager.removePlayer(player2)
        assertEquals(1, playerManager.getSize())
        assertTrue(playerManager.getPlayers().contains(player1), "Player should still be present")
    }
}