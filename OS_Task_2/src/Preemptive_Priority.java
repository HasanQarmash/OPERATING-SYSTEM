/*Name:Hasan Qarmash
*Id:1210611
*Section lecture:1
*Name Doctor:Abdel Salam Sayyad */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Preemptive_Priority {
	List<Process> processes = new ArrayList<>();

    static void Preemptive_Priority_Shc(ArrayList<Process> processes) {
  	
    	  int avgTurnaroundTime = 0;
          int avgWaitingTime=0;
    	int currentTime = processes.get(0).arrivalTime;
        double index=0;

    	PriorityQueue<Process> wait = new PriorityQueue<>((p1, p2) -> {
            // Compare by priority first
            int priorityComparison = Integer.compare(p1.priority, p2.priority);

            // If priority is the same, compare by arrivalTime
            return (priorityComparison != 0) ? priorityComparison : Integer.compare(p1.arrivalTime, p2.arrivalTime);
        });
    	wait.add(processes.get(0));
    	processes.get(0).arrivalTime = 0;
    	
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("preemptive Priority Scheduling\n\n\nGantt Chart\n");
    	while (currentTime <= 200) {
    		
    		wait.peek().turnaroundTime=currentTime+wait.peek().burstTime<200 ?
        			currentTime-wait.peek().originalArraivalTime
        			:200-wait.peek().originalArraivalTime;

        	if((index++)%5==0 )
        	{
        		System.out.println();
        		
        	}
        	if(currentTime!=200)
        	  System.out.print("("+currentTime+" :"+wait.peek().name+")->");
        	  
        	else
        		 System.out.print("("+currentTime+" :"+wait.peek().name+")");

    		
    		currentTime++;
    		wait.peek().remainingTime--;
    		
    		//should be adding waiting time here
    		ArrayList<Process> temp = new ArrayList<>();
    		while (!wait.isEmpty()) {
    			temp.add(wait.poll());
    		}
    		
    		
    		for(int i = 1; i<temp.size(); i++ )
    		{
    			temp.get(i).watingToCalculate++;
    			int mod=temp.get(i).watingToCalculate/5;
    			if(mod>0 && temp.get(i).priority!=0 )
                {
    			  temp.get(i).priority = temp.get(i).originalPriority;
                  int priorty = getProcessByName(processes, temp.get(i).name) - mod;
                  temp.get(i).priority = priorty < 0 ? 0 : priorty;
                }
    		}
    		
    		for(int i = 0; i<temp.size(); i++ )
    		{
    			wait.add(temp.get(i));
    		}
    		

    		for (Process process : temp) {
    			if(process.remainingTime==0)
        		{
        			wait.remove(process);
        			
        		  processes.remove(process);
        		  process.arrivalTime = currentTime + process.comesBackAfter;
        		  process.remainingTime = process.burstTime;
        		  process.priority= process.originalPriority;
        		  process.waitingTime+=process.watingToCalculate;
        		  process.watingToCalculate = 0;
        		  processes.add(process);
        		}
			}


    		
    		for(Process process : processes)
    		{
    			if(process.arrivalTime <= currentTime && !wait.contains(process))
    				wait.add(process);
    		}
		
    	}
        for(int i=0;i<processes.size();i++)
        {
        	avgTurnaroundTime+=processes.get(i).turnaroundTime;
        	avgWaitingTime+=processes.get(i).waitingTime;
        
        }
        
        System.out.println("\naverage turnaround time:"+(avgTurnaroundTime)/7.0);
        System.out.println("average waiting time:"+(avgWaitingTime)/7.0);
      
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    	
    }
    
    
    private static int getProcessByName(ArrayList<Process> processes, String name) {
        for (Process process : processes) {
            if (process.name.equals(name)) {
                return process.priority;
            }
        }
        // Return null if not found
        return 0;
    }

}
