package practice
import play.api.libs.ws.{Response, WS}
import scala.util.{Success,Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future,Promise}


object FuturesDemo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def getFutureResponseBasedOnEvent(success: Response => Int, failure: Throwable => Any) = {
  		val res = WS.url("http://www.google.co.in").get()
  		  res.onComplete{
  				case Success(res) => println(success(res))
  				case Failure(ex) => failure(ex)
  		}
  }                                               //> getFutureResponseBasedOnEvent: (success: play.api.libs.ws.Response => Int, f
                                                  //| ailure: Throwable => Any)Unit
  
  def wsGet(url:String) : Future[Response] = {
  	 val p = Promise[Response]()
  	 
  	 //val r = Response[Int]()
     WS.url(url).get().onComplete(p.complete)
     p.future
  }                                               //> wsGet: (url: String)scala.concurrent.Future[play.api.libs.ws.Response]
  
  
  
  //val x = getFutureResponseBasedOnEvent(res => res.body.lines.size,
    //                                    ex => println(ex))
  
}