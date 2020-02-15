# Decorator Pattern

**Definition**

    The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

### General Example
```plantuml
@startuml
    skinparam backgroundColor DarkSeaGreenBorderColor

 class Component {
     methodA()
     methodB()
     otherMethods()
 }

 class ConcreteComponent{
     methodA()
     methodB()
     otherMethods()
 }

 class Decorator{
     methodA()
     methodB()
     otherMethods() 
 }

 class ConcreteDecoratorA {
     Component wrappedObj
     methodA()
     methodB()
     newBehavior()
     otherMethods() 
 }

  class ConcreteDecoratorB {
     Component wrappedObj
     Object newState
     methodA()
     methodB()
     newBehavior()
     otherMethods() 
 }

 Component <|-- ConcreteComponent
 Component <|-- Decorator
 Decorator <|-- ConcreteDecoratorA
 Decorator <|-- ConcreteDecoratorB

 note left of Component
    Can be interface or abstract class
 endNote

 note left of ConcreteComponent
    ConcreteComponent is the object 
    we're going to dynamically add 
    new behavior to. It EXTENDS Component
 endNote

 note right of Decorator
    Decorators implment the
    same interface or abstract 
    class as the component they
    are going to decorate
 endNote

note right of ConcreteDecoratorA
    ConcreteDecorator has an
    instance variable for the 
    thing it decorates
 endNote

 note left of ConcreteDecoratorB
    Decoratore can extend the 
    state of the component
 endNote

 note bottom of ConcreteDecoratorB
    Decorators can add new methods; however, new 
    behavior is typically addded by doing computation
    before or after an existing method in the component
 endNote


@enduml
```

### Specific Example

```plantuml
@startuml
    skinparam backgroundColor DarkSeaGreenBorderColor

 class Beverage {
     description
     getDescription()
     cost()
     otherMethods()
 }

 class HouseBlend{
     cost()
 }

 class DarkRoast{
     cost()
 }

 class Espresso{
     cost()
 }

 class Decaf{
     cost()
 }

 class CondimentDecorator {
     getDescription()
 }

 Beverage <|-- HouseBlend
 Beverage <|-- DarkRoast
 Beverage <|-- Espresso
 Beverage <|-- Decaf
 Beverage <|-- CondimentDecorator
 Beverage <-- CondimentDecorator


 class Milk{
     Beverage beverage
     cost()
     getDescription()
 }

 class Mocha{
     Beverage beverage
     cost()
     getDescription()
 }

 class Soy{
     Beverage beverage
     cost()
     getDescription()
 }

 class Whip{
     Beverage beverage
     cost()
     getDescription()
 }

 CondimentDecorator <|-- Milk
 CondimentDecorator <|-- Mocha
 CondimentDecorator <|-- Soy
 CondimentDecorator <|-- Whip






 




@enduml
```