//Hasan Qarmash
//1210611
//sec:1
//Thread solution using join
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define MATRIX_SIZE 100
#define NUMBER_OF_THREADS 2

// Data structure to pass arguments to the thread function
struct ThreadData {
    int firstThreadRow;
    int Thread_endThreadRow;
    int (*matrix1)[MATRIX_SIZE];
    int (*matrix2)[MATRIX_SIZE];
    int (*resultMatrixThread)[MATRIX_SIZE];
};

// Function to perform matrix multiplication in a specific range of rows
void *threadFunc(void *arg) {
    struct ThreadData *data = (struct ThreadData *)arg;

    for (int i = data->firstThreadRow; i < data->Thread_endThreadRow; i++) {
        for (int j = 0; j < MATRIX_SIZE; j++) {
            for (int k = 0; k < MATRIX_SIZE; k++) {
                data->resultMatrixThread[i][j] += data->matrix1[i][k] * data->matrix2[k][j];
            }
        }
    }

    pthread_exit(NULL);
}

int main() {
    // Your initialization code for matrices


    printf("Solution using join Thread \n");
    int numberOfDigitID = 7;
    int numberOfDigitMultID_YEAR = 10;

    int ID[] = {1, 2, 1, 0, 6, 1, 1};
    int Year[] = {2, 4, 2, 4, 8, 5, 3, 8, 3, 3};

    // Create a 100x100 matrices filled with zeros
    int matrix_ID[100][100] = {0};
    int matrix_Year[100][100] = {0};
    int resultMatrix [100][100] = {0};
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
    // Initialize pthread variables
    pthread_t threads[NUMBER_OF_THREADS];
    struct ThreadData threadData[NUMBER_OF_THREADS];

    // Divide the work among threads
    int rowsPerThread = MATRIX_SIZE / NUMBER_OF_THREADS;
    for (int i = 0; i < NUMBER_OF_THREADS; i++) {
        threadData[i].firstThreadRow = i * rowsPerThread;
        threadData[i].Thread_endThreadRow = (i == NUMBER_OF_THREADS - 1) ? MATRIX_SIZE : (i + 1) * rowsPerThread;
        threadData[i].matrix1 = matrix_ID;
        threadData[i].matrix2 = matrix_Year;
        threadData[i].resultMatrixThread = resultMatrix;

        // Check for errors when creating threads
        if (pthread_create(&threads[i], NULL, threadFunc, (void *)&threadData[i]) != 0) {
            fprintf(stderr, "Error creating thread %d\n", i);
            exit(EXIT_FAILURE);
        }
    }

    // Measure execution times

    // Wait for all threads to finish and check for errors
    clock_t Thread_start = clock();
    for (int i = 0; i < NUMBER_OF_THREADS; i++) {
        if (pthread_join(threads[i], NULL) != 0) {
            fprintf(stderr, "Error joining thread %d\n", i);
            exit(EXIT_FAILURE);
        }
    }

    // Measure execution times
    clock_t Thread_end = clock();

    double cpu_time_used = ((double)(Thread_end - Thread_start)) / CLOCKS_PER_SEC;
    // Measure thread_Throughput
    double thread_Throughput = (double)1/ cpu_time_used;

    printf("For %d-thread",NUMBER_OF_THREADS);
    // Print execution time and thread_Throughput
    printf("Execution Time for Thread-join: %f seconds\n", cpu_time_used);
    printf("thread_Throughput: %f elements per second\n", thread_Throughput);

    return 0;
}
