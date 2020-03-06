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
 
    // Getter, Setter 영역
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
        // 어떤 버튼이 눌렸는지에 따라 실행하는 메서드를 구분합니다.
        String divisor = e.getActionCommand(); 
        switch(divisor) {
        case "생성하기": GenerateNumber(); break;
        case "초기화하기": TextAreaReset(); break;
        case "종료하기": OpenConfirmDialog(); break;
        }
    }
    
    // 무작위 난수를 생성하는 메서드입니다.
    private void GenerateNumber() {
        Random rd = new Random();
        
        // 문자열 배열로 지정해 생성한 난수 개수만큼 각각의 문자열 형태로 전환합니다.
        String rdvalue[] = new String[Integer.parseInt(setGenerateCounter.getSelectedItem().toString())];
        
        // 이에 따라 무작위 난수를 생성한 개수와 범위만큼 생성하고 문자열 배열 rdvalue에 저장합니다.
        for(int i = 0; i<Integer.parseInt(setGenerateCounter.getSelectedItem().toString()); i++) {
            int randomseed = rd.nextInt(Integer.parseInt(setRange.getSelectedItem().toString()));
            rdvalue[i] = Integer.toString(randomseed);
            System.out.println("난수 " + (i+1) + ": " + randomseed);
            textconcator(rdvalue[i], i);
        }
    }
    
    // 문자를 이어붙이고 스크롤판을 맨 밑으로 내립니다.
    private void textconcator(String rngseed, int pos) {
        JTBox.append("난수 " + (pos+1) + ": " + rngseed + "\n");
        JTBox.setCaretPosition(JTBox.getDocument().getLength());
    }
    
    // JTextArea를 초기화합니다.
    private void TextAreaReset() {
        JTBox.setText("");
    }
    
    // 예, 아니오 다이얼로그 상자를 이용해 프로그램을 종료하는 창을 출력합니다.
    private void OpenConfirmDialog() {
        // 버튼의 값에 따라 숫자가 다릅니다. 항상 프로그램 중앙에 출력합니다.
        int exitOption = JOptionPane.showConfirmDialog(MainContainer, "종료하시겠습니까?", "프로그램 종료", JOptionPane.YES_NO_OPTION);
        
        if(exitOption == JOptionPane.YES_OPTION)
            System.exit(JFrame.EXIT_ON_CLOSE);
        else if((exitOption == JOptionPane.NO_OPTION) || (exitOption == JOptionPane.CLOSED_OPTION))
            return;
    }
}
