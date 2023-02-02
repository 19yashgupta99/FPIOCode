import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

object REPL extends App {

  //code to show the side effects/ the impure function
  def sayHello():Unit = {
    println("Enter your name:")
    val name = scala.io.StdIn.readLine()
    println(f"Hey $name")
  }

  // code to show referential transparency

  //pure function
  def sum(x: Int, y:Int): Int = {
    x + y
  }

  /**
   * Referential transparency can be achieved only when the function is pure
   * A Function or an Expression is Referentially Transparent if you can replace it with its value
   * without changing the meaning of the program (and vice versa)
   */

    println(2 + 3)
    println(5)

  //but it will print nothing if I provide ()

  //calling sum for any set of integer will give you a deterministic result

  sum(1, 1) // result = 2

  def demo(f1: Unit, f2: Unit): Unit = ()

  val x = println("Hey fellows")

  demo(x, x)

  demo(println("Hey!!"), println("Heyy"))

  /**
   * The runtime just evaluates the side-effect (read eager evaluation),
   * without giving us any chance to stop that from happening or manipulating it.
   *
   * The solution to our problem comes with the ability to control WHEN these effects get evaluated.
   *
   */


  def fooA(): Future[Int] = {
    def future = Future {
      println("Scala"); 5
    }
    for {
      a <- future
      b <- future
    } yield a + b
  }

  def fooB(): Future[Int] = {
    val future = Future {
      println("Scala"); 5
    }
    for {
      a <- future
      b <- future
    } yield a + b
  }
  /*
  scala> fooB()
  Scala //
  res6: scala.concurrent.Future[Int] = Future(<not completed>) // We don't have any control on the execution
  */
}
