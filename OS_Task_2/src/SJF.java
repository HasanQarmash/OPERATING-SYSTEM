//Name:Hasan Qarmash
//Id:1210611
//Section lecture:1
//Name Doctor:Abdel Salam Sayyad 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SJF {
	private static double avgTurnaroundTime;
	private static double avgWaitingTime;
	
	
	List<Process> processes = new ArrayList<>();

	public List<Process> getProcesses() {
		return processes;
	}


	

	    static void sjfNonpremetive(ArrayList<Process> processes) {

	    	int indexTime=0;
	    	int indexName=0;
	    	 int[] arrayOfExecutionTime = new int[150];
	    	 String[] arrayOfNameProcess=new String[150];
	        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	        System.out.println("Algorithm Shortest Job First.");
	        System.out.println();
	        int currentTime = processes.get(0).arrivalTime;

	        PriorityQueue<Process> wait = new PriorityQueue<>(Comparator.comparingInt(p -> p.burstTime));
	        wait.add(processes.get(0));
	       
	        processes.get(0).arrivalTime = 0;
	         
	      

	        while (currentTime < 200) {
	        	
	        	arrayOfNameProcess[indexName++]=wait.peek().name;
	        	wait.peek().turnaroundTime=currentTime+wait.peek().burstTime<200 ?
	        			currentTime+wait.peek().burstTime- wait.peek().originalArraivalTime
	        			:200-wait.peek().originalArraivalTime;
	        	wait.peek().waitingTime+=currentTime-wait.peek().arrivalTime;
	        	arrayOfExecutionTime[indexTime++]=currentTime;
	        	

	        	if((currentTime+0.0)%10==0 && currentTime>10 )
	        	{
	        		System.out.println("\n");
	        		
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


	            }


	        System.out.println();
	        System.out.println();

	        System.out.print("Gantt chart:");
	        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
   
	       for(int i=0;i<30;i++)
	       {
	    	   
	    	   System.out.print(" "+arrayOfNameProcess[i]+" |");
	       }
	       System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	       for(int i=0;i<30;i++)
	       {
	    	   if(arrayOfExecutionTime[i]>=100)
	    	   {
	    		   System.out.print(""+arrayOfExecutionTime[i]+"  ");
	    	   }
	    	   else
	    	   {
	    		   
	    		   System.out.print(""+arrayOfExecutionTime[i]+"   ");
	    	   }
	    	   
	       }
	       System.out.print(""+arrayOfExecutionTime[30]+"   ");
	       
	        System.out.print("\n\n------------------------------------------------------------\n");
	        
	       for(int i=30;i<40;i++)
	       {
	    	   
	    	   System.out.print(" "+arrayOfNameProcess[i]+"  |");
	       }
	     //  System.out.println();
	       System.out.print("\n------------------------------------------------------------\n");
	       for(int i=30;i<40;i++)
	       {
	    	   
	    	   System.out.print(""+arrayOfExecutionTime[i]+"   ");
	       }
	       System.out.print(""+"200  ");
	       
  
	       System.out.println();
	       System.out.println();
	        
	        boolean flag=false;
	        for(int i=0;i<processes.size();i++)
	        {
	 
	        	//if turn around equal zero that mean the process Didn't run out
	        	if(processes.get(i).turnaroundTime==0)
	        	{
	        		
	        		char infinitySymbol = '\u221E';
	        		System.out.println("\n\naverage waiting time :"+infinitySymbol);
	        		System.out.println("\naverage turnaround time. :"+infinitySymbol);
	        		flag=true;
	        		break;
	        	}
	        	avgWaitingTime+=processes.get(i).waitingTime;
	        	avgTurnaroundTime+=processes.get(i).turnaroundTime;
	        }
	        if(!flag)
	        {
	        	
	        	System.out.println("\n"+(avgWaitingTime)/4.0);
	        	System.out.println("\n"+(avgTurnaroundTime)/4.0);
	        }

	        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");

	        }




		public void setProcesses(List<Process> processes) {
			this.processes = processes;
		}
	    
	    
	    }

