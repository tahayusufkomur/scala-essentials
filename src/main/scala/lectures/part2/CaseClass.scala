package lectures.part2

object CaseClass extends App{
  
  //Case classes are like regular classes with a few key differences
  // which we will go over. Case classes are good for modeling 
  // immutable data. In the next step of the tour, we’ll see how 
  // they are useful in pattern matching.
  
  // A minimal case class requires the keywords case class, 
  // an identifier, and a parameter list (which may be empty):
  case class Book(isbn: String)

  val frankenstein = Book("978-0486282114")
  
  // Notice how the keyword new was not used to instantiate
  // the Book case class. This is because case classes
  // have an apply method by default which takes care
  // of object construction.
  //When you create a case class with parameters, 
  // the parameters are public vals.

  case class Message(sender: String, recipient: String, body: String)
  
  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
  
  println(message1.sender)  // prints guillaume@quebec.ca
  // message1.sender = "travis@washington.us"  // this line does not compile
  
  // Comparison
  // Instances of case classes are compared by structure not by reference:
  
  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val messagesAreTheSame = message2 == message3  // true

  // You can create a (shallow) copy of an instance 
  // of a case class simply by using the copy method. 
  // You can optionally change the constructor arguments.
  
  val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  message5.sender  // travis@washington.us
  message5.recipient // claire@bourgogne.fr
  message5.body  // "Me zo o komz gant ma amezeg"
}
