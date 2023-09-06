fun main() {
    val inputs = readln().split(" ")
    val nodeCount = inputs[0].toInt()
    val edgeCount = inputs[1].toInt()
    val startNodeNum = inputs[2].toInt()

    val graph = Graph(nodeCount)
    for (e in 1..edgeCount) {
        val inputs = readln().split(" ")
        graph.addEdge(inputs[0].toInt(), inputs[1].toInt())
    }

    graph.sortEdges()

    dfs(graph, graph.nodes[startNodeNum - 1])

    for (i in 1..nodeCount) println(graph.history[i])
}

class Graph(val size: Int) {
    var counter = 1

    data class Node(val data: Int, val adjacent: MutableList<Node> = mutableListOf(), var visited: Boolean = false)

    val history = MutableList<Int>(size + 1) { 0 }
    val nodes = List<Node>(size) { Node(it + 1) }

    fun addEdge(n1: Int, n2: Int) {
        nodes[n1 - 1].adjacent.add(nodes[n2 - 1])
        nodes[n2 - 1].adjacent.add(nodes[n1 - 1])
    }

    fun sortEdges() {
        for (i in 0 until size) {
            nodes[i].adjacent.sortBy { it.data }
        }
    }
}

fun dfs(graph: Graph, node: Graph.Node) {
    node.visited = true
    graph.history[node.data] = graph.counter
    graph.counter++
    for (ad in node.adjacent) {
        if (!ad.visited) {
            dfs(graph, ad)
        }
    }
}
