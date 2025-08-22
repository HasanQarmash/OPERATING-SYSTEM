# 🚦 OS Task 3: Deadlock Detection

This project implements a deadlock detection algorithm, a crucial component in operating systems for managing resource allocation and preventing system freezes. The program reads the current state of resource allocation and requests from files and determines if any processes are in a deadlocked state.

## 🧠 Core Concept: Banker's Algorithm

The deadlock detection is implemented using a variant of the **Banker's Algorithm**. This algorithm checks if a system is in a safe state, meaning there is at least one sequence of process executions that allows all processes to complete. If no such safe sequence exists, the system is considered to be in a deadlock.

The main steps of the algorithm are:
1.  Initialize a `work` vector with the available resources and a `finish` array to track completed processes.
2.  Find a process that can have its resource needs satisfied with the current `work` resources.
3.  If such a process is found, assume it completes and releases its allocated resources, adding them back to the `work` vector. Mark the process as finished.
4.  Repeat this process until no more processes can be completed.
5.  If all processes are marked as finished, the system is in a safe state. Otherwise, the unfinished processes are part of a deadlock.

## ✨ Features

-   **Data-driven**: The program reads resource allocation data from CSV files, making it easy to test with different scenarios.
-   **Dynamic Input**: Reads the following from CSV files:
    -   `Allocation.csv`: A matrix representing the resources currently allocated to each process.
    -   `Request.csv`: A matrix of the resources each process is currently requesting.
    -   `Available.csv`: A vector of available resources in the system.
-   **Dimension Verification**: Before running the detection, the program verifies that the dimensions of the input matrices and vectors are consistent.
-   **Clear Output**: Reports whether a deadlock is detected and, if so, lists the processes involved in the deadlock.

## 🚀 How to Run

1.  **Prepare Input Files**:
    Make sure you have the following CSV files with the correct format:
    -   `Allocation.csv`: An `n x m` matrix, where `n` is the number of processes and `m` is the number of resource types.
    -   `Request.csv`: An `n x m` matrix with the same dimensions.
    -   `Available.csv`: A `1 x m` vector.

2.  **Update File Paths**:
    In `Main.java`, you **must** update the file paths in the `main` method to point to the location of your CSV files.

    ```java
    // ...
    int[][] allocation = readCsv("PATH_TO_YOUR_Allocation.csv");
    int[][] request = readCsv("PATH_TO_YOUR_Request.csv");
    int[] available = readAvailableCsv("PATH_TO_YOUR_Available.csv");
    // ...
    ```

3.  **Compile and Run**:
    Open a terminal in the `src` directory.

    ```bash
    # Compile the Java code
    javac Main.java

    # Run the program
    java Main
    ```

The program will then print whether a deadlock was detected and provide details.

## 📂 File Structure

-   `src/Main.java`: The main Java file containing the deadlock detection logic.
-   `bin/Main.class`: The compiled Java bytecode.
