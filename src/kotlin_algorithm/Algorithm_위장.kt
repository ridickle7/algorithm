package kotlin_algorithm

import java.util.*

class Algorithm_위장 {

    companion object {
        var setList: HashSet<String>? = null
        var mapList: HashMap<String, Int>? = null
        var arrayList: Array<Pair<String, String>>? = null

        @JvmStatic
        fun main(args: Array<String>) {
            var scanner = Scanner(System.`in`)
            var n = scanner.nextInt()

            arrayList = Array(n) {
                Pair("", "")
            }
            setList = HashSet()
            mapList = HashMap()

            for (index in 0 until n) {
                var name = scanner.next()
                var type = scanner.next()

                setList!!.add(type)
                mapList!![type] = (mapList!![type] ?: 0) + 1
                arrayList!![index] = Pair(name, type)
            }

//            for(index in 0 until setList!!.size){
//
//            }
        }
    }
}