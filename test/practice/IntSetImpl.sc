package practice

object IntSetImpl {
  println("Welcome to the Scala worksheet")
  
  abstract class IntSet {  
  	def contains(x:Int):Boolean  
  	def include(x:Int):IntSet  
  }
  
  class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet {  
  	def contains(x:Int):Boolean  =  {
  		if(x < elem) left.contains(x)
  		else if (x > elem) right.contains(x)
  		else true  	
  	} 
  	
  	
  	def include(x:Int):IntSet = {
  		if(x<elem) new NonEmpty(elem, left.include(x), right)
  		else if(x>elem) new NonEmpty(elem, left, right.include(x))
  		else this  	
  	}  
  }
  
  
  class Empty extends IntSet{
  	def contains(x:Int):Boolean = false
  	def include(x:Int):IntSet = new NonEmpty(x, new Empty, new Empty)  
  }
  
}