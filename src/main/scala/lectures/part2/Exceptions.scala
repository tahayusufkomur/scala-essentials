package lectures.part2
import exercises.{Cons, Empty, MyList}

object Exceptions extends App{
  
  // println(null.length) crashes to program
  
  
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42
  
  
  val potentialFail = try {
    getInt(true)
  }
  catch {
    case e: RuntimeException => 43 // This is val of potentialFail
  } finally {
    println("finally")
  }
  
  println(potentialFail)
  
  
  class MyException extends Exception
  val exception = new MyException
  
  /*
  1. Crash your program with an OutOfMemoryError
  2. Stackoverflow error
  3. Pocket Calculator
      - add x,y
      - subtract x,y
      - multiple x,y
      - divide x,y
      
      Throw - Overflow if add x,y exceeds Int.Max_Value
      Throw - Underflow if sub x,y exceeds Int.Min_Value
      Throw - MatchCalculation for 0 division
   */
  import scala.reflect.ClassTag
  import scala.collection.mutable

  // OutOfMemoryError
  // var array = Array.emptyIntArray
  // array = Array.ofDim(Int.MaxValue)
  
  
  def recursiveAddition(param: Int): Int = {
    if (param == 0) 0
    else param + recursiveAddition(param-1)
  }
  // Stackoverflow error due to inner recursion
  // println(recursiveAddition(500))
  

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class ZeroDivisionException extends RuntimeException
  
  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else result
    }
    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result < 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if ( y == 0 ) throw new ZeroDivisionException
      else x/y
    }
  }
}
