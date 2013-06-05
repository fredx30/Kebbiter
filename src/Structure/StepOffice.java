package Structure;

import java.util.ArrayList;

public class StepOffice {

	public final ArrayList<Job> jobs = new ArrayList<Job>();
	int step = 0;

	private static final long SLEEP_TIME = 500;
	public static final boolean ONE_AT_A_TIME = true;

	private long lastExecution;

	public void run() {
		if (System.currentTimeMillis() - lastExecution >= StepOffice.SLEEP_TIME) {
            for (Job job : jobs) {
                job.run();
            }
			lastExecution = System.currentTimeMillis();
		}

	}

	public void addJob(Job newJob) {
		jobs.add(newJob);
	}

	public void nextStep() {
		if (step + 1 >= jobs.size()) {
			step = 0;
		} else {
			step++;
		}
	}

}
