//Hasan Qarmash
//1210611
//sec:1
//solution using 3 LOOP without thread and Process
#include <time.h>
#include <stdio.h>
int main() {
    clock_t start, end;
    double cpu_time_used;

    int numberOfDigitID = 7;
    int numberOfDigitMultID_YEAR = 10;

    int ID[] = {1, 2, 1, 0, 6, 1, 1};
    int Year[] = {2, 4, 2, 4, 8, 5, 3, 8, 3, 3};

    int matrix_ID[100][100] = {0};
    int matrix_Year[100][100] = {0};
    int resultMatrix[100][100] = {0};

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

    start = clock();

    // Multiply matrices and store the result in resultMatrix
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                resultMatrix[i][j] += matrix_ID[i][k] * matrix_Year[k][j];
            }
        }
    }

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;


    // Print execution time
    printf("Execution Time: %f seconds\n", cpu_time_used);
   // Throughput=1/ execution time
    return 0;
}
