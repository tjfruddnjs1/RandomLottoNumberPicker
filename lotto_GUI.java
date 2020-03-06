import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lotto_GUI extends JFrame{
		
		private JButton setButton;
		private JPanel panel;
		private JLabel label;
		private Toolkit tk;
		private Dimension dim,fdim;
		private int x,fx;
		private int y,fy;
		
    public lotto_GUI(String title){
    	super(title);
    	
    	panel = new JPanel();
        label = new JLabel("Number Setting");
        setButton = new JButton("Setting");
        setButton.addActionListener(new listener());
        
        panel.add(label);
        panel.add(setButton);
        add(panel);
       
        this.init();
        this.exitButton();
       
        //Toolkit : screen,Image class        
        tk = Toolkit.getDefaultToolkit();
        dim = tk.getScreenSize();     
        x = (int)dim.getWidth();                    
        y = (int)dim.getHeight();         
        
        //Screen Size Setting
        super.setSize(800, 600);
        fdim = super.getSize();   
        fx = (int)fdim.getWidth();
        fy = (int)fdim.getHeight();
       
        //Screen location
        super.setLocation(x/2-fx/2, y/2-fy/2);
        
        //Icon Setting
		Image img = tk.getImage("lotto.png");
        this.setIconImage(img);
        
        super.setVisible(true);
       
    }
    
    public void init(){
        Container contain = super.getContentPane(); 
    }

    public void exitButton(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    
    class listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == setButton) {
				final Frame fs = new Frame("Setting");
				fs.setVisible(true);
				fs.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						fs.setVisible(false);
						fs.dispose();
					}
				});
				fs.setSize(300,200);
				fs.setLocation(x/2-fx/2+250, y/2-fy/2+100);
				
			}
		}
    	
    }
   
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true); 
        lotto_GUI s = new lotto_GUI("Random Lotto picker");
    }
}