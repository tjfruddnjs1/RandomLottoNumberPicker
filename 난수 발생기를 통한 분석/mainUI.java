import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class mainUI extends JFrame {
	
	private JPanel MainContainer = new JPanel();
	private JTextArea boxArea = new JTextArea(5,20);
	private JButton generateBtn;
	private JButton resetBtn;
	private JButton closeBtn;
	
	private JComboBox<Integer> setNumbers;
	private JComboBox<Integer> setDraws;
	
	protected JPanel MainUI() {
		MainContainer.setLayout(new BorderLayout());
		MainContainer.add(setLeftPanel(), BorderLayout.WEST);
		MainContainer.add(setCenterPanel(), BorderLayout.CENTER);
		MainContainer.add(setSouthPanel(), BorderLayout.SOUTH);
		
		return MainContainer;
	}
	
	protected JComponent setLeftPanel() {
		JPanel LeftPanel = new JPanel();
		LeftPanel.setLayout(new BorderLayout());
		
		JLabel RandomizerResultLabel = new JLabel("로또 번호 생성 결과");
		RandomizerResultLabel.setHorizontalAlignment((int)Component.CENTER_ALIGNMENT);
		LeftPanel.add(RandomizerResultLabel, BorderLayout.NORTH);
		LeftPanel.add(ShowTextArea(), BorderLayout.CENTER);
		return LeftPanel;
	}
	
	protected JComponent setCenterPanel() {
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(null);
		
		JLabel RangeLabel = new JLabel("please specify a range of numbers");
		JLabel CounterLabel = new JLabel("Please specify the number of digits.");
		
		setNumbers = (JComboBox<Integer>) setComboBox(2,45);
		setDraws = (JComboBox<Integer>) setComboBox(1,10);
		
		RangeLabel.setSize(200,30);
		CounterLabel.setSize(200,30);
		RangeLabel.setLocation(20,20);
		CounterLabel.setLocation(20,60);
		
		RangeLabel.setToolTipText("The lottery numbers are up to one small number than the specified number.");
		
		setNumbers.setLocation(160,20);
		setDraws.setLocation(160,60);
		
		CenterPanel.add(RangeLabel);
		CenterPanel.add(CounterLabel);
		CenterPanel.add(setNumbers);
		CenterPanel.add(setDraws);
		return CenterPanel;
	}
	
	protected JComponent setSouthPanel() {
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		
		generateBtn = new JButton("generate");
		resetBtn = new JButton("reset");
		closeBtn = new JButton("close");
		
		SouthPanel.add(generateBtn);
		SouthPanel.add(resetBtn);
		SouthPanel.add(closeBtn);
		
		generateBtn.addActionListener(new ButtonActionListener(boxArea,setNumbers,setDraws));
		resetBtn.addActionListener(new ButtonActionListener(boxArea));
		closeBtn.addActionListener(new ButtonActionListener(boxArea, MainContainer));
		
		return SouthPanel;
	}
	
	protected JComponent setComboBox(int firstNumber,int range) {
		
		Vector<Integer> setNumber = new Vector<>();
		JComboBox<Integer> setNumberBox = new JComboBox<>(setNumber);
		
		setNumberBox.setSize(80,30);
		setNumberBox.setSelectedIndex(firstNumber-1);
		
		return setNumberBox;
	}
	
	protected JComponent ShowTextArea() {
		boxArea.setEditable(false);
		JScrollPane SPaneforBoxArea = new JScrollPane(boxArea);
		
		return SPaneforBoxArea;
	}

}
