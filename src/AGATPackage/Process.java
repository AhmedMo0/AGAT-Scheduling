package AGATPackage;

public class Process {
	String name;
	int burstTime;
	int arrTime;
	int priority;
	int qnt;
	int aFactor;
	int currQnt;
	
	public Process() {}
	
	public Process(String name, int burstTime, int arrTime, int priority, int qnt) {
		this.name = name;
		this.burstTime = burstTime;
		this.arrTime = arrTime;
		this.priority = priority;
		this.qnt = qnt;
		this.aFactor = 0;
		//this.currQnt = 0;
		
		Main.maxTime += burstTime;
		
		// get max arrival time
		Main.maxArrTime = arrTime > Main.maxArrTime? arrTime: Main.maxArrTime;
		
		
	}

	
	public void decreaseQnt()
	{
		currQnt--;
		burstTime--;
	}
	
	public int getaFactor() {
		return aFactor;
	}


	
	public void setAFactor(double v2)
	{
		this.aFactor = (10-priority) + (int)Math.ceil(arrTime/Main.v1) + (int)Math.ceil(burstTime/v2);
	}
	
	public int getArrTime()
	{
		return arrTime;
	}

	@Override
	public String toString() {
		return "Process [name=" + name + ", burstTime=" + burstTime + ", arrTime=" + arrTime + ", priority=" + priority
				+ ", qnt=" + qnt + ", aFactor=" + aFactor + ", currQnt=" + currQnt + "]\n";
	}
	
	
	
}
