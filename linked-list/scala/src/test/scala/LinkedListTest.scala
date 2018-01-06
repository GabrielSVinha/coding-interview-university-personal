import main.scala.LinkedList
import org.scalatest._

class LinkedListTest extends FlatSpec with Matchers with OptionValues with Inside with Inspectors{
  "A linked list" should "add values to the end" in {
    val ll = new LinkedList[Int]
    var i = 0
    val rnd = new scala.util.Random
    while(i < 10000) {
      val random = rnd.nextInt()
      ll.push_back(random)
      i += 1
      assert(ll.back() == random)
    }
    assert(!ll.empty)
    ll.push_back(12)
    assert(ll.back() == 12)
    ll.push_back(75)
    ll.push_back(90)
    assert(ll.back() == 90)
  }

  "A linked list" should "be empty when created" in {
    val ll = new LinkedList[Int]
    assert(ll.empty)
  }

  "A linked list" should "not be empty after added elements" in {
    val ll = new LinkedList[Int]
    assert(ll.empty)
    ll.push_back(-120)
    assert(!ll.empty)
  }

  "A linked list" should "have a data in the head" in {
    val ll = new LinkedList[Int]
    assert(ll.front() == 0)
    ll.push_back(-12)
    assert(ll.front() == -12)
    assert(ll.back() == -12)
    var i = 0
    val rnd = new scala.util.Random
    while(i < 10000) {
      val random = rnd.nextInt()
      ll.push_back(random)
      i += 1
    }
    assert(ll.front() == -12)
    assert(ll.back() != -12)
  }

  "A linked list" should "have size" in {
    val ll = new LinkedList[Int]
    assert(ll.size == 0)
    ll.push_back(-12)
    assert(ll.size == 1)

    val ll2 = new LinkedList[Int]
    var i = 0
    val rnd = new scala.util.Random
    while(i < 100000){
      ll2.push_back(rnd.nextInt())
      i += 1
    }
    assert(ll2.size == 100000)
  }

  "A linked list" should "get values from different indexes" in {
    val ll = new LinkedList[Int]
    val thrown = intercept[IndexOutOfBoundsException] {
      assert(ll.value_at(0) == 0)
    }

    ll.push_back(-12)
    assert(ll.value_at(0) == -12)
    var i = 0
    val rnd = new scala.util.Random
    while(i < 100000){
      val random = rnd.nextInt()
      ll.push_back(random)
      i += 1
      assert(ll.value_at(i) == random)
      assert(ll.value_at(0) == -12)
    }
  }

  "A linked list" should "remove from the first node" in {
    val ll = new LinkedList[Int]
    print(ll.pop_front())
  }
}
