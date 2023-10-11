fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]

    val parent = IntArray(n + 1) { it }
    val size = IntArray(n + 1) { 1 }
    val inputs = mutableListOf<List<Int>>()
    for (i in 0 until m) {
        val data = readln().split(" ").map { it.toInt() }
        inputs.add(data)
    }

    for (i in 0 until m) {
        val a = inputs[i][1]
        val b = inputs[i][2]
        when (inputs[i][0]) {
            0 -> {
                unite(a, b, parent, size)
            }

            1 -> {
                if (find(a, parent) == find(b, parent)) println("YES")
                else println("NO")
            }
        }
    }
}

fun find(node: Int, parent: IntArray): Int {
    if (node == parent[node]) return node
    parent[node] = find(parent[node], parent)
    return parent[node]
}

fun unite(a: Int, b: Int, parent: IntArray, size: IntArray) {
    val aParent = find(a, parent)
    val bParent = find(b, parent)

    if (aParent == bParent) return

    if (size[aParent] > size[bParent]) {
        parent[bParent] = aParent
        size[aParent] += size[bParent]
    } else {
        parent[aParent] = bParent
        size[bParent] += size[aParent]
    }
}