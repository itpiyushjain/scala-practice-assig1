package day4

object collections2 {

  trait Person {
    def age: Int
    def isAdult = age > 18
  }
  case class Adult(age: Int) extends Person
  case class Child(age: Int) extends Person

  object Person extends (Int => Person) {
    def apply(age: Int) = if (age < 18) Child(age) else Adult(age)
  }

  val xs = Seq(1, 2, 3, 5, 60, 70)
  val people = xs.map(Person)


  val f: Function1[Int, String] = {
    x => x.toString
  }

  val pf: PartialFunction[Int, String] = {
    case x if x > 3   => x.toString
    case x if x < -30 => x.toString
  }

  if(pf.isDefinedAt(2))
    pf(2)
  else
    "kkj"



  people.map {
    case Child(age1) => Child(age1 + 10)
    case Adult(age1) => Adult(age1 - 10)
  }



  people.collect {
    case Child(age1) => Child(age1 + 10)
  }




  val pf1: PartialFunction[Person, Person] = {
    case Child(age1) => Child(age1 + 10)
  }
  
   val pf2: PartialFunction[Person, Person] = {
    case Adult(age) => Adult(age + 5)
  }

  people.collect(pf1)
  people.filter(pf1.isDefinedAt).map(pf1)
  
  people.filter(pf2.isDefinedAt).map(pf2)

}
