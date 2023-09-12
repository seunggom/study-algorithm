fun main() {
    val input1 = readln().split(" ")
    val n = input1[0].toInt()
    val m = input1[1].toInt()
    // (1 ≤ M ≤ N ≤ 8)

    val numbers = readln().split(" ").map { it.toInt() }.toMutableList()
    numbers.sort()

    dfs11(numbers, mutableListOf(), m, 0)

    print(stringBuilder)
}

val stringBuilder = StringBuilder()

fun dfs11(numbers: List<Int>, picked: MutableList<Int>, choice: Int, depth: Int) {
    if (choice == depth) {
        val str = StringBuilder()
        for (s in 0 until picked.size) {
            str.append(picked[s]).append(if (s == picked.size - 1) "\n" else " ")
        }
        stringBuilder.append(str)
        return
    }

    var prevNum = -1
    for (num in numbers.indices) {
        if (prevNum != numbers[num]) {
            picked.add(numbers[num])
            prevNum = numbers[num]
            dfs11(numbers, picked, choice, depth + 1)
            picked.removeLast()
        }
    }
}
