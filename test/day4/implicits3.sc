package day4

object implicits3 {

  def add(a: Int)(implicit b: Int) = a + b        //> add: (a: Int)(implicit b: Int)Int
  
  {
    implicit val x = 10
    add(100)
  }                                               //> res0: Int = 110
  
  }