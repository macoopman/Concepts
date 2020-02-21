public class DinerMenuItorator implements Iterator {
   MenuItem[] items;
   int position = 0;

   public DinerMenuItorator(MenuItem[] items) {
      this.items = items;
   }

   @Override
   public boolean hasNext() {
      if (position >= items.length || items[position] == null){
         return false;
      }
      return true;
   }

   @Override
   public MenuItem next() {
      MenuItem menuItem = items[position];
      position += 1;
      return menuItem;
   }
}
