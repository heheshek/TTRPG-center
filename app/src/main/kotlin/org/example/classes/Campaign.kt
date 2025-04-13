package org.classLogic.classes.campaign

import org.classLogic.classes.database.Database
import org.classLogic.classes.playermanager.PlayerManager

class Campaign {
    var name: String
    
    enum class Status { IN_PREPARATION, IN_PROGRESS, FINISHED }
    var status: Status = Status.IN_PREPARATION

    var playerManager: PlayerManager
    var database: Database

    constructor( setName: String, gmID: String ) {
        name = setName
        playerManager = PlayerManager()
        database = Database()
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
