import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ButtonActionListener implements ActionListener{
	private JTextArea JTBox;
    private JComboBox<Integer> setRange;
    private JComboBox<Integer> setGenerateCounter;
    private JPanel MainContainer;
 
    public ButtonActionListener(JTextArea JTBox) {
        this.JTBox = JTBox;
    }
    
    public ButtonActionListener(JTextArea JTBox, JPanel MainContainer) {
        this.JTBox = JTBox;
        this.setMainContainer(MainContainer);
    }
    
    public ButtonActionListener(JTextArea JTBox, JComboBox<Integer> setRange, JComboBox<Integer> setGenerateCounter) {
        this.JTBox = JTBox;
        this.setSetRange(setRange);
        this.setSetGenerateCounter(setGenerateCounter);
    }
 
    // Getter, Setter ����
    public JPanel getMainContainer() {
        return MainContainer;
    }
 
    public void setMainContainer(JPanel mainContainer) {
        MainContainer = mainContainer;
    }
 
    public JComboBox<Integer> getSetGenerateCounter() {
        return setGenerateCounter;
    }
 
    public void setSetGenerateCounter(JComboBox<Integer> setGenerateCounter) {
        this.setGenerateCounter = setGenerateCounter;
    }
 
    public JComboBox<Integer> getSetRange() {
        return setRange;
    }
 
    public void setSetRange(JComboBox<Integer> setRange) {
        this.setRange = setRange;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // � ��ư�� ���ȴ����� ���� �����ϴ� �޼��带 �����մϴ�.
        String divisor = e.getActionCommand(); 
        switch(divisor) {
        case "�����ϱ�": GenerateNumber(); break;
        case "�ʱ�ȭ�ϱ�": TextAreaReset(); break;
        case "�����ϱ�": OpenConfirmDialog(); break;
        }
    }
    
    // ������ ������ �����ϴ� �޼����Դϴ�.
    private void GenerateNumber() {
        Random rd = new Random();
        
        // ���ڿ� �迭�� ������ ������ ���� ������ŭ ������ ���ڿ� ���·� ��ȯ�մϴ�.
        String rdvalue[] = new String[Integer.parseInt(setGenerateCounter.getSelectedItem().toString())];
        
        // �̿� ���� ������ ������ ������ ������ ������ŭ �����ϰ� ���ڿ� �迭 rdvalue�� �����մϴ�.
        for(int i = 0; i<Integer.parseInt(setGenerateCounter.getSelectedItem().toString()); i++) {
            int randomseed = rd.nextInt(Integer.parseInt(setRange.getSelectedItem().toString()));
            rdvalue[i] = Integer.toString(randomseed);
            System.out.println("���� " + (i+1) + ": " + randomseed);
            textconcator(rdvalue[i], i);
        }
    }
    
    // ���ڸ� �̾���̰� ��ũ������ �� ������ �����ϴ�.
    private void textconcator(String rngseed, int pos) {
        JTBox.append("���� " + (pos+1) + ": " + rngseed + "\n");
        JTBox.setCaretPosition(JTBox.getDocument().getLength());
    }
    
    // JTextArea�� �ʱ�ȭ�մϴ�.
    private void TextAreaReset() {
        JTBox.setText("");
    }
    
    // ��, �ƴϿ� ���̾�α� ���ڸ� �̿��� ���α׷��� �����ϴ� â�� ����մϴ�.
    private void OpenConfirmDialog() {
        // ��ư�� ���� ���� ���ڰ� �ٸ��ϴ�. �׻� ���α׷� �߾ӿ� ����մϴ�.
        int exitOption = JOptionPane.showConfirmDialog(MainContainer, "�����Ͻðڽ��ϱ�?", "���α׷� ����", JOptionPane.YES_NO_OPTION);
        
        if(exitOption == JOptionPane.YES_OPTION)
            System.exit(JFrame.EXIT_ON_CLOSE);
        else if((exitOption == JOptionPane.NO_OPTION) || (exitOption == JOptionPane.CLOSED_OPTION))
            return;
    }
}
