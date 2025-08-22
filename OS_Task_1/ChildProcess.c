//Hasan Qarmash
//1210611
//sec:1
//solution using child Process
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <time.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>

void childProcess(int startRow, int endRow, int matrix_ID[100][100], int matrix_Year[100][100], int (*resultMatrix)[100]) {
    // Perform matrix multiplication for the assigned rows
    for (int i = startRow; i < endRow; i++) {
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                resultMatrix[i][j] += matrix_ID[i][k] * matrix_Year[k][j];
            }
        }
    }
}

int main() {
    int numberOfDigitID = 7;
    int numberOfDigitMultID_YEAR = 10;

    int ID[] = {1, 2, 1, 0, 6, 1, 1};
    int Year[] = {2, 4, 2, 4, 8, 5, 3, 8, 3, 3};

    // Create a 100x100 matrices filled with zeros
    int matrix_ID[100][100] = {0};
    int matrix_Year[100][100] = {0};

    // Initialize variables to keep track of the current position in the sequences
    int sequenceIndexID = 0;
    int sequenceIndexYear = 0;

    // Fill the matrix_ID with the given sequence
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            matrix_ID[i][j] = ID[sequenceIndexID];
            sequenceIndexID = (sequenceIndexID + 1) % numberOfDigitID;
        }
    }

    // Fill the matrix_Year with the given sequence
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            matrix_Year[i][j] = Year[sequenceIndexYear];
            sequenceIndexYear = (sequenceIndexYear + 1) % numberOfDigitMultID_YEAR;
        }
    }

    int numChildren = 4;

    // Create shared memory for resultMatrix
    key_t key = ftok("resultMatrix", 'R');
    int shmid = shmget(key, sizeof(int[100][100]), IPC_CREAT | 0666);
    int (*resultMatrix)[100] = shmat(shmid, NULL, 0);

    // Divide the work among child processes
    int rowsPerChild = 100 / numChildren;
    int remainderRows = 100 % numChildren;

    // Record the start time
    clock_t start = clock();

    // Perform matrix multiplication in parallel using fork()
    for (int child = 0; child < numChildren; child++) {
        pid_t childPid = fork();

        if (childPid == -1) {
            perror("Fork failed");
            exit(EXIT_FAILURE);
        }

        if (childPid == 0) {
            // Child process
            int startRow = child * rowsPerChild;
            int endRow = (child == numChildren - 1) ? startRow + rowsPerChild + remainderRows : startRow + rowsPerChild;

            childProcess(startRow, endRow, matrix_ID, matrix_Year, resultMatrix);

            exit(EXIT_SUCCESS);
        }
    }

    // Parent process
    for (int i = 0; i < numChildren; i++) {
        wait(NULL);
    }

    // Record the end time
    clock_t end = clock();


    // Calculate and print the execution time
    double cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("For %d of Child process\n ",numChildren);
    printf("Execution Time For childProcess: %f seconds\n", cpu_time_used);
    double throughput = (double)1/ (cpu_time_used);
    printf("Throughput: %f elements per second\n", throughput);

    return 0;
}
