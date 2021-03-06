# Iterator and Composite Patterns

## Iterator Pattern

**Definition**

The **Iterator Pattern** provides a way to access the elements of an aggreate object sequentially without exposing its underlying represention

* The iterator pattern allows traversal of the elements of an aggregate without exposing the underlying implementiation.
* It places the task of traversal on the iterator object, not on the aggregate, which simplifies the aggregate interface and implementation, and places the responsibility where it should be.

```plantuml
@startuml
interface Iterator {
    hasNext();
    next();
}

note right of Iterator
    The hasNext() method tells us if
    more elements in the aggregate
    to iterate through
endnote

note top of Iterator
    The next() method returns the next
    object in the aggregate
endnote
@enduml
```

```plantuml
@startuml
interface Aggregate {
    createIterator()
}

class ConcreteAggregate{
    createIterator()
}

class Client

interface Iterator {
    hasNext()
    next()
    remove()
}

class ConcreteIterator {
    hasNext()
    next()
    remove()
}

Aggregate <- Client
Client -> Iterator

Aggregate  <|-- ConcreteAggregate
Iterator  <|-- ConcreteIterator

ConcreteAggregate -> ConcreteIterator

note top of Aggregate 
    Common interface for aggregate decouples 
    your client from the implementation
    of your collection
endnote

note right of Iterator 
    Provides the interface that all
    iterators must implement.
endnote

note right of ConcreteIterator 
    Responsible for managing the 
    current position of the iterator
endnote

note bottom of ConcreteAggregate 
    Collection of objects and 
    implements themethod that returns
    and Iterator for its collection
endnote


@enduml
```
---

## Composite Pattern

**Definition**

The **Composite Pattern** allows you to compose objects into tree structures to represen part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

* **Part-Whole**: a tree of objects hat is made of parts but that can be treated as a whole.
* The **Composite Pattern** allows us to build structures of objects in the from of **trees** that contain both composition of objects and individual objects as nodes
* Can ignore the differences b/t compositions of objects and individual objects 

NOTE:

Because using all operations in both the Compoite and the Leaf does not make since the default behavior is **UnsupportedOperationException**

```plantuml
@startuml

class Client

abstract class Component {
    operation()
    add(Component)
    remove(Component)
    getChild(int)
}
class Leaf
class Composite {
    operation()
    add(Component)
    remove(Component)
    getChild(int)
}

Client -> Component
Component <|-- Leaf
Component <|-- Composite
Composite --> Component

@enduml

```
* **Client**: Uses the Component interface to manipulate the objects in the composition.
* **Component**: Defines an interface for all objects in the composition: both the composite and the leaf node
    * May implement a default behavior for add(), remove(), getChild(), and its operations
* **Composite**: Role is to define behavior of the components having children and to store child components.   
