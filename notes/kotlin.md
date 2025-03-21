# Kotlin Semantics Guide for Java Developers

## Basic Syntax Differences

### Variable Declaration
```kotlin
// Variables in Kotlin are declared with var (mutable) or val (immutable)
val name: String = "John"    // Immutable (final in Java)
var age: Int = 25           // Mutable

// Type inference (compiler infers type)
val name = "John"           // String type inferred
var age = 25                // Int type inferred

// Null safety (variables cannot be null by default)
var name: String = "John"   // Cannot be null
var name: String? = "John"  // Can be null
```

### Function Declaration
```kotlin
// Basic function
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Single-expression function (return type inferred)
fun sum(a: Int, b: Int) = a + b

// Function with default parameters
fun greet(name: String = "Guest") = "Hello, $name"

// Extension function (adds method to existing class)
fun String.addExclamation() = this + "!"
```

### Control Flow
```kotlin
// If-else as an expression (returns a value)
val max = if (a > b) a else b

// When expression (enhanced switch)
when (x) {
    1 -> print("x is 1")
    2, 3 -> print("x is 2 or 3")
    in 4..10 -> print("x is between 4 and 10")
    is String -> print("x is String of length ${x.length}")
    else -> print("none of the above")
}

// For loop
for (item in collection) print(item)
for (i in 1..5) print(i)
for (i in 6 downTo 1 step 2) print(i)
```

## Null Safety Features

### Safe Call Operator
```kotlin
// Safe call (?.) - Returns null if the reference is null
val length = name?.length  // Returns null if name is null

// Elvis operator (?:) - Provides default value if expression is null
val length = name?.length ?: 0  // Returns 0 if name is null

// Not-null assertion (!!) - Throws NPE if expression is null
val length = name!!.length  // Throws NPE if name is null
```

### Smart Casts
```kotlin
// Compiler automatically casts after type check
if (obj is String) {
    // obj is automatically cast to String here
    print(obj.length)
}
```

## Collections and Functional Programming

### Collection Types
```kotlin
// List creation
val immutableList = listOf("apple", "banana")
val mutableList = mutableListOf("apple", "banana")

// Map creation
val immutableMap = mapOf("a" to 1, "b" to 2)
val mutableMap = mutableMapOf("a" to 1, "b" to 2)

// Set creation
val immutableSet = setOf("apple", "banana")
val mutableSet = mutableSetOf("apple", "banana")
```

### Functional Operations
```kotlin
// Lambda expressions
val sum = { x: Int, y: Int -> x + y }
val result = sum(1, 2)

// Common functional operations
val doubled = numbers.map { it * 2 }
val adults = people.filter { it.age >= 18 }
val allAdults = people.all { it.age >= 18 }
val anyAdult = people.any { it.age >= 18 }
val groupedByAge = people.groupBy { it.age }
val sumOfAges = people.sumOf { it.age }
```

## Classes and Objects

### Class Definition
```kotlin
// Basic class
class Person(val name: String, var age: Int)

// Constructor with init block
class Person(val name: String) {
    var age: Int = 0
    init {
        // Initialization code
    }
    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }
}

// Data classes (equals, hashCode, toString, copy automatically generated)
data class User(val name: String, val id: Int)

// Sealed classes (restricted class hierarchies)
sealed class Result {
    class Success(val data: Any) : Result()
    class Error(val message: String) : Result()
}
```

### Object and Companion Object
```kotlin
// Singleton object
object DatabaseConfig {
    val url = "jdbc:mysql://localhost:3306/mydb"
    fun connect() = println("Connected to $url")
}

// Companion object (similar to static members in Java)
class MyClass {
    companion object {
        const val MAX_COUNT = 100
        fun factory(): MyClass = MyClass()
    }
}
```

## Advanced Features

### Extension Functions and Properties
```kotlin
// Extension function
fun String.removeFirstLastChar(): String = this.substring(1, this.length - 1)

// Extension property
val String.lastChar: Char
    get() = this[this.length - 1]
```

### Coroutines (Concurrency)
```kotlin
// Basic coroutine
suspend fun fetchUserData(): User {
    delay(1000) // Non-blocking delay
    return User("John", 123)
}

// Launch coroutine
fun main() = runBlocking {
    launch {
        // Executes in parallel
        val user = fetchUserData()
        println(user)
    }
}
```

### Delegated Properties
```kotlin
// Lazy initialization
val lazyValue: String by lazy {
    println("Computed!")
    "Hello"
}

// Observable property
var name: String by Delegates.observable("Initial") { prop, old, new ->
    println("$old -> $new")
}

// Map delegation
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}
```

### Type Aliases and Inline Classes
```kotlin
// Type alias for complex types
typealias EmployeeSet = Set<Employee>
typealias EmployeeHandler = (Employee) -> Unit

// Inline class (no runtime overhead)
inline class Password(val value: String)
```

### DSL Building
```kotlin
// HTML builder example
html {
    head {
        title { +"Kotlin DSL Example" }
    }
    body {
        h1 { +"Welcome!" }
        p { +"This is a DSL example" }
    }
}
```

## Interoperability with Java

### Annotations for Java Interop
```kotlin
// Make nullability explicit for Java
@Nullable fun mayReturnNull(): String? = null
@NotNull fun neverNull(): String = "always"

// JvmStatic makes companion object methods static in Java
companion object {
    @JvmStatic fun staticMethod() {}
}

// JvmOverloads generates overloaded methods for default params
@JvmOverloads fun greet(name: String = "Guest") {}

// JvmField exposes property as field without getters/setters
@JvmField var count = 0
```

## Kotlin Idioms and Best Practices

### Destructuring Declarations
```kotlin
// Decompose objects
val (name, age) = person
val (key, value) = entry
val (x, y, z) = coordinates

// In lambda parameters
map.mapValues { (_, value) -> value * 2 }
```

### Apply, With, Let, Also, Run
```kotlin
// apply: configure object and return it
val person = Person().apply {
    name = "John"
    age = 30
}

// with: operate on object and return result
val result = with(person) {
    println(name)
    age * 2
}

// let: operate on non-null object and return result
val length = name?.let { it.length }

// also: additional operations while chaining
val numbers = mutableListOf(1, 2, 3)
    .also { println("The list elements are: $it") }
    .map { it * 2 }

// run: operate on object and return result (combines with and let)
val result = person.run {
    println(name)
    age * 2
}
```

### String Templates
```kotlin
val name = "John"
val greeting = "Hello, $name!"
val calculation = "The sum is ${1 + 2}"
```

### Ranges and Progressions
```kotlin
if (i in 1..10) println(i)        // 1 to 10 inclusive
for (i in 1 until 10) println(i)  // 1 to 9 (excluding 10)
for (i in 10 downTo 1) println(i) // 10 to 1
for (i in 1..10 step 2) println(i) // 1, 3, 5, 7, 9
```

## Kotlin Standard Library

### Key Packages and Functions
- `kotlin.collections`: Enhanced collection operations
- `kotlin.io`: File I/O utilities
- `kotlin.text`: String operations
- `kotlin.random`: Random number generation
- `kotlin.time`: Duration and time measurement
- `kotlin.sequences`: Lazy sequence operations
- `kotlin.coroutines`: Coroutine support

### Useful Functions
- `use { }`: Auto-close resources (similar to Java's try-with-resources)
- `repeat(n) { }`: Repeat a block n times
- `buildList { }`, `buildMap { }`: Builders for collections
- `takeIf { }`, `takeUnless { }`: Conditional filtering
- `require()`, `check()`, `assert()`: Runtime assertions