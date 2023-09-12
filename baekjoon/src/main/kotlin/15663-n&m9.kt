fun main() {
    val input1 = readln().split(" ")
    val n = input1[0].toInt()
    val m = input1[1].toInt()
    // (1 ≤ M ≤ N ≤ 8)

    val numbers = readln().split(" ").map { it.toInt() }.toMutableList()
    numbers.sort()

    dfs9(numbers, BooleanArray(n) { false }, mutableListOf(), m, 0)

    for (a in answer9) {
        println(a)
    }
}

val answer9 = mutableSetOf<String>()
// NOTE: List로 하고 중복 체크하는 조건문 추가하면 시간초과 나게 됨

fun dfs9(numbers: List<Int>, visited: BooleanArray, picked: MutableList<Int>, choice: Int, depth: Int) {
    if (choice == depth) {
        val ans = picked.joinToString(" ")
        answer9.add(ans)
        return
    }

    for (num in numbers.indices) {
        if (!visited[num]) {
            visited[num] = true
            picked.add(numbers[num])
            dfs9(numbers, visited, picked, choice, depth + 1)
            picked.removeLast()
            visited[num] = false
        }
    }
}
