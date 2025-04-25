package org.classLogic.campaign

import org.classLogic.database.Database
import org.classLogic.playermanager.PlayerManager

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CampaignTest {

    private lateinit var campaign: Campaign
    private lateinit var emptyCampaign: Campaign
    private val gameMasterId = "12345"
    private val campaignId = "67890"

    @BeforeEach
    fun setUp() {
        emptyCampaign = Campaign("testCampaign", campaignId)
        campaign = Campaign("testCampaign", campaignId, gameMasterId)
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