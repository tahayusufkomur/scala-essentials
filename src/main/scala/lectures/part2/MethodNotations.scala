package lectures.part2

import scala.language.postfixOps
object MethodNotations extends App {


  val Marry = new Person("Mary", "Inception")
  val Tom = new Person("Tom", "Lord of The Ring")
  //prefix notation
  val x = -1 // equivalent with 1.unary_-

  println(Marry.likes("Inception"))
  println(Marry likes "Inception") //infix notation, only works if 1 parameter in method

  //pretty cool right?
  println(Marry hangOutWith Tom) // infix notation

  // You can use +, -, *, / in names of methods.
  // All operators are methods

  println(1.+(2))
  val y = 1.unary_-

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"What the hack ${name}!"

    def unary_+ : Person = new Person(this.name,this.favoriteMovie,this.age+1)
    
    def isAlive: Boolean = true
    
    def apply(): String = s"${name} does this"
    
    def apply(n: Int): Unit = println(s"${this.name} watched ${this.favoriteMovie} ${n} times.")
    
    def +(st: String) : Person = new Person(this.name+s" (${st})", this.favoriteMovie, this.age)
    
    def learns(thing: String): String = s"${name} learns ${thing}"
    def learnsScala = this learns "scala"
  }

  println(y)

  // when you use unary_operand in class methods, you can use them like unary operands
  // ex:
  // prefix
  println(!Marry)

  
  // postfix notation
  println(Marry.isAlive)
  println(Marry isAlive)
  
  //apply
  println(Marry())
  println((Marry + "the Rockstar")())
  
  println((+Marry).age)
  
  println(Marry learnsScala)
  
  (Marry + "the Rockstar")(10)
/* 
* Overload the + operator, "Mary the rockstar"
* 
* */
}
