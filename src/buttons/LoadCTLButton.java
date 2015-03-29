package buttons;

import events.ModelFormulaEvent;
import noSwing.ActionListener;
import noSwing.JButton;

public class LoadCTLButton extends JButton {

	public LoadCTLButton(String string) {
		super(string);
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("LoadCTLButton.addActionListener(ActionListener handler)");
		hdlr = handler;
	}

	public void pushed() {
		String val = "CTLFIXME";
		System.out.println("LoadCTLButton pushed");
		ModelFormulaEvent e = new ModelFormulaEvent(this, 1, str, val);
		hdlr.actionPerformed(e);
	}

}
