package lectures.part2

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
}
