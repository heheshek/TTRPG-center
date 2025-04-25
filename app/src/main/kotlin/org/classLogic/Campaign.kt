package org.classLogic.campaign

import org.classLogic.database.Database
import org.classLogic.playermanager.PlayerManager
import org.classLogic.player.Player

import java.io.File

class Campaign {
    var name: String
    val campaignID: String
    val basePath: String
    
    enum class Status { IN_PREPARATION, IN_PROGRESS, FINISHED }
    var status: Status = Status.IN_PREPARATION

    var playerManager: PlayerManager
    var database: Database

    constructor( setName: String, setCampaignID: String ) {
        name = setName
        campaignID = setCampaignID

        basePath = "CampaignData/$campaignID/"
        initializeDirectory()

        playerManager = PlayerManager()
        database = Database(basePath)
    }

    constructor( setName: String, setCampaignID: String, gmID: String ) {
        name = setName
        campaignID = setCampaignID

        basePath = "CampaignData/$campaignID/"
        initializeDirectory()

        playerManager = PlayerManager()
        database = Database(basePath)

        playerManager.addPlayer( Player.initializeGameMaster( "Game Master", gmID, Player.PType.GM ) )
    }

    private fun initializeDirectory() {
        val directory = File(basePath)
        if (!directory.exists()) {
            directory.mkdirs()
        }
    }

    fun accessPlayerManager(): PlayerManager {
        return playerManager
    }
    fun accessDatabase(): Database? {
        return database
    }

    fun changeStatus(newStatus: Status) {
        //status = newStatus
    }
    fun findStatus(): Status {
        return status
    }
}
