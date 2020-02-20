import Commands.Command;
import Commands.NoCommand;

public class RemoteControl {

   Command[] onCommands;
   Command[] offCommands;

   public RemoteControl() {
      this.onCommands = new Command[7];
      this.offCommands = new Command[7];

      Command noCommand = new NoCommand();
      for (int i = 0 ; i < 7 ; i++){
         onCommands[i] = noCommand;
         offCommands[i] = noCommand;
      }
   }

   public void setCommand(int slot, Command onCommand, Command offCommand){
      onCommands[slot] = onCommand;
      offCommands[slot] = offCommand;
   }

   public void onButtonWasPushed(int slot){
      onCommands[slot].execute();
   }

   public void offButtonWasPushed(int slot){
      onCommands[slot].execute();
   }

   @Override
   public String toString() {
      String toString;
      toString = "\n----- Remote Control -----\n";
      for (int i = 0; i < onCommands.length; i++){
         toString += String.format("[slot %d ] %s    %s\n",i, onCommands[i].getClass().getName(), offCommands.getClass().getName());
      }

      return toString;
   }
}
