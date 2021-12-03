package lectures.part2

object OOBasics extends App{
  
  val person = new Person("Yusuf", 26)
  println(person.age)
  
  person.greet("YO YO")

  val author = new Writer("Charles", "Dickens",1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(s"Novel: ${novel.name}, release year:${novel.releaseYear}," +
    s" author: ${author.fullName()}")
  
  println(s"Is Charles Dickens is author of Great Expectations? :${novel.isWrittenBy(author)}")
  
  var counter = new Counter(10)
  println(counter.count)
  counter = counter.inc(10);
  println(counter.count)
}

// constructor
class Person(val name:String,val age: Int){
  
  def greet(name:String): Unit = println(s"${this.name} says: Hi")
  
  // multiple constructors
  
  def this(name: String) = this(name, 0)
  
}


/* 
* Novel and a Writer class
* 
* Writer: fname, sname, year
* - method fullname
* 
* Novel: name, year of release, author
* 
* - authorAge
* - isWrittenBy(author)
* - copy (new year of release) = new instance of novel with new year released*/


class Writer(val fname: String, val sname: String, val byear: Int)
{
  def fullName(): String = (s"${this.fname} ${this.sname}")
}

class Novel(val name: String, val releaseYear: Int, val author: Writer){
  //val authorAge = 

  def authorAge = releaseYear - author.byear

  def isWrittenBy(author:Writer): Boolean = {
    if (author == this.author) true
    else false
  }
  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

/* 
* Counter class
* -reeives an int value
* - method current count
* - method to increment/decrement => new Counter
* 
* */


class Counter(val count: Int) {
  def inc = {
    println("Incrementing")
    new Counter(count+1) // immutability
  }
  def dec = {
    println("Decrementing")
    new Counter(count-1)
  }
  // overloading
  def inc(n: Int): Counter = {
    println(s"Incrementing ${n} times")
    new Counter(this.count+n)
  }
  // overloading
  def dec(n: Int): Counter = {
    println(s"Decrementing ${n} times")
    new Counter(this.count-n)
  }
}



