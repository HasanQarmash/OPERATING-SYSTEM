# 🚀 OS Task 1: Threading and Process Management in C

This project explores fundamental concepts of concurrent programming in C, focusing on multi-threading and process creation. It provides practical implementations of matrix multiplication using different threading techniques to analyze and compare their performance characteristics.

## 🔑 Key Concepts Demonstrated

-   **Multi-threading with `pthreads`**: Utilizes the POSIX threads library to perform parallel computations.
-   **Thread Synchronization**:
    -   `pthread_join`: The main thread waits for the worker threads to complete their execution before proceeding, ensuring that all computations are finished.
    -   `pthread_detach`: (In `Thread_Detach.c`) Threads are detached to run independently, which can be useful for "fire-and-forget" tasks.
-   **Process Creation**: The `ChildProcess.c` file demonstrates the use of `fork()` to create separate processes, offering a comparison between multi-threading and multi-processing.
-   **Performance Analysis**: The code is instrumented to measure execution time and calculate throughput, allowing for a comparative analysis of different concurrency models.

## 📁 File Descriptions

-   `Thread_join.c`: Implements matrix multiplication by dividing the work among multiple threads that are synchronized using `pthread_join`.
-   `Thread_Detach.c`: Implements matrix multiplication using detached threads.
-   `ChildProcess.c`: Demonstrates matrix multiplication using child processes created via `fork()`.
-   `loop.c`: A simple loop program, likely for baseline performance comparison.

## ⚙️ How to Compile and Run

You can compile the programs using a C compiler like GCC.

### Compiling
Open your terminal and run the following commands:

```bash
# For the thread-join implementation
gcc Thread_join.c -o Thread_join -lpthread

# For the thread-detach implementation
gcc Thread_Detach.c -o Thread_Detach -lpthread

# For the child process implementation
gcc ChildProcess.c -o ChildProcess
```

### Running
Execute the compiled programs from your terminal:

```bash
# Run the thread-join version
./Thread_join

# Run the thread-detach version
./Thread_Detach

# Run the child process version
./ChildProcess
```
