package Objects;

public class Light {
   String lightName;

   public Light(String lightName) {
      this.lightName = lightName;
   }

   public void on() {
      System.out.println("Light Is On");
   }

   public void off() {
      System.out.println("Light Is Off");

   }
}
