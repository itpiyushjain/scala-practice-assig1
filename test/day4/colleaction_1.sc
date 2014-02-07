package day4

object colleaction_1 {
  println("Welcome to the Scala worksheet")
  
  trait Person {
    def age: Int
    def isAdult = age > 18
  }
  case class Adult(age: Int) extends Person
  case class Child(age: Int) extends Person

  object Person {
    def apply(age: Int) = if (age < 18) Child(age) else Adult(age)
  }

  case class Ticket(person: Person, city: String);

  val familyMembers = Seq(Person(10), Person(25), Person(45), Person(50))
  
  val cities = Seq("NY", "Pune", "Mumbai", "Nagpur")

  val tickets = familyMembers.
                withFilter(_.isAdult).
                flatMap { person => cities.map { city => Ticket(person, city) } }

  val tickets1 = for {
    person <- familyMembers.toList
    if person.isAdult
    city <- cities.toArray
  } yield {
    Ticket(person, city)
  }

 tickets1 foreach println
                                                  
  //get ticket for each family member with age > 40
 val tickets3 = familyMembers.filter(_.age > 40)
              .flatMap( member => cities.map{city => Ticket(member,city)}) 
              
              
 val personTickets = tickets3.groupBy(_.person)
 val cityTickets = tickets3.groupBy(_.city)
 
 val cityTicketCounts = cityTickets.mapValues(x => x.size)
 
 def main(args: Array[String]) = {
    println("test")
 }
  
}