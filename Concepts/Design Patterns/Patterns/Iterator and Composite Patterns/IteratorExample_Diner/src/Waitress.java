public class Waitress {
   DinerMenu dinerMenu;

   public Waitress(DinerMenu dinerMenu) {
      this.dinerMenu = dinerMenu;
   }

   public void printMenu(){
      Iterator dinerIterator = dinerMenu.createIterator();

      System.out.println("MENU\n---\nLunch");
      printMenu(dinerIterator);
   }

   private void printMenu(Iterator iterator) {
      while (iterator.hasNext()){
         MenuItem menuItem = (MenuItem) iterator.next();
         System.out.print(menuItem.getName() + ", " );
         System.out.print(menuItem.getPrice() + ", " );
         System.out.println(menuItem.getDescription());


      }
   }
}
