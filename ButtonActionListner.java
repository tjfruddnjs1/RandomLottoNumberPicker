import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ButtonActionListner implements ActionListener {
	private JTextArea JTbox;
	private JComboBox<Integer> setRange;
	private JComboBox<Integer> setCounter;
	private JPanel mainContainer;
	
	public ButtonActionListner(JTextArea JTbox) {
		this.JTbox = JTbox;
	}
	
	public ButtonActionListner(JTextArea JTbox, JPanel mainContainer) {
		this.JTbox = JTbox;
		this.setMainContainer(mainContainer);
	}
	
	public ButtonActionListner(JTextArea JTbox, JComboBox<Integer> setRange , JComboBox<Integer> setGenerateCounter) {
		this.JTbox = JTbox;
		this.setSetRange(setRange);
		this.setSetGenerateCounter(setGenerateCounter);
	}
	
	public JPanel getMainContainer() {
		return mainContainer;
	}
	
	public void setMainContainer(JPanel mainContainer) {
		this.mainContainer = mainContainer;
	}
	
	public JComboBox<Integer> getSetGenerateCounter(){
		return setCounter;
	}
	
	public void setSetGenerateCounter(JComboBox<Integer> setGenerateCounter) {
	        this.setCounter = setGenerateCounter;
	}
	 
	public JComboBox<Integer> getSetRange() {
	        return setRange;
	}
	 
	public void setSetRange(JComboBox<Integer> setRange) {
	        this.setRange = setRange;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String divisor = e.getActionCommand();
		switch(divisor) {
		case "start" : generateNumber(); break;
		case "reset" : textAreaReset(); break;
		case "close"  : OpenConfirmDialog(); break;
		}
	}
	
	private void generateNumber() {
		Random rd = new Random();
		
		String val[] = new String[Integer.parseInt(setCounter.getSelectedItem().toString())];
		
		for(int i=0;i<Integer.parseInt(setCounter.getSelectedItem().toString());i++) {
			int random = rd.nextInt(Integer.parseInt(setRange.getSelectedItem().toString()));
			val[i] = Integer.toString(random);
			System.out.println("Lotto Number" + (i+1) + ":" + random);
			textconcator(val[i],i);
		}
	}
	
	private void textconcator(String seed, int pos) {
		JTbox.append("Lotto" + (pos+1)+":"+seed+"\n");
		JTbox.setCaretPosition(JTbox.getDocument().getLength());
	}
	
	private void textAreaReset() {
		JTbox.setText("");
	}
	
	private void OpenConfirmDialog() {
		int exitOption = JOptionPane.showConfirmDialog(mainContainer, "Exit?", "program exit", JOptionPane.YES_NO_OPTION);
		
		if(exitOption == JOptionPane.YES_OPTION) System.exit(JFrame.EXIT_ON_CLOSE);
		else if((exitOption == JOptionPane.NO_OPTION) || (exitOption == JOptionPane.CLOSED_OPTION))
			return;
	}

}
