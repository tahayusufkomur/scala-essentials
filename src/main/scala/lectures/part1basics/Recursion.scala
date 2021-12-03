package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n == 1) 1
    else {

      val result = n * factorial(n - 1)
      println("Computing factorial of " + n + " I first need factorial of " + (n - 1))
      println("Computed factorial of " + (n - 1) + " = " + result / n)
      result
    }

  }


  //factorial(100)
  // Stackoverflow
  //val n = 600000000
  //println("Factorial of " + n + " = "+factorial(n))


  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION, use recursive call as the LAST expression
    }

    factorialHelper(n, 1)
  }

  //println(anotherFactorial(100000))


  // String concatenator recursive
  def concatString(str: String, n: Int): String = {
    if (n == 0) str
    else (str + concatString(str, n - 1))
  }

  println(concatString("Hey \n", 3))

  // IsPrime with tail recursive


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, accumulator: Boolean): Boolean =
      if (!accumulator) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && accumulator)

    isPrimeHelper(n / 2, true)
  }


  //println(isPrime(1000040401))
  //println(101/2)

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibohelper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i == n) last
      else fibohelper(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibohelper(2, 1, 1)
  }

  //1 1 2 3 5 8 13 21 34 55
  println(fibonacci(10))

}

/* 
*   
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t<=1) true
      else n%t != 0 && isPrimeUntil(t-1)
    
    isPrimeUntil(n/2)
  }
  * 
  * 
  *  def aFibbonacci(n: Int): Int = {
   if(n<=2){
     return 1
   }
   else { 
   {
     aFibbonacci(n-1)+aFibbonacci(n-2)
   }
   }
 }
* */