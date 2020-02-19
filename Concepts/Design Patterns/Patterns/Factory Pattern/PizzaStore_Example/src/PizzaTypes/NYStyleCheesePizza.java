package PizzaTypes;

import PizzaTypes.Pizza;

public class NYStyleCheesePizza extends Pizza {

   public NYStyleCheesePizza() {
      name = "NY Style Sauce and  Cheese PizzaTypes.Pizza";
      dough = "Thin Crust Dough";
      sauce = "Marinara Sauce";

      toppings.add("Grated Reggiano Cheese");
   }

   @Override
   public void cut(){
      System.out.println("Cutting the pizza into square slices");
   }
}
