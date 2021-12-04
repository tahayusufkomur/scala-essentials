package lectures.part2

object AbstractDataTypes extends App {

  abstract class Animal {

    val creatureType: String

    def eat: Unit
    
  }
  
  class Dog extends Animal {
    
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  // traits
  
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  
  class Crocodile extends Animal with Carnivore{
    
    val creatureType: String = "croc"

    override def eat: Unit = "nombomnom"
    override def eat(animal: Animal): Unit = println("I'm a croc and ")
  }
}
