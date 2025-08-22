//Name:Hasan Qarmash
//Id:1210611
//Section lecture:1
//Name Doctor:Abdel Salam Sayyad 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class roundRobin {
	List<Process> processes = new ArrayList<>();

    public static void roundRobin(List<Process> processes, int quantum) {
    	
    	
  	  int avgTurnaroundTime = 0;
      int avgWaitingTime=0;	
	    	
       int 	index=0;
       
       System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
       System.out.println();
       System.out.println("Algorithm Round Robin, with q = 5.");
       

       System.out.println("Gantt chart:");
       System.out.println();
       System.out.println();
    	int currentTime = processes.get(0).arrivalTime;
    	ArrayList<Process> wait = new ArrayList<>();
    	int indexGanttChart=0;
    	//PriorityQueue<Process> wait = new PriorityQueue<>(Comparator.comparingInt(p -> p.arrivalTime));
    	wait.add(processes.get(0));
    	//processes.get(0).arrivalTime = 0;
    	
    	//System.out.println("Process id\tArrival time\tBurst time\t RRTime\t currentTime");
    	boolean isRemoved = false;
    	while (currentTime < 200) {
    		int remaining = wait.get(index).remainingTime >= quantum ? quantum : wait.get(index).remainingTime;
    		wait.get(index).turnaroundTime=(currentTime+remaining)<=200 ?
        			currentTime+remaining-wait.get(index).originalArraivalTime
        			:wait.get(index).turnaroundTime;
    		
    		wait.get(index).waitingTime+=(currentTime-wait.get(index).arrivalTime);
    		
    	
    		if((indexGanttChart++)%5==0 && currentTime>10 )
        	{
        		System.out.println("");
        		
        	}
        	if(currentTime!=200)
        	  System.out.print("("+currentTime+" :"+wait.get(index).name+")->");
        	  
        	else
        		 System.out.print("("+currentTime+" :"+wait.get(index).name+")");
        	


    		if(wait.get(index).remainingTime < quantum)
    		{
    			currentTime+=wait.get(index).remainingTime;
    			wait.get(index).remainingTime=0;
    			
    		}
    		else
    		{
    			currentTime+=quantum;
    			wait.get(index).remainingTime-=quantum;
    		}
    		if(wait.get(index).remainingTime==0)
    		{
    		
    			var proc=wait.get(index);
    			wait.remove(index);
      		  	processes.remove(proc);
      		  	proc.arrivalTime = currentTime + proc.comesBackAfter;
      		  	proc.remainingTime = proc.burstTime;
      		  	processes.add(proc);
      		  isRemoved = true;
    		}

    		
    		for(Process process : processes)
    		{
    			if(process.arrivalTime <= currentTime && !wait.contains(process))
    				wait.add(process);
    		}
    		if(!isRemoved)
    		{
    			wait.get(index).arrivalTime = currentTime;
    			var proc = wait.get(index);
        		wait.remove(proc);
        		wait.add(proc);
    		}
    		else
    		{
    			isRemoved = false;
    		}
    		

    	}
    	
        System.out.print("("+200+" :"+wait.get(index).name+")");

        System.out.println();
        

        for(int i=0;i<processes.size();i++)
        {

        	avgTurnaroundTime+=processes.get(i).turnaroundTime;
        	avgWaitingTime+=processes.get(i).waitingTime;
        }
        
        System.out.println();
        System.out.println("average turnaround time:"+(avgTurnaroundTime)/(processes.size()+0.0));
        System.out.println("average waiting time:"+(avgWaitingTime)/(processes.size()+0.0));
      
        
       
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        }


    }

	


