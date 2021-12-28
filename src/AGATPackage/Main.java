package AGATPackage;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.TreeSet;

public class Main {
	static int maxTime = 0;
	static int maxArrTime;
	static double v1;
	static ArrayList<Process> pList = new ArrayList<>();
	static ArrayList<Process> readyQ = new ArrayList<>();
	static ArrayList<Process> deadList = new ArrayList<>();

	public static void main(String[] args) {

		Comparator<Process> comparator = Comparator.comparing(Process::getArrTime);
		TreeSet<Process> sortedP = new TreeSet<>(comparator);

		pList.add(new Process("p1", 17, 0, 4, 4));
		pList.add(new Process("p2", 6, 3, 9, 3));
		pList.add(new Process("p3", 10, 4, 3, 5));
		pList.add(new Process("p4", 4, 29, 8, 2));
		
		// 'sortedP' list to add each process when arrived in its arrival time
		sortedP.addAll(pList);

		//System.out.println(sortedP);

		
		  double v2; 
		  v1 = maxArrTime > 10? maxArrTime/10: 1;
		  
		  
		  boolean preemptive = false;
		  int i=0;
		  Process currP = null;
		  while(i<maxTime) {
			  
			  if(!sortedP.isEmpty())
			  {
				 if(i == sortedP.first().arrTime)
				 {
					 readyQ.add(sortedP.pollFirst());
					 System.out.println(readyQ);
					 if(preemptive)
					 {
						 preemptive = false;
						 
						 currP.qnt += currP.currQnt;
						 readyQ.add(currP);
						 
						 currP = getBestAGAT();
						 v2 = prepareA2();
						 updateAGAT(v2);
						 currP.currQnt = (int)Math.round(currP.qnt * 0.4);
						 
					 }
				 }
			 }
			 
			 // this only for first process
			 if(currP == null)
			 {
				 currP = readyQ.get(0);
				 readyQ.remove(0);
				 v2 = prepareA2();
				 updateAGAT(v2);
				 currP.currQnt = (int)Math.round(currP.qnt * 0.4);
				 
			 }
			 
			 // in this case we will move from non-preemptive to preemptive
			 if(currP.currQnt == 0)
			 {
				 preemptive = true;
				 readyQ.add(currP);
				 Process tmp = getBestAGAT();
				 
				 if(tmp != currP)
				 {
					 
					 currP = tmp;
				 }
				 else
				 {
					 currP.currQnt = currP.qnt - (int)Math.round(currP.qnt * 0.4);
				 }
			 }
			 
			 // a process has finished its work
			 if(currP.burstTime == 0)
			 {
				 currP.qnt = 0;
				 int tmpIdx = getIndexByName(currP.name);
				 deadList.add(currP);
				 pList.remove(tmpIdx);
				 
				 
			 }
			 
			 currP.decreaseQnt();
			 i++;
		  }
		 

	}

	static int getIndexByName(String name)
	{
		for (int i = 0; i < pList.size(); i++) {
			if(name == pList.get(i).name)
			{
				return i;
			}
		}
		
		return -1;
	}
	static double prepareA2()
	{
		double num= -1;
		for (Process process : pList) {
			if(process.burstTime > num)
			{
				num = process.burstTime;
			}
		}
		
		
		return num > 10? num/10: 1;
	}
	static void updateAGAT(double v2) {
		for (Process process : pList) {
			process.setAFactor(v2);
		}
	}

	
	
	// get best AGAT process from readyQ
	static Process getBestAGAT() {
		Process tmp = new Process();
		tmp.aFactor = 20;
		int idx = -1;

		for (int i = 0; i < readyQ.size(); i++) {
			if (readyQ.get(i).aFactor < tmp.aFactor) {
				tmp = readyQ.get(i);
				idx = i;
			}
		}
		if(!readyQ.isEmpty())
		{
			readyQ.remove(idx);
			return tmp;
		}

		return null;
	}

}
