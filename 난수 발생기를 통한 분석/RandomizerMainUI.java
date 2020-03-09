
import javax.swing.*;
 
public class RandomizerMainUI extends JFrame {
 
    // Swing 구성요소를 담고 있는 클래스
    MainUIComponents comp = new MainUIComponents();
    
    public RandomizerMainUI() {
        CreateUI("무작위 난수 생성기"); // 메인프레임 생성
        setContentPane(comp.MainUI());
        // 메인프레임의 주 콘텐트판을 MainUIComponents 클래스의 MainUI() 메서드의 값으로 설정합니다.
    }
    
    public void CreateUI(String Title) {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(480, 242); // 16:9 기본 해상도
        setResizable(false);
        setLocationRelativeTo(null); // 시작시 화면 중앙에 프로그램 표시
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
