package main.scala

trait List[T]{
  def size: Int
  def empty: Boolean
  def pop_front(): T
  def value_at(index: Int): T
//  def push_front(data: T)
  def push_back(data: T)
//  def pop_back(data: T)
  def front(): T
  def back(): T
}
