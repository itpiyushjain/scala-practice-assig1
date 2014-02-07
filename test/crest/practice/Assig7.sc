package crest.practice

object Assig7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //factorial
  
  
  def factorial(x:Int) : Int = {
  	if(x > 1) x*factorial(x-1)
  	else 1
  }                                               //> factorial: (x: Int)Int
  
  factorial(3)                                    //> res0: Int = 6
  factorial(4)                                    //> res1: Int = 24
  factorial(5)                                    //> res2: Int = 120
  factorial(6)                                    //> res3: Int = 720
  
}