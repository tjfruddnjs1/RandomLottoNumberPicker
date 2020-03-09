import java.awt.*;
import java.util.Vector;
 
import javax.swing.*;
 
public class MainUIComponents extends JFrame {
 
    // 필드 영역
    private JPanel MainContainer = new JPanel();
    private JTextArea BoxArea = new JTextArea(5, 20); 
    private JButton GenerateBtn;
    private JButton ResetBtn;
    private JButton CloseBtn;
    
    private JComboBox<Integer> setRange;
    private JComboBox<Integer> setGenerateCounter;
        
    // MainContainer JPanel에 부착할 구성요소는 3개의 JPanel로 구성되어 있다.
    protected JPanel MainUI() {
        MainContainer.setLayout(new BorderLayout());
        MainContainer.add(setLeftPanel(), BorderLayout.WEST);
        MainContainer.add(setCenterPanel(), BorderLayout.CENTER);
        MainContainer.add(setSouthPanel(), BorderLayout.SOUTH);
        
        return MainContainer;
    }
    
    // JComponent는 Swing 클래스의 최상위 구성요소를 담당합니다.
    // JPanel, JButton, JLabel 등의 Swing 구성요소가 하위 클래스입니다.
    protected JComponent setLeftPanel() {
        JPanel LeftPanel = new JPanel();
        LeftPanel.setLayout(new BorderLayout());
        
        JLabel RandomizerResultLabel = new JLabel("의사 난수 생성 결과");
        RandomizerResultLabel.setHorizontalAlignment((int)Component.CENTER_ALIGNMENT);
        LeftPanel.add(RandomizerResultLabel, BorderLayout.NORTH);
        LeftPanel.add(ShowTextArea(), BorderLayout.CENTER);
        return LeftPanel;
    }
    
    // CenterPanel의 구성요소를 설정합니다.
    protected JComponent setCenterPanel() {
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(null);
        
        // 난수 범위를 지정할 콤보박스 2개를 생성하고, 그에 맞는 툴팁, 라벨을 지정합니다.
        JLabel RangeLabel = new JLabel("난수 발생 범위");
        JLabel CounterLabel = new JLabel("난수 발생 개수");
        
        // 메서드로 생성한 콤보박스에 변수를 넣어 타 클래스에서 활용합니다.
        setRange = (JComboBox<Integer>) setComboBox(2, 80); // 범위는 최소 2에서 80까지
        setGenerateCounter = (JComboBox<Integer>) setComboBox(1, 100); // 생성 횟수는 1에서 100까지
        
        RangeLabel.setSize(200, 30);
        CounterLabel.setSize(200, 30);        
        RangeLabel.setLocation(20, 20);
        CounterLabel.setLocation(20, 60);
        
        // 범위 라벨에 툴팁을 설정합니다.
        RangeLabel.setToolTipText("발생 범위는 0부터 선택한 숫자보다 1 작은 숫자까지입니다.");
        
        setRange.setLocation(160, 20);
        setGenerateCounter.setLocation(160, 60);
        
        CenterPanel.add(RangeLabel);
        CenterPanel.add(CounterLabel);
        CenterPanel.add(setRange);
        CenterPanel.add(setGenerateCounter);
        return CenterPanel;
    }
    
    // SouthPanel의 구성요소를 설정합니다.
    protected JComponent setSouthPanel() {
        JPanel SouthPanel = new JPanel();
        SouthPanel.setLayout(new FlowLayout());
        
        // 리스너를 달아 난수를 생성하고, TextArea를 초기화하며, 프로그램을 종료할 버튼입니다.
        GenerateBtn = new JButton("생성하기");
        ResetBtn = new JButton("초기화하기");
        CloseBtn = new JButton("종료하기");
        
        SouthPanel.add(GenerateBtn);
        SouthPanel.add(ResetBtn);
        SouthPanel.add(CloseBtn);
        
        // 버튼별로 구분해서 리스너 달기, 순서대로 생성하기, 초기화하기, 종료하기
        // 여기서 종료하기는 JOptionPane을 활용합니다.
        GenerateBtn.addActionListener(new ButtonActionListener(BoxArea, setRange, setGenerateCounter));
        ResetBtn.addActionListener(new ButtonActionListener(BoxArea));
        CloseBtn.addActionListener(new ButtonActionListener(BoxArea, MainContainer));
        
        return SouthPanel; 
    }
    
    // 범위를 지정할 콤보박스의 공통 구성요소 메서드입니다.
    protected JComponent setComboBox(int firstNumber, int range) {
        
        Vector<Integer> setNumber = new Vector<>();
        JComboBox<Integer> setNumberBox = new JComboBox<>(setNumber);
        
        for(int i = firstNumber; i < range; i++) {
            setNumber.add(i);
        }
        
        setNumberBox.setSize(80, 30);
        setNumberBox.setSelectedIndex(firstNumber-1); // 현재 모종의 이유로 첫 숫자가 선택되지 않음, 수정 필요
        
        return setNumberBox;
    }
    
    // JTextArea에 스크롤판을 설정하는 메서드입니다.
    protected JComponent ShowTextArea() {
        BoxArea.setEditable(false);
        JScrollPane SPaneforBoxArea = new JScrollPane(BoxArea);
        
        return SPaneforBoxArea;
    }
}