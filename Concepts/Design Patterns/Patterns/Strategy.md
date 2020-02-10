# Strategy Pattern

**Definition**

Defines a family of alogrithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it

```plantuml
@startuml
    skinparam backgroundColor DarkSeaGreenBorderColor
    
    note top of Character
        Abstract
    end note

    abstract class Character {
        WeaponBehavior weapon;
        fight()
        setWeapon(WeaponBehavior w);
    }

    class King {
        fight();
    }

    class Queen {
        fight();
    }

    class Knight {
        fight();
    }

    class Troll {
        fight();
    }

    Character <|-- King
    Character <|-- Queen
    Character <|-- Knight
    Character <|-- Troll
    Character *-> WeaponBehavior : A Character HAS-A WeaponBehavor


    interface WeaponBehavior {
        useWeapon()
    }

    class KnifeBehavior {
        useWeapon()
    }

    class AxeBehavior {
        useWeapon()
    }

    class BowAndArrowBehavior{
        useWeapon()
    }

    class SwordBehavior {
        useWeapon()
    }


    WeaponBehavior <|.. KnifeBehavior
    WeaponBehavior <|.. AxeBehavior
    WeaponBehavior <|.. BowAndArrowBehavior
    WeaponBehavior <|.. SwordBehavior
   
   
@enduml
```