# Singleton Pattern

**Definition**

The **Singleton Pattern** ensures a class has only one instance, and provides a global point of access to it.
 * A singlton is a class that mangaes a single instance of itself
 * NO other classes can create a **new** instance on its own   

```plantuml
@startuml
class Singleton {
    static uniqueInstance
    static getInstance()
}

@enduml
```
* **getInstance()** method
    * Is STATIC which means it's a class method, so you can conveniently acces this method from anywhere -> **Singleton.getInstance()**
* **uniqueInstace**
    * class variable holds our one and only instance of Singleton
---


### Multithreading
* Multithreading can pose a problem for the singleton where you can create more than one Singleton
* Solution 1 -> adding **synchronized** to the getInstance() method: 
    * ISSUE: the synchronized keyword is expensive -> possible decrease performace by factor of 100. High traffic areas it should not be used

    ```java

    public class Singleton {
        private static Singleton uniqueInstance;

        // other useful instance variable here

        private Singleton() // private contructor

        public static synchronized Singleton getInstance(){
            if (uniqueInstance == null){
                uniqueInstance = new Singleton()
            }
            return uniqueInstance;
        }
    }

    ```
* Solution 2 -> Do nothing if the performace of getInstance() isn't critical to the application 

* Solution 3 -> Move to an eagerly crated instance rather than a lazily created one
    * Use if: The application always creates and uses an instance of the Singleton or the overhead of creation and runtime aspects of the Singleton are not onerous

    ```java

    public class Singleton {
        private static Singleton uniqueInstance = new Singleton();

        // other useful instance variable here

        private Singleton() // private contructor

        public static synchronized Singleton getInstance(){
            return uniqueInstance;
        }
    }

    ```

* Solution 4 -> Use **Double-Checked Locking** to reduce the use of Synchronization in getInstance()
    * First check to see if an instance is created, and if not, THEN synchronize
    * ONLY synchronized the first time through
    ```java

    public class Singleton {
        /*
            Volatile ensures that multiple threads
            handle the unique Instance var correctly 
            when it is being initialized 
        */
        private volatile static Singleton uniqueInstance;

        // other useful instance variable here

        private Singleton() // private contructor

        public static synchronized Singleton getInstance(){
            /*
                Check for an instance and if there is not one, enter a synchronized block
            */
            if (uniqueInstance == null){
                // Only synchronize dthe first time through
                synchronized (Singleton.class) {
                    if (uniqueInstance == null){
                        uniqueInstance = new Singleton();
                    }
                }
                
            }
            return uniqueInstance;
        }
    }

    ```
