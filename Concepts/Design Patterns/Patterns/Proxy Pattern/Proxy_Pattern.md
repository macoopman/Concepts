# Proxy Pattern

**Definition**

The **Proxy Pattern** provides a surrogate or placeholder for another object to control access to it.

* Use the Proxy Pattern to create a representative object that controls access to another object, which may be romote, expensive to create, or in need of securing. 

### Role of the **Remote Proxy**

* Acts as a *local representiative to a remote object*
    * **remote object** -> An object that lives in the heap of a different Java Virtual Machine.
    * **local representitive** -> An object that you can call local methods on and have them forwared to the remote object