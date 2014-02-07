package practice

object WhileLoop {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //implementation of 'While' loop
  
  
  
  /*def DoWhile(condition: =>Boolean,body: =>Unit):Unit = {
      body
  		if(condition) {
  		   DoWhile(condition,body)
  		 }
  }
  
  
  var x=1;
  
  DoWhile(x<=10, {
  		println("Hello " + x)
   		x=x+1})*/
  
  
	  class Do(body: => Unit){
		  def While(condition: =>Boolean) : Unit = {
		     body
		     if(condition) While(condition)
		  }
		  
		}
	  
	  var x=0                                 //> x  : Int = 0
	  
	  new Do( {println(x)
	           x=x+1}) While (x<10)           //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
    
    
    class Do1(body: => Unit){
		  def While(condition: =>Boolean) : Unit = {
		     body
		     if(condition) While(condition)
		  }
		  def apply(body: => Unit): Do1 = new Do1(body)
		}
	  
	  var y=0                                 //> y  : Int = 0
	  
	  new Do1( {println(y); y=y+1}) While (y<10)
                                                  //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
    
  }
  
  
  
  
  