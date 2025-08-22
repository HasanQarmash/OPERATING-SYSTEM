//Name:Hasan Qarmash
//Id:1210611
//Section lecture:1
//Name Doctor:Abdel Salam Sayyad 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class FCFS    {
	
	
	List<Process> processes = new ArrayList<>();
	
	private static double avgTurnaroundTime;
	private static double avgWaitingTime;
	
	public List<Process> getProcesses() {
		return processes;
	}


	
	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}






	public void FCFS_Sch(List<Process>processes)
	{
	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("FCFS algorithm");
		
		System.out.println();
		  System.out.print("Gantt chart:\n");
		  System.out.println();
    int[] arrayOfExecutionTime = new int[150];

    int i = 0;
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    
    // Execute processes
    int currentTime = 0;

    while(currentTime<200)
    {
    for (Process process : processes) {
        // Wait for arrival
    	if(currentTime>200)
    	{
    		break;
    	}

    	arrayOfExecutionTime[i++] = currentTime;
    	process.waitingTime += currentTime-process.arrivalTime;
    	currentTime += process.burstTime;
    	process.turnaroundTime = currentTime - process.originalArraivalTime;
        process.arrivalTime=currentTime+process.comesBackAfter;


        // Check if the process comes back
        if (currentTime >= process.comesBackAfter) {
            System.out.print(" " + process.name + "  |");
        }
        
    }
    }
    Process lastItem = processes.get(processes.size() - 1);
    
    System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    for (i = 0; i < 25; i++) {
    	if(i>12)
        System.out.print(arrayOfExecutionTime[i] + "   ");
    	else
    		System.out.print(arrayOfExecutionTime[i] + "    ");	
    }
    System.out.print(arrayOfExecutionTime[--i]+lastItem.burstTime  + "	  ");
    System.out.println();
    // Calculate average waiting time and average turn  around time
    int totalWaitingTime = 0;
    int totalTurnaroundTime = 0;
    for (Process process : processes) {
        totalWaitingTime += process.waitingTime;
        totalTurnaroundTime += process.turnaroundTime;
    }

    double averageWaitingTime = (double) totalWaitingTime / processes.size();
    double averageTurnaroundTime = (double) totalTurnaroundTime / processes.size();

    System.out.printf("Average Waiting Time:%.1f \n",averageWaitingTime);
    System.out.printf("Average Turnaround Time:%.1f" , averageTurnaroundTime);
		
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
	


		
		
		
		
		
		
		
		
	

}


	

	
}
