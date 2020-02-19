package PizzaTypes;

import Ingredients.PizzaIngredientFactory;

public class ClamPizza extends Pizza  {
   PizzaIngredientFactory ingredientFactory;

   public ClamPizza(PizzaIngredientFactory ingredientFactory) {
      this.ingredientFactory = ingredientFactory;
   }

   @Override
   public void prepare() {
      System.out.println("Preparing " + name);

      // adds the items that are used for a specific region
      dough = ingredientFactory.createDough();
      sauce = ingredientFactory.createSauce();
      cheese = ingredientFactory.createCheese();
   }
}
