package noSwing;

public abstract class ActionEvent {
	protected String msg;
	protected Object obj;
	public ActionEvent(Object obj, int id, String message) {
//		System.out.println("ActionEvent.ActionEvent(Object obj, int id, String message)");
		msg = message;
		this.obj = obj;
	}

	public abstract String getActionCommand();
	public abstract String getOutput();
	public abstract Object getSource(); 
}
