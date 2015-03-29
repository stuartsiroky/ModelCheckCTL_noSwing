package noSwing;

public class JFrame {

	public void pack() {
		System.out.println("JFrame.pack()");
	}

	public Container getContentPane() {
		System.out.println("JFrame.getContentPane()");
		return new Container();
	}

	public void setVisible(boolean b) {
		System.out.println("JFrame.setVisible(boolean b)");
	}

}
