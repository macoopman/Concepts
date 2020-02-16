# Factory Pattern

**Factories** -> Handle the details of object creation. 
    
* By Encapsulating the creation of classes we only have one place to make modifications when implementing changes
* NO concreate instantiations in client code

**Building a simple factory**
```Java
public class SimplePizzaFactory{

    // All clients use this to instantiate new objects
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")){
            pizza = new PepporoniPizza();
        } 
        // others excluded
        return pizza; 
    }
}
```

**Client Pizza Store Code**
```Java
public class PizzaStore{

   SimplePizzaFactory factory;

   public PizzaStrore(SimplePizzaFactory factory){
       this.factory = factory;
   }

   public Pizza orderPizza(String type){
       Pizza pizza;
       
       pizza = factory.createPizza(type);

       pizza.prepare();
       pizza.bake();
       pizza.cut();
       pizza.box();

       return pizza;
   }
}
```