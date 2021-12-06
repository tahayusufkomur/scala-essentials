package exercises

abstract class MyList {

  /* 
  * method head = first element of the list
  * tail = remainder of the list
  * isEmpty =  is this list empty
  * add(int) = new list with this element added
  * toString = a string representation of the list
  * */

  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException

  def tail: MyList = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = "none"
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h

  def isEmpty: Boolean = false

  def add(element: Int): MyList = new Cons(element, this)

  def printElements: String = {
    if (tail.isEmpty) "" + h
    else {
      h + ", " + tail.printElements
    }
  }

  def tail: MyList = t
}

object ListTest extends App {
  val list = new Cons(100, Empty)
  println(list.head) // 100
  println(list.add(4).add(3).add(2).add(1).toString) // 4
}
