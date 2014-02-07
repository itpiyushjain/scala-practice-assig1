package practice

object AreaAndShapes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
    
  trait Shape2D{
    def area : Double
  }
  
  trait Shape3D extends Shape2D{
  	def volume : Double
  }
  
  class Square(length:Double) extends Shape2D{
    def area = length*length
  }
  
  class Rectangle(length:Double, width:Double) extends Shape2D {
  	def area = length*width
  }
  
  class Circle(radius:Double) extends Shape2D {
  	def area = 3.14*radius*radius
  }
  
  class Cylinder(radius:Double, length:Double) extends Shape3D {
  	def area = 2*3.14*radius*(radius+length)
  	def volume = 3.14*radius*radius*length
  }
  
  object AreaCalculator{
  	def calcArea(shape: Shape2D) : Double = shape.area
  }
  
  object VolumeCalculator{
  	def calcArea(shape: Shape3D) : Double = shape.volume
  }
  
  AreaCalculator.calcArea(new Circle(5))          //> res0: Double = 78.5
  AreaCalculator.calcArea(new Square(10))         //> res1: Double = 100.0
  AreaCalculator.calcArea(new Rectangle(10,20))   //> res2: Double = 200.0
  AreaCalculator.calcArea(new Cylinder(10,20))    //> res3: Double = 1884.0000000000002
  VolumeCalculator.calcArea(new Cylinder(10,20))  //> res4: Double = 6280.0
}