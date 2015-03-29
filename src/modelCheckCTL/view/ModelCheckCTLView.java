package modelCheckCTL.view;

//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;

import buttons.LoadCTLButton;
import buttons.LoadKSButton;
import buttons.StateButton;
import noSwing.ActionEvent;
import noSwing.ActionListener;
import noSwing.BorderLayout;
import noSwing.GridLayout;
import noSwing.JFileChooser;
import noSwing.JPanel;
import noSwing.JScrollPane;
import noSwing.JTextArea;
import noSwing.JTextField;
import modelCheckCTL.controller.ModelCheckCTLController;
import modelCheckCTL.model.ModelCheckCTLModel;
import modelCheckCTL.model.ModelEvent;

/**
 * This object is the main object and creates the GUI for the user. It allows a
 * file representing a Kripke Structure to be loaded. It takes a CTL formula and
 * a starting state from the user. Buttons exist to submit all of these items.
 * The GUI also contains a log output area for the results of the actions taken.
 * 
 * @author ssiroky
 *
 */

public class ModelCheckCTLView extends JFrameView {

//	private static final long serialVersionUID = 1L;
	private JTextArea log;
	private JTextField ctlFormula = new JTextField();
	private JTextField startState = new JTextField();
	private JFileChooser fc;
	public static final String CTL_FORMULA = "Submit CTL Formula";
	public static final String KRIPKE_STRUCT = "Load Kripke Structure";
	public static final String CHECK_STATE = "Check starting state";
	public LoadKSButton loadKSButton;
	public LoadCTLButton loadCTLButton;
	public StateButton stateButton;
	private int returnVal;
	private static ModelCheckCTLController ctrl;
	public static ModelCheckCTLView view;
	
	/**
	 * Constructor - Creates the GUI.
	 * 
	 * @param model
	 * @param controller
	 */
	public ModelCheckCTLView(ModelCheckCTLModel model,
			ModelCheckCTLController controller) {
		super(model, controller);

		JPanel textPanel = new JPanel();
		// Field to set ctl formula
		ctlFormula.setText("Enter CTL Formula");
		ctlFormula.setEditable(true);
		startState.setText("Enter Starting State");
		startState.setEditable(true);
		textPanel.setLayout(new GridLayout(1, 2, 5, 5));
		this.getContentPane().add(textPanel, BorderLayout.NORTH);
		textPanel.add(ctlFormula, null);
		textPanel.add(startState, null);

		JPanel buttonPanel = new JPanel();
		FormulaHandler formulaHandler = new FormulaHandler();
		StateHandler stateHandler = new StateHandler();
		KSHandler ksHandler = new KSHandler();
		// Create the open button.
		loadKSButton = new LoadKSButton(KRIPKE_STRUCT);
		loadKSButton.addActionListener(ksHandler);

		// Create the save button.
		loadCTLButton = new LoadCTLButton(CTL_FORMULA);
		loadCTLButton.addActionListener(formulaHandler);

		// Create the save button.
		stateButton = new StateButton(CHECK_STATE);
		stateButton.addActionListener(stateHandler);

		// For layout purposes, put the buttons in a separate panel
		buttonPanel.setLayout(new GridLayout(1, 3, 5, 5));

		// Add the elements
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.add(loadKSButton, null);
		buttonPanel.add(loadCTLButton, null);
		buttonPanel.add(stateButton, null);

		// Create the log
		setLog(new JTextArea(40, 20));
		getLog().setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(getLog());
		this.getContentPane().add(logScrollPane, BorderLayout.SOUTH);

		// Create a file chooser
		fc = new JFileChooser();

		pack();

	} // constructor

