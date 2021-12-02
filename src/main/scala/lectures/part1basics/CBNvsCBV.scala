package lectures.part1basics

// Call by name vs call by value
object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: "+x)
    println("by value: "+x)
  }
  def calledByName(x: => Long): Unit = {
    println("by name: "+x)
    println("by name: "+x)
  }
  
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())
  
  // dumb function to crash comp
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(y) 
  val some = 15
  // when you use parameters by value, they call the function. 
  // instead if i use by name, it would not evaulate that dumb function.
  // so not crash
  //printFirst(infinite(), some)
}
