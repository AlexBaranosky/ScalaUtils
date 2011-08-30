
class RichInt(n: Int) {
    def times(body: => Unit) = 1 to n foreach { body() }
}

object RichInt(n: Int) {
    implicit def int2RichInt(n: Int) = new RichInt(n)
}

