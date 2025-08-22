//Name:Hasan Qarmash
//Id:1210611
//Section lecture:1
//Name Doctor:Abdel Salam Sayyad 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Non_preemptive_Priority {
	
	List<Process> processes = new ArrayList<>();
	
	
static void Priority_Nonpremetive(ArrayList<Process> processes) {
	
	  int avgTurnaroundTime = 0;
      int avgWaitingTime=0;	
	
    System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    System.err.println("Non-preemptive Priority Scheduling");
    

    System.err.println("\nGantt chart:");
    System.out.println();
    int currentTime = processes.get(0).arrivalTime;

    double index=0;
    PriorityQueue<Process> wait = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
    wait.add(processes.get(0));
   // processes.get(0).arrivalTime = 0;
     

    while (currentTime < 200) {
    	
    	
      	wait.peek().turnaroundTime=currentTime+wait.peek().burstTime<=200 ?
    			currentTime+wait.peek().burstTime- wait.peek().originalArraivalTime
    			:200-wait.peek().originalArraivalTime;
    	wait.peek().waitingTime+=currentTime-wait.peek().arrivalTime;
    	
    	
    	
    	

    	if((index++)%5==0 )
    	{
    		System.out.println();
    		
    	}
    	if(currentTime!=200)
    	  System.out.print("("+currentTime+" :"+wait.peek().name+")->");
    	  
    	else
    		 System.out.print("("+currentTime+" :"+wait.peek().name+")");

        currentTime += wait.peek().burstTime;
        var proc = wait.peek();
        processes.remove(proc);
        
        proc.arrivalTime = currentTime + proc.comesBackAfter;
        processes.add(proc);
        wait.remove();
        
        for(Process process : processes)
        {
        	if(process.arrivalTime <= currentTime && !wait.contains(process))
        		wait.add(process);
        }
        PriorityQueue<Process> updatedQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.arrivalTime));

        
        //This for increment for each process in ready queue and check if arrive 5 unit time and decrement 1 for priority 
        while (!wait.isEmpty()) {
            Process currentProcess = wait.poll();

            // Modify the priority ( decrement 1 for priority-->make process high priority)
            if(currentTime-currentProcess.arrivalTime>=5 && currentProcess.priority!=0 )
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
    System.out.print("("+200+" :"+wait.peek().name+")");
    System.out.println();
    System.out.println();
    

    for(int i=0;i<processes.size();i++)
    {

    	avgWaitingTime+=processes.get(i).waitingTime;
    	avgTurnaroundTime+=processes.get(i).turnaroundTime;
    }
    
    System.out.println("average waiting time:"+(avgWaitingTime)/7.0);
    System.out.println("average turnaround time."+(avgTurnaroundTime)/7.0);
  
   
    System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");

    }



}
