package Structure;

public abstract class Action
{
	protected final Task parent;
	private final String exePath;
	private final int thisStep;
	
	protected Action(String exePath, Task parent){

		this.exePath = exePath + this.getClass().getName();
		this.parent = parent;
		thisStep = parent.actions.size();
		parent.addAction(this);
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
                reset();
			}
		}
		return validate;
	}
	
	private boolean fullValidate()
	{
		return (parent.step == thisStep) && validate();
	}
	
	public void reset() //TO OVERRIDE
	{
		
	}
	
	public void setParentStep(int step)
	{
		parent.step = step;
	}
	
	public void addParentStep(int step)
	{
		parent.step += step;
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

	//to be over written
	protected abstract void execute();



}