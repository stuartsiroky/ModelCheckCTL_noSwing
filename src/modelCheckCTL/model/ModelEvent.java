package modelCheckCTL.model;

import noSwing.ActionEvent;

//REMOVE import java.awt.event.ActionEvent;

/**
 * This allows communication with the view.
 * 
 * @author ssiroky
 *
 */
public abstract class ModelEvent extends ActionEvent {

//	private static final long serialVersionUID = 1L;
	protected String message;

	public ModelEvent(Object obj, int id, String msg, String val) {
		super(obj, id, msg);
		message = val;
		// can have case statement here to deal with differ id's
	}
	public abstract String getOutput() ;
	public abstract String getActionCommand() ;
	public abstract Object getSource() ;


} // class ModelEvent
