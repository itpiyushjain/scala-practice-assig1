package day4

object collections5 {

  trait Person {
    def age: Int
    def country: String
  }
  case class Adult(age: Int, country: String) extends Person
  case class Child(age: Int, country: String) extends Person

  def createPerson(age: Int, country: String) =
    if (age < 18) Child(age, country) else Adult(age, country)

  val ages = Seq(20, 17, 40, 17, 78, 15, 15)
  val countries = Seq("India", "Usa", "Uk", "India", "Uk", "Uk", "France")

  val people: Seq[Person] =
    ages.
      zip(countries).
      map { case (age, country) => createPerson(age, country) }


  val ddd = people.
    groupBy(_.country).
    mapValues(_.size).
    filter{case (country, count) => count > 1}.
    map {case (country, count) => (country, count + 1)}
//    foreach(println)

  ddd foreach println




  val groupsByAge = people.groupBy(_.age)




  val groupsByCountry = people.groupBy(_.country)






  val groupsByCountryPrefix = people.groupBy(_.country.head)











  groupsByAge foreach { x =>
    println(x)
  }














  groupsByCountry map { x =>
    println(x)
  }



  groupsByCountryPrefix map { x =>
    println(x)
  }




}