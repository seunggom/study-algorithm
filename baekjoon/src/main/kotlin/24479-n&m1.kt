val answer = mutableListOf<String>()

fun main() {
    val input = readln().split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()
    // (1 ≤ M ≤ N ≤ 8)

    val numbers = List<Int>(n + 1) { it + 1 }
    dfs(numbers, BooleanArray(n + 1) { false }, mutableListOf(), m, 0)
}


fun dfs(numbers: List<Int>, visited: BooleanArray, picked: MutableList<Int>, choice: Int, depth: Int) {
    if (choice == depth) {
        println(picked.joinToString(" "))
        answer.add(picked.joinToString(" "))
        return
    }

    for (num in 1 until numbers.size) {
        if (!visited[num]) {
            visited[num] = true
            picked.add(num)
            dfs(numbers, visited, picked, choice, depth + 1)
            picked.removeLast()
            visited[num] = false
        }
    }
}
