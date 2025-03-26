### Summary of Java 11 Features
* Local-Variable Syntax for Lambda Parameters: Use var in lambda expressions for more concise code.
* String Methods Enhancements: New methods like isBlank(), strip(), repeat(), and lines() added to the String class.
    * isBlank(): Returns true if the string is empty or contains only whitespace.
    * lines(): Returns a stream of lines extracted from the string, splitting by line separators.
    * strip(): Removes leading and trailing whitespaces.
    * stripLeading(): Removes leading whitespaces.
    * stripTrailing(): Removes trailing whitespaces.
    * repeat(): Repeats the string a given number of times.
    * isEmpty(): Checks if the string is empty.
* Running Java Files Directly: Run .java files directly with the java command.

  `$ java HelloWorld.java`
* HTTP Client API (Standard): A new modern HTTP client API supporting HTTP/2.
* Removal of java.security.acl Package: Legacy package removed.
* Nest-Based Access Control: Better access control for classes in the same "nest".
* Launch Single-File Source-Code Programs: Run a single Java source file without compiling it first.
* ZGC (Z Garbage Collector): Improved low-latency garbage collection.
* Deprecations and Removals: Removal of javax.xml.bind and other legacy modules like Java EE and CORBA.