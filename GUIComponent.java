import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIComponent {
	private JPanel mainContainer = new JPanel();
	private JTextArea boxArea = new JTextArea(5,20);
	private JButton startBtn;
	private JButton resetBtn;
	private JButton closeBtn;
	
	private JComboBox<Integer> setRange;
	private JComboBox<Integer> setCounter;
	
	public JPanel MainUI() {
		mainContainer.setLayout(new BorderLayout());
		mainContainer.add(setLeftPanel(), BorderLayout.WEST);
		mainContainer.add(setCenterPanel(), BorderLayout.CENTER);
		mainContainer.add(setSouthPanel(), BorderLayout.SOUTH);
		
		return mainContainer;
	}
	
	public JComponent setLeftPanel() {
		JPanel LeftPanel = new JPanel();
		LeftPanel.setLayout(new BorderLayout());
		
		JLabel lottoResultLabel = new JLabel("Random Lotto Result");
		lottoResultLabel.setHorizontalAlignment((int)Component.CENTER_ALIGNMENT);
		LeftPanel.add(lottoResultLabel,BorderLayout.NORTH);
		LeftPanel.add(ShowTextArea(), BorderLayout.CENTER);
		return LeftPanel;
	}
	
	public JComponent ShowTextArea() {
		boxArea.setEditable(false);
		JScrollPane sPaneForBoxArea = new JScrollPane(boxArea);
		
		return sPaneForBoxArea;
	}
	
	public JComponent setCenterPanel() {
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(null);
		
		JLabel rangeLabel = new JLabel("Lotto Number Range");
		JLabel counterLabel = new JLabel("Lotto Number Counter");
		
		setRange =(JComboBox<Integer>) setComboBox(2,80);
		setCounter = (JComboBox<Integer>) setComboBox(1,100);
		
		rangeLabel.setBounds(20, 20, 200, 30);
		counterLabel.setBounds(20, 60, 200, 30);
		
		rangeLabel.setToolTipText("range is selected number under one");
		
		setRange.setLocation(160, 20);
		setCounter.setLocation(160, 60);
		
		CenterPanel.add(rangeLabel);
		CenterPanel.add(counterLabel);
		CenterPanel.add(setRange);
		CenterPanel.add(setCounter);
		return CenterPanel;
	}
	
	public JComponent setComboBox(int firstNumber, int range) {
		
		Vector<Integer> setNumber = new Vector<>();
		JComboBox<Integer> setNumberBox = new JComboBox<>(setNumber);
		
		for(int i=firstNumber;i<range;i++) {
			setNumber.add(i);
		}
		
		setNumberBox.setSize(80, 30);
		setNumberBox.setSelectedIndex(firstNumber-1);
		
		return setNumberBox;
	}
	
	public JComponent setSouthPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		
		startBtn = new JButton("start");
		resetBtn = new JButton("reset");
		closeBtn = new JButton("close");
		
		southPanel.add(startBtn);
		southPanel.add(resetBtn);
		southPanel.add(closeBtn);
		
		startBtn.addActionListener(new ButtonActionListner(boxArea,setRange,setCounter));
		resetBtn.addActionListener(new ButtonActionListner(boxArea));
		closeBtn.addActionListener(new ButtonActionListner(boxArea,mainContainer));
		
		return southPanel;
		}
}
