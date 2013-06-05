package Structure;

import java.util.ArrayList;

public class Task 
{
	
	private final String exePath;
	int step;
	private final Job parent;
	final ArrayList<Action> actions = new ArrayList<Action>();
	private final int taskNumber;
	 
	protected Task(String exePath, Job parent){
	
		this.exePath = exePath + this.getClass().getName();
		this.parent = parent;
		taskNumber = parent.tasks.size();
		parent.addTask(this);
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
	
	public void addAction(Action action)
	{
		actions.add(action);
	}
	
	public void fullReset()
	{
		step = 0;
		reset();
        for (Action action : actions) {
            action.reset();
        }
	}
	
	protected void reset() //TO OVERRIDE
	{
		
	}
	
	public void nextStep()
	{
		if(step + 1 >= actions.size())
		{
			step = 0;
		} else {
			step++;
		}
	}
	
	private boolean fullValidate()
	{
		return (parent.step == taskNumber) && validate();
	}
	
	public void setParentStep(int step)
	{
		parent.step = step;
	}
	
	//to be over written
    protected boolean validate()
	{
		return true;
	}
	
	//to be over written
    protected boolean completed()
	{
		return false;
	}
	
	protected void execute()
	{
        for (Action action : actions) {
            boolean executed = action.run();
            if (executed && StepOffice.ONE_AT_A_TIME) {
                return;
            }
        }
	}
	
	

}