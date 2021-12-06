package lectures.part2

object Variances extends App{
  class Foo[+A] // A covariant class
  class Bar[-A] // A contravariant class
  class Baz[A]  // An invariant class
  
  // COVARIANCE 
  
  // Consider this simple class structure:
  abstract class Animal {
    def name: String
  }
  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  // List[Cat] is a List[Animal].
  // List[Dog] is also a List[Animal]
  // Intuitively, it makes sense that a list of cats and a list of dogs are each lists 
  // of animals, and you should be able to use either of them for in place of List[Animal].

  def printAnimalNames(animals: List[Animal]): Unit =
    animals.foreach {
      animal => println(animal.name)
    }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  // prints: Whiskers, Tom
  printAnimalNames(cats)

  // prints: Fido, Rex
  printAnimalNames(dogs)
  
  // CONTRAVARIANT
  
  // Consider the Cat, Dog, and Animal classes defined above for the following example:
  abstract class Printer[-A] {
    def print(value: A): Unit
  }
  
  // A Printer[A] is a simple class that knows how to print out some type A. 
  // Let’s define some subclasses for specific types:

  class AnimalPrinter extends Printer[Animal] {
    def print(animal: Animal): Unit =
      println("The animal's name is: " + animal.name)
  }

  class CatPrinter extends Printer[Cat] {
    def print(cat: Cat): Unit =
      println("The cat's name is: " + cat.name)
  }

  def printMyCat(printer: Printer[Cat], cat: Cat): Unit =
    printer.print(cat)

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter, Cat("Boots"))
  printMyCat(animalPrinter, Cat("Boots"))
  
  // INVARIANCE

  class Container[A](value: A) {
    private var _value: A = value
    def getValue: A = _value
    def setValue(value: A): Unit = {
      _value = value
    }
  }

  val catContainer: Container[Cat] = new Container(Cat("Felix"))
  // val animalContainer: Container[Animal] = catContainer
  // animalContainer.setValue(Dog("Spot"))
  val cat: Cat = catContainer.getValue // Oops, we'd end up with a Dog assigned to a Ca
  
}
