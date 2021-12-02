package lectures.part1basics

object SmartOperationsOnStrings extends App{
  
  val str: String = "Hello, I am learning Scala."
  
  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  
  
  // S-interpolators
  
  val name = "Yusuf"
  val age = 26
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  
  print(greeting)
  println("\n"+anotherGreeting)
  
  // F-interpolators
  
  val speed = 1.2534213f
  val myth = f"$name can eat $speed%2.3f burgers per minute"
  
  println(myth)
  
  // Raw-interpolator
  
  println(raw"This is a \n newline")
  
  
  // we can combine raw and s and f ->
  
  println(raw"i can print \n"+greeting+myth)
}
