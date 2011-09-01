package utils

class RichInt(n: Int) {
    def times(body: => Unit) = 1 to n foreach { _ => body }
}

object RichInt {
    implicit def int2RichInt(n: Int) = new RichInt(n)
}

object Closable {
    def using[C <: {def close(): Unit}, T](closable: C)(body: C => T): T = {
        try { body(closable) } finally { closable.close() }
    }
}

object Main {
    import RichInt._

    def main(args: Array[String]) {
        5.times {
            println("jerk")
        }
    }
}
