package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String) : String
    fun isMax(maxString: String) : Boolean

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            when {
                step < 1 -> throw IllegalStateException("step shoud be positive, but was $step")
//                max < 1 -> throw IllegalStateException("max shoud be positive, but was $max")
//                max <= step -> throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): String {
            val digits = number.toInt()
            val result = digits + step
            return result.toString()
        }

        override fun isMax(maxString: String) : Boolean {
            val result = maxString.toInt()
            return if (result == max) {
                true
            } else {
                false
            }
        }
    }


}