package noSwing;

public class JTextArea {

	private boolean editable = false;

	public JTextArea() {
	}

	public JTextArea(String text) {
	}

	public JTextArea(int rows, int columns) {
	}

	public JTextArea(String text, int rows, int columns) {
	}

	public void setEditable(boolean b) {
		this.editable = b;
	}

	public void append(String msg) {
		if (editable)
			System.out.println("LOG_MSG: " + msg);
	}

	public Document getDocument() {
		Document d = new Document();
		return d ;
	}

	public void setCaretPosition(int length) {
		// TODO Auto-generated method stub
		
	}

}
