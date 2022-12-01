fun String.topOneTotal(): Int = this.topNTotal(1)

fun String.getIndividualLists(): List<String> = this
    .split("\n\n")

fun String.getIndividualTotals(): List<Int> = this
    .getIndividualLists()
    .map{ individualList -> individualList.getTotalCalories() }

fun List<Int>.accumilateCallories(): Int = this
    .reduce{ acc, entry -> acc + entry }

fun String.getTotalCalories(): Int = this
    .split("\n")
    .map { word -> word.toInt() }
    .accumilateCallories()

fun String.topThreeTotal(): Int = this.topNTotal(3)

fun String.topNTotal(n: Int): Int = this
    .getIndividualTotals()
    .sortedDescending()
    .take(n)
    .accumilateCallories()