fun main() {
    val size = readln().toInt()
    val bomb = Array<CharArray>(size) { CharArray(size) { '.' } }
    val opened = Array<CharArray>(size) { CharArray(size) { '.' } }

    for (i in 0 until size) {
        bomb[i] = readln().toCharArray()
    }
    for (i in 0 until size) {
        opened[i] = readln().toCharArray()
    }

    var failed = false
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (opened[i][j] == '.') continue

            if (bomb[i][j] == '*') {
                opened[i][j] = '*'
                failed = true
                continue
            }

            var count = 0
            if (i > 0) {
                if (j > 0 && bomb[i - 1][j - 1] == '*') count++
                if (bomb[i - 1][j] == '*') count++
                if (j + 1 < size && bomb[i - 1][j + 1] == '*') count++
            }
            if (i + 1 < size) {
                if (bomb[i + 1][j] == '*') count++
                if (j > 0 && bomb[i + 1][j - 1] == '*') count++
                if (j + 1 < size && bomb[i + 1][j + 1] == '*') count++
            }
            if (j > 0 && bomb[i][j - 1] == '*') count++
            if (j + 1 < size && bomb[i][j + 1] == '*') count++

            opened[i][j] = count.digitToChar()
        }
    }

    if (failed) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (bomb[i][j] == '*') opened[i][j] = '*'
            }
        }
    }


    for (i in 0 until size) {
        for (j in 0 until size) {
            print(opened[i][j])
        }
        if (i < size - 1) println()
    }
}
