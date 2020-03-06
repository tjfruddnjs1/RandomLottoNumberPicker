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
		static JTextField textFieldNumber;
		static Frame frameSettingNumber;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == lg.setNumbersButton) {
				frameSettingNumber = new Frame("Setting");
				frameSettingNumber.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frameSettingNumber.setVisible(false);
						frameSettingNumber.dispose();
					}
				});
				
				Image img = lg.tk.getImage("lotto.png");
		        frameSettingNumber.setIconImage(img);
		        
		        textFieldNumber = new JTextField();
		        textFieldNumber.addKeyListener(this);
		        
		        JLabel label = new JLabel("How many Lotto Number?");
		        JButton button = new JButton("check");
		        button.addActionListener(new ActionListener() {
		        	
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frameSettingNumber.setVisible(false);
						frameSettingNumber.dispose();
					}
		        	
		        });
		        
		        
		        frameSettingNumber.add(textFieldNumber,BorderLayout.CENTER);
		        frameSettingNumber.add(label,BorderLayout.NORTH);
		        frameSettingNumber.add(button,BorderLayout.SOUTH);
		        frameSettingNumber.setSize(300,200);
				frameSettingNumber.setLocation(lg.x/2-lg.fx/2+250, lg.y/2-lg.fy/2+100);
		        frameSettingNumber.setVisible(true);
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
//				System.out.println(textFieldNumber.getText());
				frameSettingNumber.dispose();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
