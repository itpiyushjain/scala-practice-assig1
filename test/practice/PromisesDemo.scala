package practice
import play.api.libs.ws.{Response, WS}
import scala.util.{Success,Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future,Promise}


class PromisesDemo {
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
	}
	
	def traverseSites(sites:Seq[String]) = {
	  val futures : Seq[Future[Response]] = sites.map(site => WS.url(site).get())
	  Future.traverse(futures) { future => future.map(res => res.body.lines.length) }
	}
	
	/*def sequenceFuture(futures: Seq[Future[Int]]) : Future[Seq[Int]] = {
	  val zero = Future.successful(Seq.empty[Int])
	  futures.foldLeft(zero){
	    (resultFutures,elemF) =>  resultFutures+elemF
	    
	  }
	  
	}*/
		
}

object ProDemo{  
  val demo = new PromisesDemo() 
}