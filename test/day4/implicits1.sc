package day4

import day4.RichValue.Tapper
import day4.RichValue2.QuoteString
import day4.RichValue2.RichString.toRichString
import day4.RichValue2.RichString.toInt

object implicits1 {

  {

    val dd = Seq(1, 2, 3, 4.tap("4"))
      .map(_ + 1).tap("in map")
      .filter(_ > 2).tap()
      .sum.tap("sum")
  }                                               //> 4: 4
                                                  //| in map: List(2, 3, 4, 5)
                                                  //| tapped: List(3, 4, 5)
                                                  //| sum: 12



  "my name is this"                               //> res0: String("my name is this") = my name is this
  //////
  "my name is this".inQuotes.hello                //> res1: String = howdy "my name is this"

  def add(a: Int, b: Int) = a + b                 //> add: (a: Int, b: Int)Int
  add("aaa", "aa")                                //> res2: Int = 5


  def size(xs: Seq[Int]) = xs.length              //> size: (xs: Seq[Int])Int

  size(Array(1, 2, 3))                            //> res3: Int = 3

  Array(1).map(_ + 1)                             //> res4: Array[Int] = Array(2)
}