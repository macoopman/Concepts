package PizzaStores;

import Ingredients.NYPizzaIngredientFactory;
import Ingredients.PizzaIngredientFactory;
import PizzaTypes.*;

public class NYPizzaStore extends PizzaStore {
   @Override
   protected Pizza createPizza(String item) {
      Pizza pizza = null;
      PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

      if (item.equals("cheese")){
         pizza = new CheesePizza(ingredientFactory);
         pizza.setName("New York Style Cheese Pizza");
      }
      // Did not implement all these pizza types
//      else if (item.equals("veggie"))
//         return new NYStyleVeggiePizza();
//      else if (item.equals("clam"))
//         return new NYStyleClamPizza();
//      else if (item.equals("pepperoni"))
//         return new NYStylePepperoniPizza();

      return pizza;
   }
}
