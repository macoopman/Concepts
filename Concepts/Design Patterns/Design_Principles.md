# Design Principles

### 1. Identify the aspects of your application that vary and separate them from what stays the same

* "Encapsulate" what varies so it will not affect the rest of your code.

### 2. Program to an interface, not an implementaion

* This way classes won't need to know any of the implementaion details for their behaviors
* Each interface can represent a behavior -> each implementation (concrete class) will implement the interface 
* Gives ability to add new behaviors without modifying any of or existing behavior classes 
* By programming to an interface we can change behavior at runtime 
    * How to set:
        * Assign a "new" conconcrete class (that implements the interface) to and interface instance variable in the constructor 
        ```java
        public class MyClass {
            
            InterfaceClass var = new ConcreteClass();
        }
        ```
        * Also, can create setters that take concrete implementations of the interface and sets them at run time
        ```java
        public class ...

        public void setFlyBehavior(FlyBehavior flyBehavior){
            this.flyBehavior = flyBehavior;
        }
        ```

```plantuml
@startuml
    skinparam backgroundColor DarkSeaGreenBorderColor

    rectangle Flying_Example{
        interface FlyBehavior {
        fly()
    }
    class FlyWithWings {
        fly() 
        // implements duck flying
    }
    class FlyNoWay {
        fly()
        // do nothing - can't fly!
    }
    FlyBehavior <|-- FlyWithWings : Concrete Implementations
    FlyBehavior <|-- FlyNoWay

    note top of FlyBehavior
        Abstract supertype (abstract class or interface)
    end note


    }
    
    rectangle Animal_Example{
        interface Animal {
        makeSound()
    }
    class Dog {
        makeSound() 
        // barks
    }
    class Cat {
        makeSound()
        // meows
    }
    Animal <|-- Dog
    Animal <|-- Cat
    }
    
   
@enduml
```

### 3. Favor composition over inheritance
* Instead of inheriting behavior, classes get their behavior by being **composed** with the right behavior objects
* Give more flexibility to the system


### 4. Strive for loosely coupled designs between objects that interact
* Loosely coupled designs allow us to build flexible OO systems that can handle change because they minimize the interdependency between object. 
