package BaseClasses;

public abstract class Beverage {
   String description = "Unknown BaseClasses.Beverage";

   public String getDescription(){
      return description;
   }

   public abstract double cost();
}
