
public class Process {
	String name;
	int burstTime;
	int arrTime;
	int priority;
	int qnt;
	double v1;
	double v2;
	int aFactor;
	
	public Process(String name, int burstTime, int arrTime, int priority, int qnt) {
		this.name = name;
		this.burstTime = burstTime;
		this.arrTime = arrTime;
		this.priority = priority;
		this.qnt = qnt;
		
		this.v1=0;
		this.v2=0;
		this.aFactor=0;
	}

	public double getV1() {
		return v1;
	}

	public void setV1(double v1) {
		this.v1 = v1;
	}

	public double getV2() {
		return v2;
	}

	public void setV2(double v2) {
		this.v2 = v2;
	}

	public int getaFactor() {
		return aFactor;
	}

	public void setaFactor(int aFactor) {
		this.aFactor = aFactor;
	}
	
	
	
	
	
	
}
