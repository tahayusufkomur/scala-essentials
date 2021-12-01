package lectures.part1basics

// if a class extends App then its runnable
object Values extends App{
  
  
  // VALUES (immutable)
  // Type 'int' is optional since its VAL and its immutable
  val x: Int = 42
  
  // String
  val aString: String = "this is a string"
  
  // Boolean
  val aBoolean: Boolean = false
  
  // Character
  val aChar: Char = 'a'
  
  // Short Integer ( can not be too big )
  val aShort: Short = 4631
  
  // Long Integer ( can be really big)
  val aLong: Long = 5273213981123231233L
  
  // Float
  var aFloat: Float = 2.0f
  
  // Double
  var aDouble: Double = 3.14
  
}
