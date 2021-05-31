import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener{

	JButton button1 = new JButton("Insert");
	JButton button2 = new JButton("View");
	JButton button3 = new JButton("Update");
	JButton button4 = new JButton("Delete");
	JButton exitButton = new JButton("Exit");
	
	public MainMenu() {
		initFrame();
	}
	
	public void initFrame() {
		setTitle("BobaCool");
		setSize(600, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		
		BANNER();
		MENU();
		Bawah();
	}
	
	public void BANNER() {
		JLabel text1 = new JLabel("BobaCool");
		text1.setHorizontalAlignment(JLabel.CENTER);
		text1.setFont(new Font(null, Font.BOLD, 20));
		
		add(text1, BorderLayout.NORTH);
	}
	
	public void MENU() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		button1.setBackground(Color.black);
		button1.setForeground(Color.white);
		button1.addActionListener(this);
		button2.setBackground(Color.white);
		button2.setForeground(Color.black);
		button2.addActionListener(this);
		button3.setBackground(Color.white);
		button3.setForeground(Color.black);
		button3.addActionListener(this);
		button4.setBackground(Color.black);
		button4.setForeground(Color.white);
		button4.addActionListener(this);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		add(panel);
	}
	public void Bawah() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
	
		exitButton.setBackground(Color.red);
		exitButton.setForeground(Color.white);
		exitButton.addActionListener(this);
		
		panel.add(exitButton);
		add(panel, BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exitButton)) {
			System.exit(0);
		}else if(e.getSource().equals(button1)) {
			new InsertForm();
			setVisible(false);
		}else if(e.getSource().equals(button2)) {
			new ViewForm();
			setVisible(false);
		}else if(e.getSource().equals(button3)) {
			new UpdateForm();
			setVisible(false);
		}else if(e.getSource().equals(button4)) {
			new DeleteForm();
			setVisible(false);
		}
	}

}
