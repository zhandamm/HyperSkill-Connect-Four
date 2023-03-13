package connectfour

val players = Player()
val board = GameDisplay()

fun main() {
    println("Connect Four")

    val playersInfo = players.initPlayers()

    val boardDisplayInfo = board.initBoardSize()
    val row = boardDisplayInfo[0]
    val column = boardDisplayInfo[1]

    var gameBoard = board.initBoard(row, column)

    board.makeMove(1, gameBoard)

    printGameInfo(playersInfo, boardDisplayInfo)
    println(board.printBoard(row, column, gameBoard))

}

fun printGameInfo(player: List<String>, board: List<Int>) {
    println("${player[0]} VS ${player[1]}")
    println("${board[0]} X ${board[1]} board")
}