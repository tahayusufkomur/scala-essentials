package lectures.part2

object Objects extends App {

  // Scala does not have class-level functionality ("static")
  // We use object for class level definition
  // In scala, object = SINGLETON INSTANCE

  object Person { // type + its only instance
    
    // class level functionality
    val N_EYES = 2
    
    def canFly: Boolean = false
    
    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  
  class Person(name: String) {
    // instance level functionality
  }
  
  // Companions 

  println(Person.N_EYES)
  
  val mary = new Person("mary")
  val john = new Person("john")
  
  val bobbie = Person(mary,john)
  
  println(mary==john) // True, Person is one instance
  
  // practical reason is, splitting class-level functionality and instance-level functionality
  // we call this design companion

}
