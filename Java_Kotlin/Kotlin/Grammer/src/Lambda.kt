class Lambda {

    companion object {
        fun run() {
            val array = ArrayList<Person>()
            array.maxBy({ p : Person -> p.name }) // 람다의 기본형태
            array.maxBy() { p : Person -> p.name } // 함수 인자의 마지막 인자가 람다라면, 람다식을 () 밖으로 뺄 수 있음.
            array.maxBy { p : Person -> p.name } // 람다가 함수의 유일한 인자라면, ()를 뺄 수 있음.
            array.maxBy { p -> p.name } // 파라미터의 타입을 컴파일러가 추론하여 생략함.
            array.maxBy { it.name } // 람다 파라미터가 하나라면, it으로 사용할 수 있음. (람다가 중첩되는경우 사용 X.)
            array.maxBy {
                println("")
                println("")
                it.name
            } // 람다의 마지막 줄이 람다의 값이 됨.
        }
    }
}

class Person(
        val name: String
)