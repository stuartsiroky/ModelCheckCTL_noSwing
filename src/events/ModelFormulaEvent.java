package events;

import modelCheckCTL.model.ModelEvent;

/**
 * This allows communication with the view.
 * 
 * @author ssiroky
 *
 */
public class ModelFormulaEvent extends ModelEvent {

	public ModelFormulaEvent(Object obj, int id, String msg, String val) {
		super(obj, id, msg, val);
	}

	public String getOutput() {
		System.out.println ("ModelFormulaEvent.getOutput "+message);
		return message;
	}

	public String getActionCommand() {
		System.out.println("ModelFormulaEvent.getActionCommand()");
		return msg;
	}

	public Object getSource() {
		System.out.println("ModelFormulaEvent.getSource()");
		return obj;
	}

} // class ModelEvent
