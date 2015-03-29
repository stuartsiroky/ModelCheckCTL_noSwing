package noSwing;

public class JTextField {
boolean editable = false;
String text = "";
	public void setText(String string) {
		System.out.println("JTextField.setText "+string);
		text = string;
	}

	public void setEditable(boolean b) {
		System.out.println("JTextField.setEditable "+b);
		editable = b;
	}

	public String getText() {
		System.out.println("JTextField.getText "+text);
		return text;
	}

}
