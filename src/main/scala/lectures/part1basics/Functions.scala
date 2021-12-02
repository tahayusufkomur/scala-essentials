package lectures.part1basics

object Functions extends App {
  
  // return type = String 
  def aFunction(a: String, b: Int): String = {
    return a + " " + b
  }
  
  val x = aFunction("Fuck you times:",5)
  println(x)
  
  // paramaterless func
  def aParamaterlessFunction(): Int = 42
  
  println(aParamaterlessFunction())


  def aRecursiveFunction(aString: String, anInt: Int): String = {
    if (anInt == 1) aString
    else aString + aRecursiveFunction(aString,anInt-1)
  }  
  
  println(aRecursiveFunction("Heyyy \n", 3))
  
  // When you need loops, use recursion
  
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  
  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a:Int,b:Int): Int = a+b
    aSmallFunction(n,n-1)
  }
  
  println(aBigFunction(5))
  
  
  // A Greet Func
  
  def aGreet(name: String, age: Int): String = {
      "Hi my name is: " + name + " and I am " + age + " years old."
  }
  
  def aFacto(n: Int): Int = {
    if(n == 0){
      1
    }
    else n*aFacto(n-1)
  }
 
  // FIBONACCI 1 1 2 3 5 8 13 21 34
 def aFibbonacci(n: Int): Int = {
   if(n<=2){
     return 1
   }
   else { 
   {
     aFibbonacci(n-1)+aFibbonacci(n-2)
   }
   }
 }

  println(aFibbonacci(7))
  

  // Is Prime
  
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t<=1) true
      else n%t != 0 && isPrimeUntil(t-1)
    
    isPrimeUntil(n/2)
  }
  
  println(isPrime(999999999))
}
