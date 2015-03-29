package buttons;

import events.ModelStateEvent;
import noSwing.ActionListener;
import noSwing.JButton;

public class StateButton extends JButton {

	public StateButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("StateButton.addActionListener(ActionListener handler)");
		hdlr = handler;	
	}

	public void pushed() {
		String val = "StateFIXME";
		System.out.println("StateButton pushed");
		ModelStateEvent e = new ModelStateEvent(this, 1, str, val);
		hdlr.actionPerformed(e);
	}

}
