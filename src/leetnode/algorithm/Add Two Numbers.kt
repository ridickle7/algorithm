package leetnode.algorithm

import leetnode.Solve

class `Add Two Numbers` {
    val solve = object : Solve {
        var l1: ListNode? = null
        var l2: ListNode? = null
        override fun solution() {
            addTwoNumbers(l1, l2)
        }

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            val result: ListNode? = null
            var (target1, target2) = Pair(l1?.`val` ?: -1, l2?.`val` ?: -1)

            while (target1 != -1 && target2 != -1) {

            }

            return null;
        }

        override fun testSolve() {

        }

        override fun input() {
            l1 = ListNode(2).apply {
                next = ListNode(4)
                next?.next = ListNode(3)
            }

            l2 = ListNode(5).apply {
                next = ListNode(6)
                next?.next = ListNode(4)
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}