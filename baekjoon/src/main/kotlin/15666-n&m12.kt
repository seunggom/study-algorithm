fun main() {
    val input1 = readln().split(" ")
    val n = input1[0].toInt()
    val m = input1[1].toInt()
    // (1 ≤ M ≤ N ≤ 8)

    val numbers = readln().split(" ").map { it.toInt() }.toMutableList()
    numbers.sort()

    dfs12(numbers, mutableListOf(), m, 0, 0)

    print(stringBuilder12)
}

val stringBuilder12 = StringBuilder()

fun dfs12(numbers: List<Int>, picked: MutableList<Int>, choice: Int, depth: Int, startIndex: Int) {
    if (choice == depth) {
        val str = StringBuilder()
        for (s in 0 until picked.size) {
            str.append(picked[s]).append(if (s == picked.size - 1) "\n" else " ")
        }
        stringBuilder12.append(str)
        return
    }

    var prevNum = -1
    for (num in startIndex until numbers.size) {
        if (prevNum < numbers[num]) {
            picked.add(numbers[num])
            prevNum = numbers[num]
            dfs12(numbers, picked, choice, depth + 1, num)
            picked.removeLast()
        }
    }
}
