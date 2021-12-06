package lectures.part2

object Generics extends App{

  // Generic classes take a type as a parameter within 
  // square brackets []. One convention is to use the 
  // letter A as type parameter identifier, though any 
  // parameter name may be used.
  
  class Stack[A] {
    private var elements: List[A] = Nil
    def push(x: A): Unit =
      elements = x :: elements
    def peek: A = elements.head
    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }
  
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop())  // prints 2
  println(stack.pop())

  //The instance stack can only take Ints. However, 
  // if the type argument had subtypes, those could be passed in:

  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  val fruit_stack = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana
 
  fruit_stack.push(apple)
  fruit_stack.push(banana)
  
  println(fruit_stack.pop())
  println(fruit_stack.pop())

  // Class Apple and Banana both extend Fruit so 
  // we can push instances apple and banana onto the stack of Fruit.
  
}