	// Now implement the necessary event handling code
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * modelCheckCTL.model.ModelListener#modelChanged(modelCheckCTL.model.ModelEvent
	 * )
	 */
	public void modelChanged(ModelEvent event) {
		String msg = event.getOutput() + "";
		System.out.println("ModelCheckCTLView.modelChanged "+msg);
		getLog().append(msg);
	}

	/**
	 * Display results to the log text area.
	 * 
	 * @param s
	 */
	public void displayResults(String s) {
		System.out.println("ModelCheckCTLView.displayResults ");
		getLog().append(s + "\n");
	} // displayResults

	// Inner classes for Event Handling
	/**
	 * Inner class only used here.
	 * 
	 * @author ssiroky
	 *
	 */
	// Inner classes for Event Handling
	public abstract class Handler implements ActionListener {
		public abstract void actionPerformed(ActionEvent e);
	}
	class KSHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("ModelCheckCTL$KSHander.actionPerformed.operation "+e.getSource());
			if (e.getSource() == loadKSButton) {
				returnVal = fc.showOpenDialog(ModelCheckCTLView.this);
			}
			((ModelCheckCTLController) getController()).operationKS(e
					.getActionCommand());
		}
	}// class Handler
	class FormulaHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("ModelCheckCTL$FormulaHander.actionPerformed.operation "+e.getSource());
			((ModelCheckCTLController) getController()).operationFormula(e
					.getActionCommand());
		}
	}// class Handler
	class StateHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("ModelCheckCTL$StateHander.actionPerformed.operation "+e.getSource());
			if (e.getSource() == loadKSButton) {
				returnVal = fc.showOpenDialog(ModelCheckCTLView.this);
			}
			((ModelCheckCTLController) getController()).operationState(e
					.getActionCommand());
		}
	}// class Handler

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int opt = 1;
		ctrl = new ModelCheckCTLController();
	 	KripkeCTLDriver (opt);
	}

	// getters and setters
	public JTextArea getLog() {
		System.out.println("ModelCheckCTLView.getLog ");
		return log;
	}

	public void setLog(JTextArea log) {
		System.out.println("ModelCheckCTLView.setLog ");
		this.log = log;
	}

	public JTextField getCtlFormula() {
		System.out.println("ModelCheckCTLView.getCTLFormula ");
		return ctlFormula;
	}

	public JTextField getStartState() {
		System.out.println("ModelCheckCTLView.getStartState ");
		return startState;
	}

	public void setStartState(JTextField startState) {
		System.out.println("ModelCheckCTLView.setStartState ");
		this.startState = startState;
	}

	public void setCtlFormula(JTextField ctlFormula) {
		System.out.println("ModelCheckCTLView.setCtlFormula ");
		this.ctlFormula = ctlFormula;
	}

	public JFileChooser getFc() {
		System.out.println("ModelCheckCTLView.getFc ");
		return fc;
	}

	public void setFc(JFileChooser fc) {
		System.out.println("ModelCheckCTLView.setFc ");
		this.fc = fc;
	}

	public int getReturnVal() {
		System.out.println("ModelCheckCTLView.getReturnVal ");
		return returnVal;
	}

	public void setReturnVal(int returnVal) {
		System.out.println("ModelCheckCTLView.setReturnVal ");
		this.returnVal = returnVal;
	}

	//////////////////////////////////////////////////////////////
	// Below is the driver code to make the model work.
	//
	//
	//////////////////////////////////////////////////////////////
	
	public static void KripkeCTLDriver (int option) {
		String basePath = "C:\\Users\\StuartSiroky\\workspace_luna_wala\\modelCheckCTL_noSwing\\DataTestcases\\";
// testcase 1
		String KSFile = basePath+"testKripkeFile2.txt";
		String formula = "E[not c2 U c1]";
		String startStateStr = "s0";
		// testcase 2
		//String KSFile = basePath+"testKripkeFile6.txt";
		//String formula = "AG(t1 implies AF c1)";		
		//String startStateStr = "s0";
		view = (ModelCheckCTLView) ctrl.getView();
		switch(option) {
		case 0: view.LoadKS(KSFile); 
			break;
		case 1: view.LoadCTLFormula(formula); 
			break;
		case 2: view.CheckStartState(startStateStr); 
			break;
		default: 
				System.out.println("No Valid option choosen ");
				System.out.println(" 0 -> Load Kripke Structure");
				System.out.println(" 1 -> Load/Check CTL Formula");
				System.out.println(" 2 -> Check Starting State");
		}
	}

	private void CheckStartState(String ss) {
		startState.setText(ss);
		stateButton.pushed();
	}

	private void LoadCTLFormula(String formula) {
		ctlFormula.setText(formula);
		loadCTLButton.pushed();
	}

	private void LoadKS(String kSFile) {
		setReturnVal(JFileChooser.APPROVE_OPTION);
		getFc().setFile(kSFile);
		ctrl.setKsLoaded(getFc().getSelectedFile());
		stateButton.pushed();
	}
	
	
} // ModelCheckCTLView

