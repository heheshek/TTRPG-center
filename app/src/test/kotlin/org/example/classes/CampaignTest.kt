package org.classLogic.classes.campaign

import org.classLogic.classes.database.Database
import org.classLogic.classes.playermanager.PlayerManager

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CampaignTest {

    private lateinit var campaign: Campaign
    private val gameMasterId = "12345"

    @BeforeEach
    fun setUp() {
        campaign = Campaign("testCampaign", gameMasterId)
    }

    @Test
    fun initializeCampaignTest() {
        // check if GM was added
        val playerManager = campaign.accessPlayerManager()
        assertEquals(1, playerManager.getPlayers().size, "GM not added to players")
    }

    @Test
    fun changeCampaignStatusTest() {
        val initialStatus = campaign.findStatus()

        campaign.changeStatus(Campaign.Status.IN_PROGRESS)
        val newStatus = campaign.findStatus()
        assertNotEquals(initialStatus, newStatus, "Campaign status failed to change")
    }
}