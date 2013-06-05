package Structure;

import java.util.ArrayList;

public abstract class Job 
{
	public boolean isJobActive; 
	public final ArrayList<Task> tasks = new ArrayList<Task>();
	private final String exePath;
	private final int taskNumber;
	int step;
	protected final StepOffice parent;

	protected Job(String exePath, StepOffice parent){

		this.exePath = exePath + this.getClass().getName();
		taskNumber = parent.jobs.size();
		this.parent = parent;
		parent.addJob(this);
	}

	public boolean run()
	{
		boolean validate = fullValidate();
		if(validate)
		{
			Report.debug(exePath + " ran");
			execute();
			if(completed())
			{
				parent.nextStep();
                fullReset();
			}
		}
		return validate;
	}

	public void nextStep()
	{
		if(step + 1 >= tasks.size())
		{
			step = 0;
		} else {
			step++;
		}
	}

	void fullReset()
	{
		step = 0;
		reset();
        for (Task task : tasks) {
            task.fullReset();
        }
	}
	
	protected void reset() //TO OVERRIDE
	{
		
	}
	
	private boolean fullValidate()
	{
		return (parent.step == taskNumber) && validate();
	}

	public void addTask(Task newTask)
	{
		tasks.add(newTask);
	}

	protected boolean validate()
	{
		return true;
	}
	
	public void setParentStep(int step)
	{
		parent.step = step;
	}

	protected boolean completed()
	{
		return false;
	}

	protected void execute()
	{
        for (Task task : tasks) {
            boolean executed = task.run();
            if (executed && StepOffice.ONE_AT_A_TIME) {
                return;
            }
        }
	}





}