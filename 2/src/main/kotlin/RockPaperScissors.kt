enum class RockPaperScissors {
    ROCK, PAPER, SCISSORS,
}

fun String.getTotalScore(): Int = this
    .parse()
    .let{
        var total = 0
        it.forEach { row ->
            run {
                total += row.getPickScore()
                total += row.getWinLossScore()
            }
        }
        return total
    }

fun List<RockPaperScissors>.getPickScore(): Int = this[1]
    .let{
        when(it) {
            RockPaperScissors.ROCK -> 1
            RockPaperScissors.PAPER -> 2
            RockPaperScissors.SCISSORS -> 3
        }
    }

fun List<RockPaperScissors>.getWinLossScore(): Int = if(
    (this[0] == RockPaperScissors.ROCK) && (this[1] == RockPaperScissors.SCISSORS) ||
    (this[0] == RockPaperScissors.SCISSORS) && (this[1] == RockPaperScissors.PAPER) ||
    (this[0] == RockPaperScissors.PAPER) && (this[1] == RockPaperScissors.ROCK)) 0
else if(
    (this[1] == RockPaperScissors.ROCK) && (this[0] == RockPaperScissors.SCISSORS) ||
    (this[1] == RockPaperScissors.SCISSORS) && (this[0] == RockPaperScissors.PAPER) ||
    (this[1] == RockPaperScissors.PAPER) && (this[0] == RockPaperScissors.ROCK)
) 6
else 3

fun String.parse(): List<List<RockPaperScissors>> = this
    .split('\n')
    .map{
            row -> row.split(' ')
        .map{
                code -> code
            .getRockPaperScissors()
        }
    }


fun String.getRockPaperScissors(): RockPaperScissors = when(this) {
    "A",
    "X" ->
        RockPaperScissors.ROCK
    "B",
    "Y" ->
        RockPaperScissors.PAPER
    "C",
    "Z" ->
        RockPaperScissors.SCISSORS
    else -> throw Exception("Unknown game entry: $this")
}