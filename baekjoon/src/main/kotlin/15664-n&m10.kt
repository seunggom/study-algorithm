fun main() {
    val input1 = readln().split(" ")
    val n = input1[0].toInt()
    val m = input1[1].toInt()
    // (1 ≤ M ≤ N ≤ 8)

    val numbers = readln().split(" ").map { it.toInt() }.toMutableList()
    numbers.sort()

    dfs10(numbers, BooleanArray(n) { false }, mutableListOf(), m, 0, 0)

    for (a in answer10) {
        println(a)
    }
}

val answer10 = mutableSetOf<String>()

fun dfs10(numbers: List<Int>, visited: BooleanArray, picked: MutableList<Int>, choice: Int, depth: Int, startIndex: Int) {
    if (choice == depth) {
        val ans = picked.joinToString(" ")
        answer10.add(ans)
        return
    }

    var prev = -1
    for (num in startIndex until numbers.size) {
        if (!visited[num] && prev <= numbers[num]) {
            visited[num] = true
            picked.add(numbers[num])
            prev = numbers[num]
            dfs10(numbers, visited, picked, choice, depth + 1, num + 1)
            picked.removeLast()
            visited[num] = false
        }
    }
}
