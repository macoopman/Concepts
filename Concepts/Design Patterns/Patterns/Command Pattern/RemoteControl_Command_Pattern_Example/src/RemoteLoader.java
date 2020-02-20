import Commands.LightOffCommand;
import Commands.LightOnCommand;
import Objects.Light;

public class RemoteLoader {

   public static void main(String[] args) {
      RemoteControl remoteControl = new RemoteControl();

      Light livingRoomLight = new Light("Living Room");
      Light kitchenLight = new Light("Kitchen Light");

      LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
      LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

      LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
      LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

      remoteControl.setCommand(0,livingRoomLightOn, livingRoomLightOff);
      remoteControl.setCommand(1,kitchenLightOn,kitchenLightOff);

      System.out.println(remoteControl);

   }
}
