#### Design patterns are reusable solutions to common software design problems. They represent best practices that developers can use to solve particular types of design issues in software systems. Design patterns are categorized into three main types:

---
#### Creational Patterns
Deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The main goal is to ensure that the system remains independent of how objects are created, composed, and represented.
* **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
* **Factory Method**: Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.
* **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
* **Builder**: Allows for the step-by-step creation of a complex object, separating the construction process from the actual representation of the object.
* **Prototype**: Creates new objects by copying an existing object (the prototype).
---
#### Structural Patterns
Concerned with the composition of classes or objects. They help ensure that the design of a system is flexible, scalable, and efficient.
* **Adapter**: Converts one interface to another expected by the client.
* **Bridge**: Decouples an abstraction from its implementation, allowing them to vary independently.
* **Composite**: Composes objects into tree structures to represent part-whole hierarchies.
* **Decorator**: Attaches additional responsibilities to an object dynamically.
* **Facade**: Provides a simplified interface to a complex subsystem.
* **Flyweight**: Reduces the number of objects created by sharing common objects.
* **Proxy**: Provides a surrogate or placeholder for another object to control access to it.
---
#### Behavioral Patterns
Focus on communication between objects.
* **Observer**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
* **Strategy**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the algorithm to vary independently of clients that use it.
* **Command**: Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations, as well as support for undoable operations.
* **State**: Allows an object to alter its behavior when its internal state changes, effectively encapsulating state-specific logic into separate classes.
* **Chain of Responsibility**: Allows a request to be passed along a chain of handlers until one handles it.
* **Template Method**: Defines the structure of an algorithm and allows steps of the algorithm to be overridden by subclasses.
* **Iterator**: Provides a way to access the elements of a collection sequentially without exposing the collection's underlying structure.

