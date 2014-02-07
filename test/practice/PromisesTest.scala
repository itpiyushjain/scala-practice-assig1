package practice

import org.specs2.mutable.Specification
import org.specs2.mutable.Specification

import akka.util.Timeout

class PromisesTest extends Specification {
  
  implicit val timeout = Timeout(5000)
  
  "testFutureReponseBasedOnEvents" in {    
    val demo = new PromisesDemo()
    demo.getFutureResponseBasedOnEvent(res => res.body.length(), ex => println(ex.getMessage()))
    true mustEqual true    
  } 
  
  "testWsCall" in {
     val demo = new PromisesDemo()
     demo.wsGet("www.google.com")
     true mustEqual true
  }

}