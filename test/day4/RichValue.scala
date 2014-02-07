package day4

object RichValue {

  implicit class Tapper[T](val x: T) extends AnyVal {
    def tap(msg: String = "tapped") = {
      println(s"$msg: $x")
      x
    }
  }
}