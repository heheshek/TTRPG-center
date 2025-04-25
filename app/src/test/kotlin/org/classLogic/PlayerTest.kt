package org.classLogic.player

import org.classLogic.playercharacter.PC
import org.classLogic.playercharacter.FiveEPC

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlayerTest {

    private var player: Player = Player("TestPlayer", "12345")
    
    @BeforeEach
    fun setUp() {
        player = Player("TestPlayer", "12345")
    }

    @Test
    fun addCharacterTest() {
        val character = FiveEPC("TestCharacter")
        player.addCharacter(character)

        assertTrue(player.getCharacters().contains(character) == true, "Character not added to player")
    }

    @Test
    fun addSameNameCharactersTest() {
        val character1 = FiveEPC("TestCharacter")
        val character2 = FiveEPC("TestCharacter")
        player.addCharacter(character1)
        player.addCharacter(character2)

        assertEquals(player.getCharacters().size, 2, "Failed to add characters")

        assertTrue(player.getCharacters().contains(character1) == true, "Character 1 not added to player")
        assertTrue(player.getCharacters().contains(character2) == true, "Character 2 not added to player")
    }

    @Test
    fun removeCharacterWithDuplicateNameTest() {
        val character1 = FiveEPC("TestCharacter")
        val character2 = FiveEPC("TestCharacter")
        player.addCharacter(character1)
        player.addCharacter(character2)

        val afterAddCount = player.getCharacters().size
        player.removeCharacter("TestCharacter")
        val afterRemoveCount = player.getCharacters().size

        assertEquals(afterAddCount, afterRemoveCount, "Removed character without specifying which one")
    }
}