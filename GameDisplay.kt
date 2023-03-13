package connectfour

class GameDisplay {
    private var boardSize: String = ""
//TODO make a char array (row, col) that will be as a game board

        fun makeMove(col: Int, board: MutableList<MutableList<Char>>) {
            board[board.size-1][col-1] = 'O'
        }

    fun initBoard(row: Int, col: Int): MutableList<MutableList<Char>> {
        return MutableList(row) { MutableList(col) { ' ' } }
    }

    fun initBoardSize(): List<Int> {

        while (true) {
            println(
                """Set the board dimensions (Rows x Columns)
Press Enter for default (6 x 7)"""
            )
            // delete spaces and transform to lowerCase
            boardSize = readln().replace("\\s+".toRegex(), "").lowercase()

            val board = boardSize.split('x')

            if (boardSize == "") {
                return listOf(6, 7)
            }

            if (!boardSize.contains('x')) {
                println("Invalid input")
                continue
            }

            try {
                board.map { it.toInt() }
            } catch (e: Exception) {
                println("Invalid input")
                continue
            }

            if (board[0].toInt() !in 5..9) {
                println("Board rows should be from 5 to 9")
                continue
            }

            if (board[1].toInt() !in 5..9) {
                println("Board columns should be from 5 to 9")
                continue
            }
            return board.map { it.toInt() }
        }
    }


    // взята функция printBoard из github: https://github.com/macik1423/connectFour/blob/main/connectfour/Main.kt
    fun printBoard(rows: Int, cols: Int, board: MutableList<MutableList<Char>>): String {
        val header = " " + (1..cols).joinToString(" ")
        var body = ""
        for (i in 1..rows) {
            body += board[i - 1].joinToString("║", "║", "║\n")
        }
        var footer = "╚"
        for (i in 0..cols - 2) {
            footer += "═╩"
        }
        footer += "═╝"
        return header + "\n" + body + footer
    }


}