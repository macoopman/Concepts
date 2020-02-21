# Template Method Pattern

**Definition**

The **Template Method** defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certian steps of an alogrithm without changing the algorithms structure.

* The **Template Method** defines the steps of an algorithm and allows subclasses to provide the implementation for one or more steps.

```java
// Declared abstract and meant to be subclasses by classes
// that implement the operations
abstract class AbstractClass {

    // declared final to prevent subclasses from 
    // reworking the sequence 
    final void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
    }

    abstract void primitiveOperation1();
    abstract void primitiveOperation2();

    void concreteOperation(){
        // implementation here
    }

}

```

---

## Hooks

A hook is a method that is declred in the abstract class, but only given an empty or default implementation.

* Gives the subclasses the ability to **hook into** the algorithm at variaous points, if they wish
* subclasses can ignore the hook if they wish

```java
abstract class AbstractClass {

    final void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        //hook
        hook()
    }

    abstract void primitiveOperation1();
    abstract void primitiveOperation2();

    void concreteOperation(){
        // implementation here
    }

    // Concrete method that does nothing 
    void hook() {}

}

```