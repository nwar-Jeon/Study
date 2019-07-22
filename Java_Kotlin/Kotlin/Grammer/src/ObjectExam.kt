object ObjectExam { // 싱글톤을 위한 객체.
    val allEmployees = arrayListOf<String>("aaa","bbb","ccc")
    fun caculate(){
        for(item in allEmployees){
            println(item)
        }
    }
}