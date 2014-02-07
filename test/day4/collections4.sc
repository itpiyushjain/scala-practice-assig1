package day4

object collections4 {


  val x: Option[Int] = Some(1)

  def incr(x: Option[Int]) = x match {
    case Some(v) => Some(v + 1)
    case None    => None
  }

  incr(x)

  x.map(_ + 1)
  x.flatMap(v => Some(v + 1))

  val hashMap = Map(1 -> "a", 2 -> "b")

  val dd = for {
    v1 <- hashMap.get(1)
    v2 <- hashMap.get(20)
    if v1 != v2
  } yield v1 + v2

}