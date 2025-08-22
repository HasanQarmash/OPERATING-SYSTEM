# 🖥️ Operating Systems Projects

This repository contains a collection of projects developed for an Operating Systems course. Each project explores fundamental OS concepts through practical implementation and simulation. The projects cover topics such as process and thread management, CPU scheduling, and deadlock detection.

## 🚀 Projects Overview

### [OS Task 1: Threading and Process Management in C](./OS_Task_1/)

This project delves into concurrent programming in C, comparing the performance of multi-threading (using `pthreads` with both `join` and `detach` strategies) and multi-processing (using `fork()`). The goal is to understand the trade-offs between different concurrency models by implementing a matrix multiplication task.

-   **Key Concepts**: `pthreads`, `fork()`, thread synchronization, process creation, performance analysis.
-   **Languages/Technologies**: C, POSIX Threads.

### [OS Task 2: CPU Scheduling Algorithms](./OS_Task_2/)

A Java-based simulator for various CPU scheduling algorithms. This project allows for the visualization and comparison of how different algorithms manage process execution. It calculates and displays key performance metrics like waiting time and turnaround time for each algorithm.

-   **Implemented Algorithms**: FCFS, SJF (Non-preemptive), SRTF (Preemptive SJF), Round Robin, and both Preemptive and Non-preemptive Priority scheduling.
-   **Languages/Technologies**: Java.

### [OS Task 3: Deadlock Detection](./OS_Task_3/)

An implementation of a deadlock detection algorithm in Java, based on the Banker's Algorithm. The program analyzes the system's resource allocation state from input files to determine if a deadlock exists and identifies the processes involved.

-   **Key Concepts**: Deadlock, resource allocation, safe state, Banker's Algorithm.
-   **Languages/Technologies**: Java.

## 🛠️ How to Use This Repository

Each project is contained within its own directory (`OS_Task_1`, `OS_Task_2`, etc.). Inside each directory, you will find a dedicated `README.md` file with detailed instructions on how to compile, run, and understand the specifics of that project.

To get started, navigate to the directory of the project you are interested in and follow the instructions in its local `README.md`.

## ✍️ Author

-   **Hasan Qarmash**

---

This collection represents a practical journey through some of the core challenges and solutions in modern operating systems.
