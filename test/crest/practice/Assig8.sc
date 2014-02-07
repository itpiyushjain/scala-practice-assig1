package crest.practice


object Assig8 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
    //factorial using tail recursion
  
  		def factInt(x:Int, acc:Int):Int = {
  		  if(x <=1) acc
  		  else  factInt(x-1, acc*x)
  		}                                 //> factInt: (x: Int, acc: Int)Int
  		
  factInt(3,1)                                    //> res0: Int = 6
  factInt(4,1)                                    //> res1: Int = 24
  factInt(5,1)                                    //> res2: Int = 120
  
  def fact(x:Int) : Int =  {
  		def factInt(x:Int, acc:Int):Int = {
  		  if(x <=1) acc
  		  else  factInt(x-1, acc*x)
  		}
  	factInt(x,1)
  }                                               //> fact: (x: Int)Int
  
  fact(3)                                         //> res3: Int = 6
  fact(4)                                         //> res4: Int = 24
  fact(5)                                         //> res5: Int = 120
  fact(6)                                         //> res6: Int = 720
  
  
}