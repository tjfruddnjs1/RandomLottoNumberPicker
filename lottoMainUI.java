import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class lottoMainUI extends JFrame {
	
	GUIComponent comp = new GUIComponent();
	
	public lottoMainUI() {
		CreateUI("Random Lotto Picker");
		setContentPane(comp.MainUI());
	}
	
	public void CreateUI(String Title) {
		setTitle(Title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(480,242);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new lottoMainUI();
			}
			
		});
	}

}
