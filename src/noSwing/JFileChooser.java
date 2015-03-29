package noSwing;

import java.io.File;

public class JFileChooser {
	File fname = null;
	
	public static final int APPROVE_OPTION = 0;

	public JFileChooser() {
	}

	public int showOpenDialog(JFrame jf) {
		return 0;
	}

	public File getSelectedFile() {
		return fname;
	}

	public void setFile(String infile) {
		fname = new File(infile);
	}
	
}
