import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ElfFoodTest {
    val baseList = """
                1000
                2000
                3000

                4000

                5000
                6000

                7000
                8000
                9000

                10000
            """.trimIndent()

    // Part 1
    @Test
    fun `GIVEN the list of foods THEN can find the highest amount`() {
        assertEquals(
            24000,
            baseList
                .topOneTotal()
        )
    }

    @Test
    fun `GIVEN the list of foods THEN can greak into sepperate people's lists`() {
        assertEquals(
            listOf(
                """
                1000
                2000
                3000
""".trimIndent(),
                """
                4000
                """.trimIndent(),
                """
                5000
                6000
                """.trimIndent(),
                """
                7000
                8000
                9000
""".trimIndent(),
                """
                10000
                """.trimIndent(),
            ),
            baseList.getIndividualLists()
        )
    }

    @Test
    fun `GIVEN individual one elf's list THEN get total`() {
        assertEquals(
            24000,
            """
                7000
                8000
                9000
            """.trimIndent()
                .getTotalCalories()
        )
    }

    // Part 2
    @Test
    fun `Given the list for all elfs THEN get the total for the top 3`() {
        assertEquals(
            45000,
            baseList.topThreeTotal()
        )
    }
}