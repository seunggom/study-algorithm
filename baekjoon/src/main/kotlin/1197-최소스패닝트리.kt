fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val v = input[0]
    val e = input[1]

    val parent = IntArray(v + 1) { it }
    val allCost = Array(e) { intArrayOf(0, 0, 0) }

    for (i in 0 until e) {
        val line = readln().split(" ").map { it.toInt() }
        allCost[i] = line.toIntArray()
    }
    val sortedCost = allCost.sortedBy { it[2] }

    var answer = 0
    for (c in sortedCost) {
        val first = c[0]
        val second = c[1]
        val cost = c[2]

        val parent1 = findParent(first, parent)
        val parent2 = findParent(second, parent)
        if (parent1 != parent2) {
            if (parent1 < parent2) parent[second] = first
            else parent[first] = second

            answer += cost
        }
    }

    print(answer)
}

fun findParent(node: Int, parent: IntArray): Int {
    if (node == parent[node]) return node
    return findParent(parent[node], parent)
}