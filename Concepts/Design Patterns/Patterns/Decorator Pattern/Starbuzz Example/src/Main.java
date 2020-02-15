import BaseClasses.Beverage;
import BaseClasses.Espresso;
import BaseClasses.HouseBlend;
import CondimentDecorators.Mocha;

public class Main {

    public static void main(String[] args) {
        // Order an express, no condiments, and print description and cost
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());


    }
}
