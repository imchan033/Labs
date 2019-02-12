package kr.or.bit;

public class Computer {
	public String brandname;
	public String model;
	public String macAddress;
	
	public double memoryUsage;
	public double networkUsage;
	public double cpuUsage;
	public boolean power;
	
	Cpu cpu;
	Mainboard mainboard;
	Monitor monitor;
	Speaker speaker;
	Keyboard keyboard;
	Mouse mouse;
	
	public void getInformation() {
		System.out.println("������ : "+brandname);
		System.out.println("�𵨸� : "+model);
		System.out.println("Mac�ּ� : "+macAddress);	
	}
	
	public void getMemoryUsage() {
		System.out.println("���� �޸� ��뷮 : "+this.memoryUsage);
	}
	public void getNetworkUsage() {
		System.out.println("���� �޸� ��뷮 : "+this.networkUsage);
	}
	public void getCpuUsage() {
		System.out.println("���� �޸� ��뷮 : "+this.cpuUsage);
	}
	public void setPowerOn() {
		this.power = true;
	}
	public void setPowerOff() {
		this.power = false;
	}
	
}
class Cpu{
	String modelName;
	int core;
	int thread;
	int capacity;
	
}
class Mainboard{
	String modelName;
	int slot;
	int memoryCapacity;
}
class Monitor{
	String modelName;
	int size;
	boolean power;
}
class Speaker{
	String modelName;
}
class Keyboard{
	
}
class Mouse{
	
}
