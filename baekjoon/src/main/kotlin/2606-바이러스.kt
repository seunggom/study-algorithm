import java.util.*

fun main() {
    val computerCount = readln().toInt()
    val nodeCount = readln().toInt()

    val graph = Array<MutableList<Int>>(computerCount + 1) { mutableListOf() }
    val visited = Array<Boolean>(computerCount + 1) { false }

    for (c in 0 until nodeCount) {
        var inputs = readln().split(" ").map { it.toInt() }
        graph[inputs[0]].add(inputs[1])
        graph[inputs[1]].add(inputs[0])
    }

    visited[1] = true

    var queue = LinkedList<Int>()
    queue.add(1)

    var answer = 0

    while(queue.isNotEmpty()) {
        val now = queue.poll()
        for (n in graph[now]) {
            if (!visited[n]) {
                queue.add(n)
                visited[n] = true
                answer++
            }
        }
    }


    print(answer)

}
