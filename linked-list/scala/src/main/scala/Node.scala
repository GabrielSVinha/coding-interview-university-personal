package main.scala

class Node[T]{
  var next: Node[T] = _
  private var data: T = _

  override def toString: String = this.data.toString

  def isEmpty: Boolean = this.data == null

  def saveData(value: T) = {
    this.data = value
  }

  def getData(): T = this.data
}
