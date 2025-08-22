//Name:Hasan Qarmash
//Id:1210611
//Section lecture:1
//Name Doctor:Abdel Salam Sayyad 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int comesBackAfter;
    int priority;
    int waitingTime; // Track waiting time for each process
    int watingToCalculate; // Track waiting time for each process
    int turnaroundTime; // Track turnaround time for each process
    int remainingTime;
    int TimeInReadyQueue;
    boolean isExecution=false;
    int originalArraivalTime;
    int originalPriority;
    int NumberOfExecution;
    

    public Process(String name, int arrivalTime, int burstTime, int comesBackAfter, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.comesBackAfter = comesBackAfter;
        this.priority = priority;
        this.waitingTime = 0;
        this.watingToCalculate = 0;
        this.turnaroundTime = 0;
        this.remainingTime=burstTime;
         this.TimeInReadyQueue=0;
         this.originalPriority=priority;
         this.originalArraivalTime=arrivalTime;
         this.NumberOfExecution=0;
    }}




public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Initialize processes
        processes.add(new Process("P1", 0, 10, 2, 3));
        processes.add(new Process("P2", 1, 8, 4, 2));
        processes.add(new Process("P3", 3, 14, 6, 3));
        processes.add(new Process("P4", 4, 7, 8, 1));
        processes.add(new Process("P5", 6, 5, 3, 0));
        processes.add(new Process("P6", 7, 4, 6, 1));
        processes.add(new Process("P7", 8, 6, 9, 2));
        
        List<Process> copy_processess = new ArrayList<>(processes);
        copy_processess=processes;
        
      while(true)
        {
    	  
    	  processes.clear();
        	
          processes.add(new Process("P1", 0, 10, 2, 3));
          processes.add(new Process("P2", 1, 8, 4, 2));
          processes.add(new Process("P3", 3, 14, 6, 3));
          processes.add(new Process("P4", 4, 7, 8, 1));
          processes.add(new Process("P5", 6, 5, 3, 0));
          processes.add(new Process("P6", 7, 4, 6, 1));
          processes.add(new Process("P7", 8, 6, 9, 2));
    	  System.out.println("\t\t\t\t\t\t\tHELLO USER \t\t\t\t\t\t\t \t\t\t");  
    	  
    	  System.out.println("\t\t\t\t Enter your number you want for scheduling algorithms  \t\t\t\t\t\t\t \t\t\t");  
    	  
    	  System.out.println("\t\t\t\t 1- First Come First Served.  \t\t\t\t\t\t\t \t\t\t"); 
    	  System.out.println("\t\t\t\t 2-Shortest Job First.  \t\t\t\t\t\t\t \t\t\t"); 
    	  System.out.println("\t\t\t\t 3-Shortest Remaining Time First.  \t\t\t\t\t\t\t \t\t\t"); 
    	  System.out.println("\t\t\t\t 4-Round Robin, with q = 5  \t\t\t\t\t\t\t \t\t\t"); 
    	  System.out.println("\t\t\t\t 5-Preemptive Priority Scheduling \t\t\t\t\t\t\t \t\t\t"); 
    	  System.out.println("\t\t\t\t 6-Non-preemptive Priority Scheduling  \t\t\t\t\t\t\t \t\t\t"); 
    	  System.out.println("\t\t\t\t 7-Exit  \t\t\t\t\t\t\t \t\t\t"); 

          Scanner scanner = new Scanner(System.in);
         int choice=scanner.nextInt();
         if(choice==7)
         {
        	 break;
         }
          switch (choice) {
		case 1:
			
			FCFS FCFS=new FCFS();
			FCFS.setProcesses(processes);
			FCFS.FCFS_Sch(FCFS.getProcesses());
			
			break;
			
		case 2:
		       SJF SJF=new SJF();

		       SJF.setProcesses(processes);
		       SJF.sjfNonpremetive(new ArrayList<>(SJF.getProcesses()));
		    
			break;
		case 3:
		      SRTF SRTF=new SRTF(processes);
		      SRTF.SRTF_Sch(new ArrayList<>(processes));
			break;
		case 4:
		    int quantum = 5;
	        roundRobin roundRobin=new roundRobin();
	        roundRobin.roundRobin(processes,quantum);
			break;
		case 5:
			 Preemptive_Priority  Preemptive_Priority=new Preemptive_Priority();
			 Preemptive_Priority.Preemptive_Priority_Shc(new ArrayList<>(processes));
			break;
		case 6:
			   Non_preemptive_Priority p=new Non_preemptive_Priority();
		        p.Priority_Nonpremetive(new ArrayList<>(processes));
			break;
		case 7:
			
			break;	

		default:
			break;
		}
    	  
    	  
        }
        


      System.out.print("\t\t\t\t\t\t--------------------GOOD BY :)------------");
  
        
 
        
        
        
  
        
    


      
        
    
        
       
    }}

        


