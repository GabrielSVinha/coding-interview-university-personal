class LinkedList:
  def __init__(self):
    self.head = Node()
    self.tail = self.head

  def push_back(self, data):
    if self.head.is_empty():
      new_node = Node()
      self.tail = new_node
      self.head.next = self.tail
      self.head.data = data
    else:
      self.tail.data = data
      self.tail.next = Node()
      self.tail = self.tail.next

  def pop_front(self):
    if self.head.is_empty():
      return None
    value = self.head.data
    self.head = self.head.next
    return value

  def front(self):
    return self.head.data

  def back(self):
    node = self.head
    while(node.next.data != None):
      node = node.next
    return node.data

  def push_front(self, data):
    new_node = Node()
    new_node.data = data
    new_node.next = self.head
    self.head = new_node

  def empty(self):
    return self.head.data == None

  def value_at(self, index):
    node = self.head
    for i in range(index):
      if node.next.data != None:
        node = node.next
      else:
        raise IndexError
    return node.data

  def size(self):
    node = self.head
    counter = 0
    while node.data != None:
      counter += 1
      if node.next != None:
        node = node.next
      else:
        return counter
    return counter
      

class Node:
  def __init__(self):
    self.data = None
    self.next = None
  
  def is_empty(self):
    return self.data == None