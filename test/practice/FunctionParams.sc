package practice

object FunctionParams {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
    
  def sum(f: Double=>Double, a:Double, b:Double) : Double  = {
       if(a==b) f(a)
       else f(a) + sum(f, a+1, b)
  }                                               //> sum: (f: Double => Double, a: Double, b: Double)Double
  
  val add3to7 = sum(x=>x, 3,7)                    //> add3to7  : Double = 25.0
  
  val add1to10 = sum(x=>x, 1,10)                  //> add1to10  : Double = 55.0
  
  val addsq1to3 = sum(x=>x*x, 1,3)                //> addsq1to3  : Double = 14.0
  val addcub1to3 = sum(x=>x*x*x, 1,3)             //> addcub1to3  : Double = 36.0
  
  val addInv1to10 = sum(x=>(1/x), 1,10)           //> addInv1to10  : Double = 2.9289682539682538
  
  val addInv1to100 = sum(x=>(1/x), 1,100)         //> addInv1to100  : Double = 5.1873775176396215
  
 
  
}