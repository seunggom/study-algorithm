fun main() {
    val input = readln().toInt()

    /*
    1 -> 1
    2 -> 5
    3 -> 9
    4 -> 13

    1

    양옆빈칸 2
    양옆별 2

    양옆빈칸 2
    양옆별 2

    양옆빈칸 2
    양옆별 2

    +4
     */

    val list = mutableListOf<MutableList<Char>>()
    for (i in 1..input) {
        if (i == 1) list.add(mutableListOf('*'))
        else {
            for (l in list.indices) {
                list[l].addAll(0, listOf('*', ' '))
                list[l].addAll(listOf(' ', '*'))
            }

            val width = (i - 1) * 4 + 1
            val newList = MutableList<Char>(width) { ' ' }
            newList[0] = '*'
            newList[width - 1] = '*'
            list.add(0, newList)
            list.add(newList.map { it }.toMutableList())

            list.add(0, MutableList(width) { '*' })
            list.add(MutableList(width) { '*' })
        }
    }


    for (element in list) {
        for (e in element.indices) print(element[e])
        println()
    }
}
