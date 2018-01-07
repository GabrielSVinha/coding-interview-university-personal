package main.scala

class LinkedList[T] extends List[T]{
  private var head: Node[T] = new Node[T]()
  private var tail: Node[T] = this.head

  override def back(): T = {
    return this.tail.getData()
  }

  override def push_back(data: T) = {
    if(this.head.isEmpty){
      this.head.saveData(data)
      this.head.next = new Node[T]
    }else {
      val new_node = new Node[T]
      new_node.saveData(data)
      new_node.next = new Node[T]
      this.tail.next = new_node
      this.tail = new_node
    }
  }

  override def empty: Boolean = this.head.isEmpty

  override def front(): T = this.head.getData()

  override def size: Int = {
    var size = 0
    var node = this.head
    while (!node.isEmpty){
      if(node.next != null){
        node = node.next
        size += 1
      }
    }
    return size
  }

  override def value_at(index: Int): T = {
    var i = 0
    var node = this.head
    if(node.isEmpty){
      throw new IndexOutOfBoundsException
    }
    for(i <- 1 to index){
      if(!node.next.isEmpty){
        node = node.next
      } else {
        throw new IndexOutOfBoundsException
      }
    }
    return node.getData()
  }
  override def pop_front(): T = {
    var value: T = this.head.getData()
    if(!this.head.isEmpty){
      this.head = this.head.next
    }
    return value
  }
}
