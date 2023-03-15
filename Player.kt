package connectfour

class Player {
    fun initPlayers(): List<String> {
        println("Connect Four")
        println("First player's name:")
        val player1 = readln()
        println("Second player's name:")
        val player2 = readln()
        return listOf(player1, player2)
    }

    fun makeMove(player: String, symbol: Char, board: MutableList<MutableList<Char>>, cols: Int): Boolean {

        while (true) {
            println("${player}'s turn:")
            val input = readln()
            if (input == "end") {
                println("Game over!")
                return true
            }
            try {
                val columnToPut = input.toInt()

                if (columnToPut !in 1..cols) {
                    println("The column number is out of range (1 - ${cols})")
                    continue
                }
                // finding empty index value of board
                var index = board.size - 1
                while (board[index][columnToPut - 1] != ' ') {
                    index--
                }
                board[index][columnToPut - 1] = symbol
                break
            } catch (e: NumberFormatException) {
                println("Incorrect column number")
            } catch (e: IndexOutOfBoundsException) {
                println("Column ${input.toInt()} is full")
            }
        }
        return false
    }


}
