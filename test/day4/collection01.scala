object collections01 {

  val xs = Seq(1, 2, 3, 5, 60, 70)
  
  xs.apply(0)
    
  def m[T](ys: T*) = ys.length

  m(1, 5, 7, 8)
  m(xs: _*)
  xs.map(_ + 1)

  trait Person {
    def age: Int
    def isAdult: Boolean
  }
  case class Adult(age: Int) extends Person {
    def isAdult = true
  }
  case class Child(age: Int) extends Person {
    def isAdult = false
  }

  object Person extends (Int => Person) {
    def apply(age: Int) = if (age < 18) Child(age) else Adult(age)
  }

  val people = xs.map(Person)

  val adults = people.filter(_.isAdult)
  val children = people.filterNot(_.isAdult)
  val resultTuple = people.partition(_.isAdult)

  resultTuple._1 //adults
  resultTuple._2 //children
  val (adults1, children1) = people.partition(_.isAdult)

  adults1
  children1
  val adult = Adult(100)
  val Adult(age) = adult
  age
  people.take(2)
  people.drop(2)
  people.splitAt(2)

  people.takeWhile(_.age < 5)
  people.dropWhile(_.age < 5)
  people.span(_.age < 5)

  people.sortWith(_.age > _.age)

  people.sortWith(_.age < _.age)

  people.sortBy(_.age).reverse

  val ordering: Ordering[Person] =
    Ordering.fromLessThan[Person]((person1, person2) => person2.age < person1.age)
  people.sorted(ordering)

  people.foldLeft(0) { (total, person) =>
    total + person.age
  }

  people.scanLeft(0) { (total, person) =>
    total + person.age
  }

  people.foldLeft(0) { (total, person) =>
    total + person.age
  }

  def reverse(xs: List[Int]): List[Int] = xs.foldLeft(List.empty[Int]) { (acc, x) =>
    x :: acc
  }

  def reverse1(xs: List[Int]): List[Int] = xs.foldRight(List.empty[Int]) { (x, acc) =>
    acc ::: List(x)
  }

  reverse(List(1,2,3,4))
  reverse1(List(1,2,3,4))

  List(1,2,3,4).reduceLeft { (acc, x) =>
    acc + x
  }


  List(1,2,3,4).reduceLeft(_ + _)
  people.maxBy(_.age)
  people.reduceLeft { (acc, person) =>
     if( acc.age > person.age) acc else person
  }

  people.filter(_.isAdult).map(_.age)



}