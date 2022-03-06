package Systems;

public class InternalClock {
	double startTime = 8.00;
	public double newTime;
	double tickRate = 0.04;
	
	public void update() {
		newTime = startTime += 0.04;
		if(newTime >= 12) {
			newTime = 0;
		}
	}
}
