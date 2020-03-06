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

class drawSetting implements ActionListener,KeyListener {

		lotto_GUI lg;
		static JTextField textFieldDraws;
		static Frame frameSettingDraws;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == lg.setDrawsButton) {
				frameSettingDraws = new Frame("Setting");
				frameSettingDraws.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frameSettingDraws.setVisible(false);
						frameSettingDraws.dispose();
					}
				});
				
				Image img = lg.tk.getImage("lotto.png");
		        frameSettingDraws.setIconImage(img);
		        
		        textFieldDraws = new JTextField();
		        textFieldDraws.addKeyListener(this);
		        
		        JLabel label = new JLabel("How many draws do you want?");
		        JButton button = new JButton("check");
		        button.addActionListener(new ActionListener() {
		        	
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frameSettingDraws.setVisible(false);
						frameSettingDraws.dispose();
					}
		        	
		        });
		        
		        
		        frameSettingDraws.add(textFieldDraws,BorderLayout.CENTER);
		        frameSettingDraws.add(label,BorderLayout.NORTH);
		        frameSettingDraws.add(button,BorderLayout.SOUTH);
		        frameSettingDraws.setSize(300,200);
				frameSettingDraws.setLocation(lg.x/2-lg.fx/2+250, lg.y/2-lg.fy/2+100);
		        frameSettingDraws.setVisible(true);
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
				frameSettingDraws.dispose();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}

    	

