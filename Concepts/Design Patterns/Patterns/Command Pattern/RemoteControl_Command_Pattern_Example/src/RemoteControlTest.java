import Commands.LightOnCommand;
import Objects.Light;

import java.util.List;

public class RemoteControlTest {

   public static void main(String[] args) {
      // Create a simple remote that will hold the command
      SimpleRemoteControl remote = new SimpleRemoteControl();


      Light light = new Light("Basic Light");

      // Create the command and add the light object to it
      LightOnCommand lightOn = new LightOnCommand(light);

      // add the light command to the remote
      remote.setCommand(lightOn);

      // press the remote button -> calls execute() -> calls light.on()
      remote.buttonWasPressed();
   }
}
