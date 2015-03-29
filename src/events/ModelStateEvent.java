package events;

import modelCheckCTL.model.ModelEvent;

/**
 * This allows communication with the view.
 * 
 * @author ssiroky
 *
 */
public class ModelStateEvent extends ModelEvent {

	public ModelStateEvent(Object obj, int id, String msg, String val) {
		super(obj, id, msg, val);
	}

	/**
	 * get the message from the model
	 * 
	 * @return String
	 */
	public String getOutput() {
		System.out.println ("ModelStateEvent.getOutput "+message);
		return message;
	}

	public String getActionCommand() {
		System.out.println("ModelStateEvent.getActionCommand()");
		return msg;
	}

	public Object getSource() {
		System.out.println("ModelStateEvent.getSource()");
		return obj;
	}

} // class ModelEvent
