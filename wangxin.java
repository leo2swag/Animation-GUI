import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class wangxin {
	public static JFrame frame = new JFrame("ÖÜÑ©Ó¨");
	public static JPanel panel = new JPanel();
	public static JSlider slider = new JSlider(JSlider.HORIZONTAL,1,21,1);
	public static JLabel inst = new JLabel("ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã ÖÜÑ©Ó¨ÎÒ°®Äã");
	public static JLabel image = new JLabel();
	public static Timer timer  = new Timer(22 * 30, new event());
	public static int frameslide = 1;

	public static void main(String[] args) {
		image.setIcon(new ImageIcon("1.jpg"));
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new change());
		panel.setLayout(new BorderLayout());
		panel.add(inst,BorderLayout.NORTH);
		panel.add(image,BorderLayout.CENTER);
		panel.add(slider,BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setSize(750, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		timer.start();
		
	}

	public static class event implements ActionListener{
		public void actionPerformed( ActionEvent e ) {
			if (frameslide == 11) {
				frameslide = 1;
			}else {
				image.setIcon(new ImageIcon(frameslide + ".jpg"));
				frameslide++;
			}
		}
	}
	

	private static class change implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			JSlider source = (JSlider) event.getSource();
			int speed = (int)source.getValue();
			timer.setDelay(10 * (22 - speed));
		}
	}
	
}
