import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SRTF {

	
	private static int avgTurnaroundTime;
	private static int avgWaitingTime;
	
    private List<Process> processes = new ArrayList<>();

    public SRTF(List<Process> processes) {
        this.processes = processes;
    }

    static void SRTF_Sch(ArrayList<Process> processes) {
    	
    	double index=0;
    	 int[] arrayOfExecutionTime = new int[150];
    	 
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("Algorithm Shortest Remaining Time First.");

    	int currentTime = processes.get(0).arrivalTime;
    	
    	PriorityQueue<Process> wait = new PriorityQueue<>(Comparator.comparingInt(p -> p.remainingTime));
    	wait.add(processes.get(0));
    	processes.get(0).arrivalTime = 0;
    	
    	//System.out.println("Process id\tArrival time\tBurst time\t RRTime\t currentTime");
    	
    	while (currentTime <= 200) {
    		
    		
        	wait.peek().turnaroundTime=currentTime+wait.peek().burstTime<200 ?
        			currentTime-wait.peek().originalArraivalTime
        			:200-wait.peek().originalArraivalTime;
        	if((currentTime+0.0)%10==0 && currentTime>=10 )
        	{
        		System.out.println("\n");
        		
        	}
        	if(currentTime!=200)
        	  System.out.print("("+currentTime+" :"+wait.peek().name+")->");
        	  
        	else
        		 System.out.print("("+currentTime+" :"+wait.peek().name+")");
	
    		currentTime++;
    		wait.peek().remainingTime--;
    		if(wait.peek().remainingTime==0)
    		{
    			var proc=wait.peek();
    			wait.remove();
    			
    		  processes.remove(proc);
    		  proc.arrivalTime = currentTime + proc.comesBackAfter;
    		  proc.remainingTime = proc.burstTime;
    	      proc.turnaroundTime = currentTime - proc.originalArraivalTime;
    		  processes.add(proc);
    		}

    		
    		for(Process process : processes)
    		{
    			if(process.arrivalTime <= currentTime && !wait.contains(process))
    				wait.add(process);
    		}

    	}
        for(int i=0;i<processes.size();i++)
        {
 
        	//if turn around equal zero that mean the process Didn't run out
        	if(processes.get(i).turnaroundTime==0)
        	{
        		
        		char infinitySymbol = '\u221E';
        		System.out.println("\naverage waiting time :"+infinitySymbol);
        		System.out.println("\naverage turnaround time. :"+infinitySymbol);
        		break;
        	}
        	avgTurnaroundTime+=processes.get(i).turnaroundTime;
        	avgTurnaroundTime+=processes.get(i).waitingTime;
        }

        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");

    }

    
}
