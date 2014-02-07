package day4

object collections6 {

  def throws(a: Int) = a match {
    case 1 => throw new NoSuchElementException
    case 2 => throw new IllegalArgumentException
  }

  def test(a: Int)= try {
    throws(a)
  } catch {
    case ex: NoSuchElementException => 1
    case ex: IllegalArgumentException => 2
  }
  test(1)
  test(2)
  def divide10(param: Int) = {
    require(param != 0, "Cant divide by ZERO")
    10 / param
  }
  divide10(1)
  assert(test(1) == 1, "test failed")
  def javaMethod(a: Int) = if(a > 10) a.toString else null
  Option(javaMethod(9)).getOrElse("tada")
}