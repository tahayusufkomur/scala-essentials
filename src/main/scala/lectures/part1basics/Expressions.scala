package lectures.part1basics

// extends App to make it runnable
object Expressions extends App {

  val x = 1 + 2 // EXPRESSION

  println(1 == x) // Also an EXPRESSION

  // Instructions: (Something you tell computer to DO)
  // Expressions: (Something has a value, we will think in way of expressions)

  // IF Expression

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3

  println(aConditionedValue)

  //val aWeirdValue = (aVar = 5) not working may be because of scala version
  
  // side effects: println(), whiles, reassigning

  // Codeblocks are also an expression
  val aCodeBlock = {
    val z = 3
    val p = 4

    if (z < p) "its correct buddy" else "its wrong buddy"
  }

  println(aCodeBlock)

  val bCodeBlock = {
    2 < 3
    42
  }
  println(bCodeBlock)

}
