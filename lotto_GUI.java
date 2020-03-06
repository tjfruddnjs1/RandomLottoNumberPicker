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
		
		static JButton setButton;
		static JPanel panel;
		static JLabel label;
		static Toolkit tk;
		static Dimension dim,fdim;
		static int x,fx;
		static int y,fy;
		static Image img;
		
    public lotto_GUI(String title){
    	super(title);
    	
    	panel = new JPanel();
        label = new JLabel("Number Setting");
        setButton = new JButton("Setting");
        setButton.addActionListener(new numberSetting());
        
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
		img = tk.getImage("lotto.png");
        this.setIconImage(img);
        
        super.setVisible(true);
       
    }
    
    public void init(){
        Container contain = super.getContentPane(); 
    }

    public void exitButton(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
   
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true); 
        lotto_GUI s = new lotto_GUI("Random Lotto picker");
    }
}