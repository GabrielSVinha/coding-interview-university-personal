from linkedlist import LinkedList
from testfixtures import ShouldRaise

ll = LinkedList()

# Created empty list

assert(ll.head != None) # There is one empty node
assert(ll.head.data == None)
assert(ll.size() == 0)
assert(ll.empty())

# Insert some data bois

ll.push_back(0)
ll.push_back(1)
ll.push_back(2)
ll.push_back(3)
ll.push_back(4)

assert(ll.size() == 5)
assert(not ll.empty())
assert(ll.value_at(0) == 0)
assert(ll.value_at(1) == 1)
assert(ll.value_at(2) == 2)
assert(ll.value_at(3) == 3)
assert(ll.value_at(4) == 4)
with ShouldRaise(IndexError):
  ll.value_at(5)
ll.push_back(752)
ll.push_back(754)
ll.push_back(1020)
ll.push_back(7879)
for i in range(ll.size()):
  ll.value_at(i)
assert(ll.value_at(8) == 7879)
assert(ll.value_at(7) == 1020)
assert(ll.value_at(6) == 754)
assert(ll.value_at(5) == 752)
with ShouldRaise(IndexError):
  ll.value_at(9)

ll.push_front(-7)
assert(ll.size() == 10)
assert(ll.value_at(0) != 0)
assert(ll.value_at(0) == -7)
assert(ll.value_at(1) == 0)

with ShouldRaise(IndexError):
  ll.value_at(10)

ll.pop_front()
assert(ll.size() == 9)
assert(ll.value_at(0) != -7)
assert(ll.value_at(0) == 0)
assert(ll.value_at(1) == 1)
with ShouldRaise(IndexError):
  ll.value_at(10)  
with ShouldRaise(IndexError):
  ll.value_at(9)

ll.pop_front()
assert(ll.size() == 8)
assert(ll.value_at(0) != -7)
assert(ll.value_at(0) != 0)
assert(ll.value_at(0) == 1)
assert(ll.value_at(1) == 2)
with ShouldRaise(IndexError):
  ll.value_at(10)  
with ShouldRaise(IndexError):
  ll.value_at(9)
with ShouldRaise(IndexError):
  ll.value_at(8)

tmp_ll = LinkedList()
assert(tmp_ll.pop_front() == None)
del tmp_ll

assert(ll.front() == 1)
assert(ll.back() == 7879)

assert(ll.pop_back() == 7879)
assert(ll.size() == 7)