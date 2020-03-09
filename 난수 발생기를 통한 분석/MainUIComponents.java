import java.awt.*;
import java.util.Vector;
 
import javax.swing.*;
 
public class MainUIComponents extends JFrame {
 
    // �ʵ� ����
    private JPanel MainContainer = new JPanel();
    private JTextArea BoxArea = new JTextArea(5, 20); 
    private JButton GenerateBtn;
    private JButton ResetBtn;
    private JButton CloseBtn;
    
    private JComboBox<Integer> setRange;
    private JComboBox<Integer> setGenerateCounter;
        
    // MainContainer JPanel�� ������ ������Ҵ� 3���� JPanel�� �����Ǿ� �ִ�.
    protected JPanel MainUI() {
        MainContainer.setLayout(new BorderLayout());
        MainContainer.add(setLeftPanel(), BorderLayout.WEST);
        MainContainer.add(setCenterPanel(), BorderLayout.CENTER);
        MainContainer.add(setSouthPanel(), BorderLayout.SOUTH);
        
        return MainContainer;
    }
    
    // JComponent�� Swing Ŭ������ �ֻ��� ������Ҹ� ����մϴ�.
    // JPanel, JButton, JLabel ���� Swing ������Ұ� ���� Ŭ�����Դϴ�.
    protected JComponent setLeftPanel() {
        JPanel LeftPanel = new JPanel();
        LeftPanel.setLayout(new BorderLayout());
        
        JLabel RandomizerResultLabel = new JLabel("�ǻ� ���� ���� ���");
        RandomizerResultLabel.setHorizontalAlignment((int)Component.CENTER_ALIGNMENT);
        LeftPanel.add(RandomizerResultLabel, BorderLayout.NORTH);
        LeftPanel.add(ShowTextArea(), BorderLayout.CENTER);
        return LeftPanel;
    }
    
    // CenterPanel�� ������Ҹ� �����մϴ�.
    protected JComponent setCenterPanel() {
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(null);
        
        // ���� ������ ������ �޺��ڽ� 2���� �����ϰ�, �׿� �´� ����, ���� �����մϴ�.
        JLabel RangeLabel = new JLabel("���� �߻� ����");
        JLabel CounterLabel = new JLabel("���� �߻� ����");
        
        // �޼���� ������ �޺��ڽ��� ������ �־� Ÿ Ŭ�������� Ȱ���մϴ�.
        setRange = (JComboBox<Integer>) setComboBox(2, 80); // ������ �ּ� 2���� 80����
        setGenerateCounter = (JComboBox<Integer>) setComboBox(1, 100); // ���� Ƚ���� 1���� 100����
        
        RangeLabel.setSize(200, 30);
        CounterLabel.setSize(200, 30);        
        RangeLabel.setLocation(20, 20);
        CounterLabel.setLocation(20, 60);
        
        // ���� �󺧿� ������ �����մϴ�.
        RangeLabel.setToolTipText("�߻� ������ 0���� ������ ���ں��� 1 ���� ���ڱ����Դϴ�.");
        
        setRange.setLocation(160, 20);
        setGenerateCounter.setLocation(160, 60);
        
        CenterPanel.add(RangeLabel);
        CenterPanel.add(CounterLabel);
        CenterPanel.add(setRange);
        CenterPanel.add(setGenerateCounter);
        return CenterPanel;
    }
    
    // SouthPanel�� ������Ҹ� �����մϴ�.
    protected JComponent setSouthPanel() {
        JPanel SouthPanel = new JPanel();
        SouthPanel.setLayout(new FlowLayout());
        
        // �����ʸ� �޾� ������ �����ϰ�, TextArea�� �ʱ�ȭ�ϸ�, ���α׷��� ������ ��ư�Դϴ�.
        GenerateBtn = new JButton("�����ϱ�");
        ResetBtn = new JButton("�ʱ�ȭ�ϱ�");
        CloseBtn = new JButton("�����ϱ�");
        
        SouthPanel.add(GenerateBtn);
        SouthPanel.add(ResetBtn);
        SouthPanel.add(CloseBtn);
        
        // ��ư���� �����ؼ� ������ �ޱ�, ������� �����ϱ�, �ʱ�ȭ�ϱ�, �����ϱ�
        // ���⼭ �����ϱ�� JOptionPane�� Ȱ���մϴ�.
        GenerateBtn.addActionListener(new ButtonActionListener(BoxArea, setRange, setGenerateCounter));
        ResetBtn.addActionListener(new ButtonActionListener(BoxArea));
        CloseBtn.addActionListener(new ButtonActionListener(BoxArea, MainContainer));
        
        return SouthPanel; 
    }
    
    // ������ ������ �޺��ڽ��� ���� ������� �޼����Դϴ�.
    protected JComponent setComboBox(int firstNumber, int range) {
        
        Vector<Integer> setNumber = new Vector<>();
        JComboBox<Integer> setNumberBox = new JComboBox<>(setNumber);
        
        for(int i = firstNumber; i < range; i++) {
            setNumber.add(i);
        }
        
        setNumberBox.setSize(80, 30);
        setNumberBox.setSelectedIndex(firstNumber-1); // ���� ������ ������ ù ���ڰ� ���õ��� ����, ���� �ʿ�
        
        return setNumberBox;
    }
    
    // JTextArea�� ��ũ������ �����ϴ� �޼����Դϴ�.
    protected JComponent ShowTextArea() {
        BoxArea.setEditable(false);
        JScrollPane SPaneforBoxArea = new JScrollPane(BoxArea);
        
        return SPaneforBoxArea;
    }
}