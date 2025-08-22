import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
    	//if you want run file from another device you must change path for this file, this file for my device Hasan_Qarmash :)
        int[][] allocation = readCsv("\"C:\\Users\\qarma\\Downloads\\Allocation.csv\"");
        int[][] request = readCsv("\"C:\\Users\\qarma\\Downloads\\Request.csv\"");
        int[] available = readAvailableCsv("\"C:\\Users\\qarma\\Downloads\\Available.csv\"");

        if (!verifyDimensions(allocation, request, available)) {
            System.out.println("Inconsistent dimensions in input files.");
            return;
        }

        List<Integer> deadlockedProcesses = detectDeadlock(allocation, request, available);
        if (deadlockedProcesses.isEmpty()) {
            System.out.println("No deadlock detected. A safe sequence is possible.");
            // Call a function to print the safe sequence
        } else {
            System.out.println("Deadlock detected in processes: " + deadlockedProcesses);
        }
    }

    private static int[][] readCsv(String filePath) throws IOException {
        // Implement CSV reading logic
    }

    private static int[] readAvailableCsv(String filePath) throws IOException {
        // Implement CSV reading logic for available vector
    }

    private static boolean verifyDimensions(int[][] allocation, int[][] request, int[] available) {
        // Implement dimension verification logic
    }

    private static List<Integer> detectDeadlock(int[][] allocation, int[][] request, int[] available) {
        // Implement deadlock detection logic (e.g., Banker's Algorithm)
    }
}
