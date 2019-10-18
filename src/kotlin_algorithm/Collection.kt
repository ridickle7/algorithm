package kotlin_algorithm

class Collection {
    companion object {
        var array = arrayOf(
                intArrayOf(1, 0, 5),
                intArrayOf(2, 2, 2),
                intArrayOf(3, 3, 1),
                intArrayOf(4, 4, 1),
                intArrayOf(5, 10, 2)
        )

        @JvmStatic
        fun main(args: Array<String>) {
            var abcd = array.sortedWith(
                    compareBy({ it[2] }, { it[1] })
            )

            System.out.print("")
        }
    }
}