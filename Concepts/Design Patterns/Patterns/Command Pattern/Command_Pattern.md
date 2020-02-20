# Command Pattern

**Definition**

The **Command Pattern** encapsulates a request as an object, thereby leting you parameterize other objects with differnt reuest, queue or log request, and support undoable operations.

* Packages up the reciever and action into a object that exposes just one method -> **execute()**

```plantuml
@startuml

class Client
class Invoker
class Reciever {
    action()
}
class ConcreteCommand{
    execute()
    undo()
}
interface Command {
    execute()
    undo()
}

Client --> Reciever
Client --> ConcreteCommand
ConcreteCommand --> Client
Invoker --> Command
ConcreteCommand <|-- Command

note right of ConcreteCommand
    public void execute(){
        receiver.action()
    }
endnote


@enduml
```