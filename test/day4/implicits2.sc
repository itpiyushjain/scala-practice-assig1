package day4

object implicits2 {

  trait Monoid[T] {
    def zero: T
    def plus(a: T, b: T): T
  }

  implicit val intMonoid = new Monoid[Int] {
    def zero = 0
    def plus(a: Int, b: Int) = a + b
  }                                               //> intMonoid  : day4.implicits2.Monoid[Int] = day4.implicits2$$anonfun$main$1$$
                                                  //| anon$1@7d26f75b

  implicit val stringMonoid = new Monoid[String] {
    def zero = ""
    def plus(a: String, b: String) = a + b
  }                                               //> stringMonoid  : day4.implicits2.Monoid[String] = day4.implicits2$$anonfun$ma
                                                  //| in$1$$anon$2@1b016632
  implicit def pairMonoid[S, T](implicit s: Monoid[S], t: Monoid[T]) = new Monoid[(S, T)] {
    def zero = (s.zero, t.zero)
    def plus(a: (S, T), b: (S, T)) = (s.plus(a._1, b._1), t.plus(a._2, b._2))
  }                                               //> pairMonoid: [S, T](implicit s: day4.implicits2.Monoid[S], implicit t: day4.i
                                                  //| mplicits2.Monoid[T])day4.implicits2.Monoid[(S, T)]
  val ints = Seq(1, 2, 3)                         //> ints  : Seq[Int] = List(1, 2, 3)
  val strings = Seq("a", "b", "c")                //> strings  : Seq[String] = List(a, b, c)

  val pairs1 = ints.zip(strings)                  //> pairs1  : Seq[(Int, String)] = List((1,a), (2,b), (3,c))
  val pairs2 = strings.zip(ints)                  //> pairs2  : Seq[(String, Int)] = List((a,1), (b,2), (c,3))

  def sum[T](xs: Seq[T])(implicit monoid: Monoid[T]) =
    xs.foldLeft(monoid.zero)(monoid.plus)         //> sum: [T](xs: Seq[T])(implicit monoid: day4.implicits2.Monoid[T])T

  sum(ints)                                       //> res0: Int = 6
  sum(strings)                                    //> res1: String = abc
  sum(pairs1)                                     //> res2: (Int, String) = (6,abc)
  sum(pairs2)                                     //> res3: (String, Int) = (abc,6)



}