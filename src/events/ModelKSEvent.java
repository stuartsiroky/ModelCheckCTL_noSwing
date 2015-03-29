package events;

import modelCheckCTL.model.ModelEvent;


/**
 * This allows communication with the view.
 * 
 * @author ssiroky
 *
 */
public class ModelKSEvent extends ModelEvent {

	public ModelKSEvent(Object obj, int id, String msg, String val) {
		super(obj, id, msg, val);
	}

	/**
	 * get the message from the model
	 * 
	 * @return String
	 */
	public String getOutput() {
		System.out.println ("ModelKSEvent.getOutput "+message);
		return message;
	}

	public String getActionCommand() {
		System.out.println("ModelKSEvent.getActionCommand()");
		return msg;
	}

	public Object getSource() {
		System.out.println("ModelKSEvent.getSource()");
		return obj;
	}

} // class ModelEvent
