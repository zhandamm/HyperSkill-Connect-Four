package connectfour

class Player {

    fun initPlayers(): List<String> {
        println("First player's name:")
        val player1 = readln()
        println("Second player's name:")
        val player2 = readln()
        return listOf(player1, player2)
    }

}
