
import javax.swing.*;
 
public class RandomizerMainUI extends JFrame {
 
    // Swing ������Ҹ� ��� �ִ� Ŭ����
    MainUIComponents comp = new MainUIComponents();
    
    public RandomizerMainUI() {
        CreateUI("������ ���� ������"); // ���������� ����
        setContentPane(comp.MainUI());
        // ������������ �� ����Ʈ���� MainUIComponents Ŭ������ MainUI() �޼����� ������ �����մϴ�.
    }
    
    public void CreateUI(String Title) {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(480, 242); // 16:9 �⺻ �ػ�
        setResizable(false);
        setLocationRelativeTo(null); // ���۽� ȭ�� �߾ӿ� ���α׷� ǥ��
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new RandomizerMainUI();    
            }
        });
    }
}
