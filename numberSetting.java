import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

class numberSetting implements ActionListener, KeyListener{
		lotto_GUI lg;
		static JTextField tf;
		static Frame fs;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == lg.setButton) {
				fs = new Frame("Setting");
				fs.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						fs.setVisible(false);
						fs.dispose();
					}
				});
				
				Image img = lg.tk.getImage("lotto.png");
		        fs.setIconImage(img);
		        
		        tf = new JTextField();
		        tf.addKeyListener(this);
		        
		        JLabel label = new JLabel("How many Lotto Number?");
		        JButton button = new JButton("check");
		        button.addActionListener(new ActionListener() {
		        	
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						label.setText(tf.getText());
					}
		        	
		        });
		        
		        
		        fs.add(tf,BorderLayout.CENTER);
		        fs.add(label,BorderLayout.NORTH);
		        fs.add(button,BorderLayout.SOUTH);
		        fs.setSize(300,200);
				fs.setLocation(lg.x/2-lg.fx/2+250, lg.y/2-lg.fy/2+100);
		        fs.setVisible(true);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()== KeyEvent.VK_ENTER) {
//				System.out.println(tf.getText());
				fs.dispose();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
