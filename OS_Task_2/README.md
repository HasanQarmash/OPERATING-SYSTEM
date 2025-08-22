# 📊 OS Task 2: CPU Scheduling Algorithms

This project provides a comprehensive simulation of various CPU scheduling algorithms. It is designed to help visualize and understand how different scheduling strategies affect process execution, waiting time, and turnaround time. The simulator is implemented in Java and demonstrates a range of classical scheduling algorithms.

## 📈 Implemented Scheduling Algorithms

The simulator includes the following algorithms:

1.  **First-Come, First-Served (FCFS)**: Processes are executed in the order they arrive.
          <img width="1240" height="189" alt="image" src="https://github.com/user-attachments/assets/7211f338-91fd-4b72-860f-8c2f50c080b0" />

2.  **Shortest Job First (SJF)**: A non-preemptive algorithm where the process with the smallest burst time is executed next.
          <img width="1246" height="560" alt="image" src="https://github.com/user-attachments/assets/1186d93a-5e5b-457f-a003-972ab26a061b" />

3.  **Shortest Remaining Time First (SRTF)**: The preemptive version of SJF. The process with the smallest remaining time to completion is executed.
          <img width="1147" height="740" alt="image" src="https://github.com/user-attachments/assets/097af1db-429e-4e3b-bf3d-7ae1b5561e28" />

4.  **Round Robin (RR)**: A preemptive algorithm where each process is given a fixed time slice (quantum) to execute.
          <img width="1226" height="364" alt="image" src="https://github.com/user-attachments/assets/f3921a2c-79a4-4e47-b2dc-8ee29d5e4709" />

5.  **Preemptive Priority Scheduling**: Processes are assigned priorities, and the one with the highest priority gets the CPU. Can be preempted by higher-priority processes.  <img width="1150" height="819" alt="image" src="https://github.com/user-attachments/assets/d8affefa-2b95-4be0-9c05-9d55bd4e0248" />

6.  **Non-preemptive Priority Scheduling**: Similar to preemptive priority, but once a process starts, it runs to completion.
        <img width="1197" height="271" alt="image" src="https://github.com/user-attachments/assets/3995ee6f-d254-4b74-878f-dbe33b68ef97" />


## ✨ Key Features

-   **Process Simulation**: The `Process` class models a CPU process with attributes like arrival time, burst time, and priority.
-   **Modular Design**: Each scheduling algorithm is implemented in its own class (`FCFS.java`, `SJF.java`, etc.), making the code easy to understand and extend.
-   **Interactive Menu**: The `Main.java` class provides a command-line menu to select and run the desired scheduling algorithm.
-   **Performance Metrics**: The simulator calculates and displays key performance metrics such as:
    -   **Waiting Time**: The time a process spends in the ready queue.
    -   **Turnaround Time**: The total time from process arrival to its completion.
    -   **Average Waiting Time and Average Turnaround Time**: Calculated for each algorithm to allow for performance comparison.

## 🚀 How to Run the Simulator

1.  **Compile the Java files**:
    Open a terminal in the `src` directory and compile all the Java source files.

    ```bash
    javac *.java
    ```

2.  **Run the Main program**:
    After successful compilation, run the main class to start the simulator.

    ```bash
    java Main
    ```

3.  **Select an Algorithm**:
    You will be presented with a menu of scheduling algorithms. Enter the number corresponding to the algorithm you want to simulate. The results, including the execution order and performance metrics, will be displayed in the console.

## 📂 File Structure

-   `src/`: Contains all the Java source code.
    -   `Main.java`: The entry point of the application, containing the user menu.
    -   `Process.java`: The data structure for a process.
    -   `FCFS.java`: Implements the First-Come, First-Served algorithm.
    -   `SJF.java`: Implements the Shortest Job First algorithm.
    -   `SRTF.java`: Implements the Shortest Remaining Time First algorithm.
    -   `roundRobin.java`: Implements the Round Robin algorithm.
    -   `Preemptive_Priority.java`: Implements Preemptive Priority scheduling.
    -   `Non_preemptive_Priority.java`: Implements Non-preemptive Priority scheduling.
-   `bin/`: Contains the compiled `.class` files.
