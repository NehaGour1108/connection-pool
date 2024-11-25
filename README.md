# **Connection Pool Implementation**

A simple Java implementation of a connection pool using a bounded blocking queue. This project demonstrates how to manage reusable connections efficiently in a multithreaded environment.

---

## **Features**

- Creates a fixed-size pool of reusable connections.
- Threads can acquire and release connections safely.
- Manages blocking behavior when connections are unavailable.
- Ensures efficient resource utilization and thread safety.

---

## **Getting Started**

### **Prerequisites**

- Java 8 or higher
- A Java IDE (e.g., IntelliJ, Eclipse) or a text editor with `javac` installed.

---

### **Installation**

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/connection-pool.git
   ```

2. Navigate to the project directory:
   ```bash
   cd connection-pool
   ```

3. Compile the code:
   ```bash
   javac Main.java
   ```

4. Run the program:
   ```bash
   java Main
   ```

---

## **Usage**

1. The connection pool is initialized with a fixed size (default: 5 connections).
2. Multiple threads simulate acquiring, using, and releasing connections.
3. Example:
   - A thread acquires a connection, executes a mock query, and releases it back to the pool.

---

## **Code Overview**

- **`Connection` Class**  
  Represents a mock database connection with a unique ID.

- **`ConnectionPool` Class**  
  Manages the connection pool using a bounded `BlockingQueue`.

- **`ConnectionTask` Class**  
  Simulates a thread that acquires and releases connections.

- **`Main` Class**  
  Entry point of the application that starts multiple threads.

---

## **Example Output**

```plaintext
Acquired connection with ID: 1
Executing query on connection 1: SELECT * FROM users
Released connection with ID: 1
...
```

---

## **Customization**

- Change the pool size:
  Modify `int poolSize = 5;` in the `Main` class.
- Add real database logic:
  Replace the `execute` method in the `Connection` class with actual database queries.

