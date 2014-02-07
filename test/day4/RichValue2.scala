package day4

object RichValue2 {

  implicit class Tapper1[T](val x: T) extends AnyVal {
    def tap(msg: String = "tapped") = {
      println(s"$msg: $x")
      x
    }
  }

  implicit class QuoteString(val str: String) extends AnyVal {
    def inQuotes = '"' + str + '"'
    def stripQuotes = str.stripPrefix("\"").stripSuffix("\"")
  }

  class RichString(val str: String) {
    def hello = s"howdy $str"
  }

  object RichString {
    implicit def toRichString(str: String) = new RichString(str)
    implicit def toInt(str: String) = str.length
  }


}