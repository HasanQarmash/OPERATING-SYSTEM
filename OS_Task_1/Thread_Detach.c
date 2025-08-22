//Name:Hasan Qarmash
//ID:1210611
//SEC:1
//Dr.Abdel salam sayad
//solution by thread detach
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define MATRIX_SIZE 100
#define NUMBER_OF_THREADS 4


    // Create a 100x100 matrices filled with zeros
    int matrix_ID[100][100] = {0};
    int matrix_Year[100][100] = {0};
    int resultMatrix[100][100] = {0};
// Function to perform matrix multiplication in a specific range of rows
void *matrixMultiply(void *arg) {
    int threadID = *(int *)arg;
    int rowsPerThread = MATRIX_SIZE / NUMBER_OF_THREADS;
    int startRow = threadID * rowsPerThread;
    int endRow = (threadID == NUMBER_OF_THREADS - 1) ? MATRIX_SIZE : (threadID + 1) * rowsPerThread;

    for (int i = startRow; i < endRow; i++) {
        for (int j = 0; j < MATRIX_SIZE; j++) {
            for (int k = 0; k < MATRIX_SIZE; k++) {
                resultMatrix[i][j] += matrix_ID[i][k] * matrix_Year[k][j];
            }
        }
    }

    pthread_exit(NULL);
}

int main() {

    int numberOfDigitID = 7;
    int numberOfDigitMultID_YEAR = 10;

    int ID[] = {1, 2, 1, 0, 6, 1, 1};
    int Year[] = {2, 4, 2, 4, 8, 5, 3, 8, 3, 3};


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
    pthread_t threads[NUMBER_OF_THREADS];

    // Array to store thread numbers
    int threadIDs[NUMBER_OF_THREADS];

    clock_t start = clock();
    // detached threads for matrix multiplication
    for (int i = 0; i < NUMBER_OF_THREADS; i++) {
        threadIDs[i] = i;
        pthread_create(&threads[i], NULL, matrixMultiply, &threadIDs[i]);
        pthread_detach(threads[i]);
    }

    clock_t end = clock();

    double cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("Solution using detached threads with %d threads\n",NUMBER_OF_THREADS);
    printf("Execution Time: %f seconds\n", cpu_time_used);

    printf("Throughput: %f seconds\n", 1/cpu_time_used);

    return 0;
}
