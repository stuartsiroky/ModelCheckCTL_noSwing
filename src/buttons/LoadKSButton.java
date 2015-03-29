package buttons;

import events.ModelKSEvent;
import noSwing.ActionListener;
import noSwing.JButton;

public class LoadKSButton extends JButton {

	public LoadKSButton(String string) {
		super(string);
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("LoadKSButton.addActionListener(ActionListener handler)");
		hdlr = handler;
	}

	public void pushed() {
		String val = "LoadKSButton FIXME";
		System.out.println("LoadKSButton pushed");
		ModelKSEvent e = new ModelKSEvent(this, 1, str, val);
		hdlr.actionPerformed(e);
	}

}
