import java.util.*

fun main() {
    val testCaseCount = readln().toInt()
    val answer = mutableListOf<Int>()
    for (c in 1..testCaseCount) {
        val inputs = readln().split(" ").map { it.toInt() }
        val maxX = inputs[0]
        val maxY = inputs[1]
        val baechooCount = inputs[2]
        val points = Array<Array<Boolean>>(maxX) { Array<Boolean>(maxY) { false } }

        for (w in 0 until baechooCount) {
            val p = readln().split(" ").map { it.toInt() }
            points[p[0]][p[1]] = true
        }
        answer.add(calculateWorm(maxX, maxY, baechooCount, points))
    }

    for (a in 0 until answer.count()) {
        print(answer[a])
        if (a != answer.count() - 1) println()
    }
}

fun calculateWorm(maxY: Int, maxX: Int, baechooCount: Int, points: Array<Array<Boolean>>): Int {
    val visited = Array<Array<Boolean>>(maxY) { Array<Boolean>(maxX) { false } }
    val queue = LinkedList<Point>()
    var result = 0

    var shouldBreak = false
    for (y in 0 until maxY) {
        for (x in 0 until maxX) {
            if (points[y][x] && !visited[y][x]) {
                queue.add(Point(x, y))
                visited[y][x] = true
                shouldBreak = true
                break
            }
        }
        if (shouldBreak) break
    }

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        var right = false
        var down = false

        // down
        if (now.x + 1 < maxX && points[now.y][now.x + 1]) {
            if (!visited[now.y][now.x + 1]) {
                queue.add(Point(now.x + 1, now.y))
                visited[now.y][now.x + 1] = true
            }
            down = true
        }
        // right
        if (now.y + 1 < maxY && points[now.y + 1][now.x]) {
            if (!visited[now.y + 1][now.x]) {
                queue.add(Point(now.x, now.y + 1))
                visited[now.y + 1][now.x] = true
            }
            right = true
        }

        if (!right && !down) {
            result++
        } else continue


        shouldBreak = false
        for (y in 0 until maxY) {
            for (x in 0 until maxX) {
                if (points[y][x] && !visited[y][x]) {
                    queue.add(Point(x, y))
                    visited[y][x] = true
                    shouldBreak = true
                    break
                }
            }
            if (shouldBreak) break
        }
    }

    return result
}

data class Point(val x: Int, val y: Int)