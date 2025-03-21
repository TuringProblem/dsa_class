# Java class file

> Java class files are compiled from Java source files and contain bytecode that can be executed by the Java Virtual Machine (JVM). The `.class` file format is a binary format that includes information about the class, its methods, fields, and other metadata.
> Fields, methods may have attributes(i.e. values of constant fields)
> Main attribute of a mehtod is `Code` which contains the bytecode instructions for the method.
>
> ### Byte Code has **_THREE_** important parts:
>
> - Instruction arrays
>   > - Each instruction is represented by a single byte, followed by optional operands (arguments).
> - Operand stack
>   > - Used to store intermediate values during method execution.
> - Local variable array
>   > - Method arguments, local variables

## Class Loading Engine

### How does the JVM load a Class?

> JVM executes classes from the following sources:
>
> - Java Runtime (platform classes) -
> - Application classes (user-defined classes)
> - Auto generated on-the-fly (Proxy, Reflextion accessors, invoke dynamic implementation)
> - Provided by the application itself
>   > Every class is loaded by a class loader:
>   >
>   > - Platform classes are loaded by the bootstrap class loader
>   > - Classes from application classpath are loaded by the system class loader (AppClassLoader)
>   > - Application classes may create user-defined class loaders (e.g. for custom classpath, remote classes, etc.)
>   >
>   > ### Can a class loader load classes from multiple sources?
>   >
>   > Yes, a class loader can load multiple classes from different sources.
>   >
>   > - A class loader forms a unique class load names space, which means that classes loaded by different class loaders can have the same name but are considered different classes.

## JVM Startup

### How does the JVM start up?

> - Main class is loaded by system class loader (from application classpath or modulepath)
>   > - Provokes loading of a part of platform classes (java.lang._, java.util._, etc.)
>
> ```java
> public static void main(String[] args)  //of the main class is executed
> ```
>
> - Class file parsing
>   > - Class format is checked on correctness (may throw ClassFormat Exception)
> - Creation of runtime representation of the class in a special JVM memory area:
>   > - runtime constant pool in Method Area aka Meta Space aka Permanent Generation
> - Loading of a superclass and superinterfaces

## Linking

### Before any JavaByte ccode can be executed, it will go through the following steps:

> - Java bytecode verification
> - Preparation
> - Resolution of symbolic references
> - Initialization
>   > - Happens on first use:
>   >   > - new
>   >   > - static fiel access
>   >   > - static method call

# Execution engine: (interpreter, JIT)

> JVM can execute code in two ways:
>
> > - Interpreted mode
> > - Compiled mode (JIT - Just In Time compilation)

## Interpreter

```java

pc = 0;
do {
    // fetch opcode at pc;
    // if (operands) fetch operands;
    // execute the opcode;
    // calculate pc;
} while ( /* There is more to do */);
```

## Template interpreter

> - Every bytecode instruction is implemented as a sequence of target CPU instructions (template).
> - Instructions interpretation is just jump to a corresponding template.

## Compilers

> - Non-optimizing
>   > - Make it up as I go along
> - Simple optimizing
>   > - HotSpot Client (C1)
> - Sophisticated Optimizing
>   > - HotSpot Server (C2)

## can also differentiate by time

> - Dynamically (JIT)
> - Statically (Ahead of Time - AOT)

## Dynamic Compilers (JIT)

> - Work concurrently with program execution
> - Compile hot code **_only_**
> - Hot code is determinde be means of profiling
> - Profiling information is used for optimal optimizations (speculative)

## Static Compilers (AOT)

> - Are not limited in resources for optimizations
> - Compile every method of a program using the most aggressive optimizations
> - No overheads at run-time (fast startup)

# Meta Information

## Reflection

> - Allows access to classes, fields, methods via name (by string literal) from a Java program
> - is implemented in the JVM via access to Meta space
> - Key feature of Java for many popular frameworks and JVM-based programming languages implementations (Groovy, Clojure, Ruby, etc.)

## Method Handles and Invokedynamic (JSR-292, indy)

> - Indy: programmable call
>   > - For effective implementations of dynamic languages on the JVM
>   > - Used for lambda-objects creation, string concatenation
> - MethodHandle - target object of invokedynamic call
>   > - Can be an access to a field, a method
>   > - Combination of other MethodHandles
>   > - Can be used independently from indy: Reflection 2.0

## Java native interface (JNI)

> - Binds the JVM with the outside world (OS)
> - C interface to the JVM
>   > - Does not depend on implementation details of a JVM
>   > - is used for implementation of native methods in C language (or another low-level language)
>   > - JNI is used to implement platform specific parts of Java SE API: IO, NET, AWT
> - JNI is implemented in the JVM as an access to Meta space
