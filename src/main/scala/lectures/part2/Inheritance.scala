package lectures.part2

object Inheritance extends App {

  val cat = new Cat

  // Private ( only inside class you can reach )
  // Protected ( inside class + subclasses can reach )
  // No modifier = Public
  class Animal {
    protected def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch crunch")
    }
  }
  cat.crunch
  
  class Dog extends Animal {
    override def eat: Unit = println("muchkmuchk")
  }
  
  val dog = new Dog
  dog.eat

  
  
}
