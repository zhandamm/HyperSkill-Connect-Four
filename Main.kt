package connectfour

const val ASCII_PLAYER_SYMBOL = 111

val players = Player()
val board = GameDisplay()
val playersInfo = players.initPlayers()

val boardDisplayInfo = board.initBoardSize()
val row = boardDisplayInfo[0]
val column = boardDisplayInfo[1]

val gameBoard = board.initBoard(row, column)

//TODO GAME OVER ДОБАВЛЕНО, ОСТАЛОСЬ ЧТОБЫ СРАЗУ BREAK ВЫЗЫВАЛСЯ И ВСЁ СКИПАЛО (ПРОБЛЕММА В ТОМ ЧТО ВЫВОДИТ ДОСКУ ПОСЛЕ GAME OVER)
fun main() {

    printGameInfo(playersInfo, boardDisplayInfo)
    while (true) {
        updateBoard()
        if (players.makeMove(playersInfo[0], ASCII_PLAYER_SYMBOL.toChar(), gameBoard, column)) {
            break
        }

        updateBoard()
        if (players.makeMove(playersInfo[1], '*', gameBoard, column)) {
            break
        }

    }

}

fun updateBoard() = println(board.printBoard(row, column, gameBoard))

fun printGameInfo(player: List<String>, board: List<Int>) {
    println("${player[0]} VS ${player[1]}")
    println("${board[0]} X ${board[1]} board")
}