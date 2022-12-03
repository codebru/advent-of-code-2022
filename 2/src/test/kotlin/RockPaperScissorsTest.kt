import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RockPaperScissorsTest {
    @Test
    fun `GIVEN a strategy guide THEN can work out the total score` () {
        assertEquals(
            15,
            """
                A Y
                B X
                C Z
            """.trimIndent()
                .getTotalScore(::parseQ1)
        )
        assertEquals(
            12,
            """
                A Y
                B X
                C Z
            """.trimIndent()
                .getTotalScore(::parseQ2)
        )
    }

    @Test
    fun `GIVEN a strat sheet THEN can transfer into usable format` () {
        assertEquals(
            listOf(
                listOf(RockPaperScissors.ROCK, RockPaperScissors.PAPER),
                listOf(RockPaperScissors.PAPER, RockPaperScissors.ROCK),
                listOf(RockPaperScissors.SCISSORS,RockPaperScissors.SCISSORS),
            ),
            parseQ1("""
                A Y
                B X
                C Z
            """.trimIndent())
        )
        assertEquals(
            listOf(
                listOf(RockPaperScissors.ROCK, RockPaperScissors.ROCK),
                listOf(RockPaperScissors.PAPER, RockPaperScissors.ROCK),
                listOf(RockPaperScissors.SCISSORS,RockPaperScissors.ROCK),
            ),
            parseQ2("""
                A Y
                B X
                C Z
            """.trimIndent())
        )
        
        
    }

    @Test
    fun `GIVEN a letter THEN can map to Rock Paper or Scissors`() {
        assertEquals(
            RockPaperScissors.ROCK,
            "A".getRockPaperScissors()
        )
    }

    @Test
    fun `GIVEN a round THEN can work out pick score`() {
        assertEquals(
            3,
            listOf(RockPaperScissors.ROCK, RockPaperScissors.SCISSORS)
                .getPickScore()
        )
    }

    @Test
    fun `GIVEN a round THEN can work out the winloss score`() {
        assertEquals(
            3,
            listOf(RockPaperScissors.ROCK, RockPaperScissors.ROCK)
                .getWinLossScore()
        )
    }
}