package CondimentDecorators;

import BaseClasses.Beverage;

public class Mocha extends CondimentDecorator {
   Beverage beverage;

   public Mocha(Beverage beverage) {
      this.beverage = beverage;
   }

   @Override
   public String getDescription() {
      return beverage.getDescription() + ", CondimentDecorators.Mocha";
   }

   @Override
   public double cost() {
      return beverage.cost() + .20;
   }
}

