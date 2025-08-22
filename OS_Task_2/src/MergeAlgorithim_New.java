/*Name:Hasan Qarmash
*Id:1210611
*Section lecture:1
*Name Doctor:Abdel Salam Sayyad */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



//here i merge two algorithm in my task First algorithm Preemptive Priority Second algorithm Shortest Remaining Time First.that  algorithm 
//make result THE BEST :)
public class MergeAlgorithim_New {
	
	
    static void MergeAlgorithim_New_Shc(ArrayList<Process> processes) {
      	
    	int currentTime = processes.get(0).arrivalTime;
    	
    	PriorityQueue<Process> wait = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
    	wait.add(processes.get(0));
    	processes.get(0).arrivalTime = 0;
    	
    	System.out.println("Process id\tArrival time\tBurst time\t RRTime\t currentTime");
    	
    	while (currentTime <= 200) {
    		System.out.print("\t");
    		System.out.print(wait.peek().name + "\t\t");
    		System.out.print(wait.peek().arrivalTime + "\t\t");
    		System.out.print(wait.peek().burstTime + "\t\t");
    		System.out.print(wait.peek().remainingTime + "\t\t");
    		System.out.println(currentTime + "\t\t");

    		
    		
    		currentTime++;
    		wait.peek().remainingTime--;
    		if(wait.peek().remainingTime==0)
    		{
    			var proc=wait.peek();
    			wait.remove();
    			
    		  processes.remove(proc);
    		  proc.arrivalTime = currentTime + proc.comesBackAfter;
    		  proc.turnaroundTime=currentTime;
    		  proc.remainingTime = proc.burstTime;
    		  proc.priority= proc.originalPriority;
    		  processes.add(proc);
    		}

    		
    		for(Process process : processes)
    		{
    			if(process.arrivalTime <= currentTime && !wait.contains(process))
    				wait.add(process);
    		}
    		
    		
    		PriorityQueue<Process> updatedQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.arrivalTime));

            
            //This for increment for each process in ready queue and check if arrive 5 unit time and decrement 1 for priority 
            while (!wait.isEmpty()) {
                Process currentProcess = wait.poll();

                // Modify the priority (decrement 1 for priority-->make process high priority)
                if(currentTime-currentProcess.remainingTime>=5)
                {
                	currentProcess.priority--;
                }

                // Add the updated process to the temporary queue
                updatedQueue.add(currentProcess);
            
            }
            
            while(!updatedQueue.isEmpty())
            {
            	 Process currentProcess = updatedQueue.poll();
            	 wait.add(currentProcess);
            	
            }
    		
    		
    	}
    	
    }

}
