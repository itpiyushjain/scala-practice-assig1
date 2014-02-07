package day4

object collections3 {
  trait Person {
    def age: Int
    def isAdult = age > 18
  }
  case class Adult(age: Int) extends Person
  case class Child(age: Int) extends Person

  object Person extends (Int => Person) {
    def apply(age: Int) = if (age < 18) Child(age) else Adult(age)
    def make(age: Int, quantity: Int): Seq[Person] =
      1.to(quantity).map(_ => Person(age))
  }

  1 to 5
  1 until 5
  val demand = Map(10 -> 2, 20 -> 3, 40 -> 1)

  val dd1 = demand.map(x => x._1 -> (x._2 + 2))
  val dd2 = demand.map { case (key, value) =>
    (key, value + 2)
  }
  val dd3 = demand.map { case (key, value) =>
    value + 2
  }

  val ps = demand.map { case (key, value) =>
    Person.make(key, value)
  }



  val people = demand.flatMap { case (key, value) =>
    Person.make(key, value)
  }


  case class Ticket(person: Person, city: String)
  val familyMembers = Seq(Person(13), Person(40))
  val cities = Seq("NY", "Pune", "Mumbai", "Nagpur")

  val tickets1 = familyMembers.flatMap { person =>
    cities.filterNot(_ == "NY").map { city =>
      Ticket(person, city)
    }
  }

  familyMembers.foreach { person =>
    cities.filterNot(_ == "NY").foreach { city =>
      Ticket(person, city)
    }
  }

  val tickets2 = for {
    person <- familyMembers
    city <- cities
    if city != "NY"
  } yield {
    Ticket(person, city)
  }


  tickets1 foreach println






  println("/////////////////")
  tickets2 foreach println
  
  }