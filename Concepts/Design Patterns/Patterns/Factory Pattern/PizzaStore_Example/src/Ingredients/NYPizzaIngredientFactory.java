package Ingredients;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
   @Override
   public Dough createDough() {
      return new ThinCrustDough();
   }

   @Override
   public Sauce createSauce() {
      return new MarinaraSauce();
   }

   @Override
   public Cheese createCheese() {
      return new ReggianoCheese();
   }

   @Override
   public Veggies[] createVeggies() {
      Veggies veggie[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
      return veggie;
   }

   @Override
   public Pepperoni createPepperoni() {
      return new SlicedPepperoni();
   }

   @Override
   public Clams createClams() {
      return new FreshClams();
   }
}
