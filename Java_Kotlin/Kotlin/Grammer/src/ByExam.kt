import java.util.*

class ByExam <T> (val innerSet : MutableCollection<T> = HashSet()) : MutableCollection<T> by innerSet{
    var countAdd = 0
    override fun add(element: T): Boolean {
        countAdd++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        countAdd+=elements.size
        return innerSet.addAll(elements)
    }
}