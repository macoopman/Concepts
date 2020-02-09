# Overview/Classification
---
## Catalog
<table>
  <tbody>
     <tr>
      <td>Scope/Purpose</td>
      <td align="center">Creational</td>
      <td align="right">Structual </td>
      <td align="right">Behavioral</td>
    </tr>
    <tr>
      <td>Class</td>
      <td align="center">Factory Method</td>
      <td align="right">Adapter(class) </td>
      <td align="right"><ul>
          <li>Interpreter</li>
          <li>Template Method</li>
        </ul></td>
    </tr>
    <tr>
      <td>Object</td>
      <td align="center">
        <ul>
          <li>Abstract Factory</li>
          <li>Builder</li>
          <li>Prototype</li>
          <li>Singleton</li>
        </ul>
      </td>
      <td align="right">
        <ul>
          <li>Adapter (object)</li>
          <li>Bridge</li>
          <li>Composite</li>
          <li>Decorator</li>
          <li>Facade</li>
          <li>Flyweight</li>
          <li>Proxy</li>
        </ul>
      </td>
    <td align="right">
        <ul>
          <li>Chain of Responsibility</li>
          <li>Command</li>
          <li>Iterator</li>
          <li>Mediator</li>
          <li>Memento</li>
          <li>Observer</li>
          <li>State</li>
          <li>Strategy</li>
          <li>Visitor</li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

### Purpose

* **Creational** -> patterns concern the process of object creation
* **Structural** -> deal with the composition of classes or objects
* **Behavioral** -> Characterize the ways in which classes or objects interact and distribute responsibility

### Scope
* **Class** -> Deal with relationships b/t classes and their subclasses (inheritance)
  * Static-fixed aat compile-time
* **Object** -> Deal with object relationships
  * Can be changed at run-time, more dynamic


<table>
  <tbody>
     <tr>
      <td>Purpose</td>
      <td align="center">Design Pattern</td>
      <td align="right">Aspect(s) That Can Vary </td>
    </tr>
    <tr>
      <td align="center">Creational</td>
      <td align="right">Abstract Factory</td>
      <td align="right">familys of product objects</td>
    </tr>
   <tr>
      <td align="center"></td>
      <td align="right">Builder</td>
      <td align="right">how a composit object get created</td>
    </tr>
    <tr>
      <td align="center"></td>
      <td align="right">Factory Method</td>
      <td align="right">subclass of object that is instantiated</td>
    </tr>
    <tr>
      <td align="center"></td>
      <td align="right">Prototype</td>
      <td align="right">class of object that is instantiated</td>
    </tr>
    <tr>
      <td align="center"></td>
      <td align="right">Singleton</td>
      <td align="right">the sole instance of a class</td>
    </tr>
        <tr>
      <td align="center">Structural</td>
      <td align="right">Adapter</td>
      <td align="right">inteface to an object</td>
      </tr>
          <tr>
      <td align="center"></td>
      <td align="right">Bridge</td>
      <td align="right">implementation of an object</td>
    </tr>
        <tr>
      <td align="center"></td>
      <td align="right">Composite</td>
      <td align="right">structure and composition of an object</td>
    </tr>
        <tr>
      <td align="center"></td>
      <td align="right">Decorator</td>
      <td align="right">responsiblities of an objct without subclassing</td>
    </tr>
        <tr>
      <td align="center"></td>
      <td align="right">Facade</td>
      <td align="right">interface to a subsystem</td>
    </tr>
        <tr>
      <td align="center"></td>
      <td align="right">Proxy</td>
      <td align="right">how an object is accessed; its location</td>
    </tr>
        <tr>
      <td align="center">Behavioral</td>
      <td align="right">Chain of Responsibility</td>
      <td align="right">object that can fulfill a request</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Command</td>
      <td align="right">when and how a request is fulfilled</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Interpreter</td>
      <td align="right">grammar and interpretation of language</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Iterator</td>
      <td align="right">how an aggregat's elements are accessed, traversed</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Mediator</td>
      <td align="right">how and which objects interact with each other</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Memento</td>
      <td align="right">what private information is stored outside and object, and when</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Observer</td>
      <td align="right">number of objects that depend on another object; how the dependent objects stay up to date</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">State</td>
      <td align="right">states of an object</td>
    </tr>        <tr>
      <td align="center"></td>
      <td align="right">Strategy</td>
      <td align="right">an algorithm</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Template Method</td>
      <td align="right">steps of an algorithm</td>
    </tr>
            <tr>
      <td align="center"></td>
      <td align="right">Visitor</td>
      <td align="right">operations that can be applied to object(s) without changing their classes</td>
    </tr>
  </tbody>
</table>




