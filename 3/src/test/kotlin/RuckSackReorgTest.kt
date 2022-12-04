import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RuckSackReorgTest {
    @Test
    fun `GIVEN a rucksack list THEN can find the find the total priority of the repeated items`() {
        assertEquals(
            157,
            """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
            """.trimIndent()
                .getPriorityRepeatedItems()
        )
    }

    @Test
    fun `GIVEN a rucksack list THEN can parse into a usable format`() {
        val cargo = TroopCargo(
            listOf(
                ElfRuckSack(
                    "vJrwpWtwJgWr",
                    "hcsFMMfFFhFp",
                ),
                ElfRuckSack(
                    "jqHRNqRjqzjGDLGL",
                    "rsFMfFZSrLrFZsSL",
                ),
            )
        )

        assertEquals(
            cargo,
            """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            """.trimIndent()
                .parse()
        )
    }

    @Test
    fun `GIVEN and elf rucksack FIND repeted item`() {
        assertEquals(
            'p',
            ElfRuckSack(
                "vJrwpWtwJgWr",
                "hcsFMMfFFhFp",
            ).findDuplicate()
        )
    }
}