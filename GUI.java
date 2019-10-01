import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.util.Scanner;


// GUI initialization handling that occurs at startup
public class GUI extends JFrame implements ActionListener{

    private String[] results = new String[11];
    
    public static void main(String[] args){
	Scanner keyboardchar = new Scanner(System.in);
	System.out.println("Would you like to enable the GUI for this game? y/n");
	String nextIn = keyboardchar.nextLine();
	if (nextIn.equals("y")) {
	    GUI gui = new GUI();
	    //Project play = new Project();
	    //play.Game();
	}
	else {
	    Project play = new Project();
	    play.Game(true);
	}
    }

    public GUI () {
	display();
    }

    
    // handles rendering the interface and taking user input
    public void display() {
	Project play = new Project();
	JFrame game = new JFrame("Slots");
	game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container slots = getContentPane();
	Dimension buttonSize = new Dimension(100,50);
	Dimension lockSize = new Dimension(10,5);
	
	// initializes the three buttons to determine spin cost
	JButton spin10 = new JButton("Spin 10");
	JButton spin20 = new JButton("Spin 20");
	JButton spin30 = new JButton("Spin 30");

	// labels to display remaining currency and win status
	JLabel money = new JLabel("Money:");
	JLabel text = new JLabel("100");
	JLabel win = new JLabel("");
	
	// handles the placement of the gui elements on-screen
	JPanel leftPanel = new JPanel(new GridLayout(3,1));
	JPanel centerPanel = new JPanel(new GridLayout(3,1));
	JPanel rightPanel = new JPanel(new GridLayout(3,1));
	JPanel bottomPanel = new JPanel(new GridLayout(2,3));
	
	// creates the blank wheels at gamestart
	JButton wheel1prev = new JButton("");
	JButton wheel1 = new JButton("");
	JButton wheel1next = new JButton("");
	JButton wheel2prev = new JButton("");
	JButton wheel2 = new JButton("");
	JButton wheel2next = new JButton("");
	JButton wheel3prev = new JButton("");
	JButton wheel3 = new JButton("");
	JButton wheel3next = new JButton("");

	wheel1prev.setPreferredSize(buttonSize);
	wheel2prev.setPreferredSize(buttonSize);
	wheel3prev.setPreferredSize(buttonSize);

	// creates user status display at the bottom of the ui
	bottomPanel.add(money);
	bottomPanel.add(text);
	bottomPanel.add(win);
	bottomPanel.add(spin10);
	bottomPanel.add(spin20);
	bottomPanel.add(spin30);
	
	// handles wheel placement on-screen
	leftPanel.add(wheel1prev);
	leftPanel.add(wheel1);
	leftPanel.add(wheel1next);
	centerPanel.add(wheel2prev);
	centerPanel.add(wheel2);
	centerPanel.add(wheel2next);
	rightPanel.add(wheel3prev);
	rightPanel.add(wheel3);
	rightPanel.add(wheel3next);
        
	game.add(leftPanel, BorderLayout.WEST);
	game.add(centerPanel, BorderLayout.CENTER);
	game.add(rightPanel, BorderLayout.EAST);
	game.add(bottomPanel, BorderLayout.SOUTH);

	// adds functionality to spin buttons
	spin10.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    play.guiInput(10);
		    for (int i = 0; i < play.getResults().length; i++) {
			results[i] = play.getResults()[i];
		    }
		    text.setText(results[0]);
		    wheel1prev.setIcon(new ImageIcon(results[1]+".png"));
		    wheel1.setIcon(new ImageIcon(results[2]+".png"));
		    wheel1next.setIcon(new ImageIcon(results[3]+".png"));
		    wheel2prev.setIcon(new ImageIcon(results[4]+".png"));
		    wheel2.setIcon(new ImageIcon(results[5]+".png"));
		    wheel2next.setIcon(new ImageIcon(results[6]+".png"));
		    wheel3prev.setIcon(new ImageIcon(results[7]+".png"));
		    wheel3.setIcon(new ImageIcon(results[8]+".png"));
		    wheel3next.setIcon(new ImageIcon(results[9]+".png"));
		    win.setText(results[10]);
		    play.setFirst(false);
		    wheel2prev.setEnabled(true);
		    wheel2.setEnabled(true);
		    wheel2next.setEnabled(true);
		    play.setLock(false);
		}
	    });
	spin20.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    play.guiInput(20);
		    for (int i = 0; i < play.getResults().length; i++) {
			results[i] = play.getResults()[i];
		    }
		    text.setText(results[0]);
		    wheel1prev.setIcon(new ImageIcon(results[1]+".png"));
		    wheel1.setIcon(new ImageIcon(results[2]+".png"));
		    wheel1next.setIcon(new ImageIcon(results[3]+".png"));
		    wheel2prev.setIcon(new ImageIcon(results[4]+".png"));
		    wheel2.setIcon(new ImageIcon(results[5]+".png"));
		    wheel2next.setIcon(new ImageIcon(results[6]+".png"));
		    wheel3prev.setIcon(new ImageIcon(results[7]+".png"));
		    wheel3.setIcon(new ImageIcon(results[8]+".png"));
		    wheel3next.setIcon(new ImageIcon(results[9]+".png"));
		    win.setText(results[10]);
		    play.setFirst(false);
		    play.setLock(false);
		    wheel2prev.setEnabled(true);
		    wheel2.setEnabled(true);
		    wheel2next.setEnabled(true);
		    play.setLock(false);
		}
	    });
	spin30.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    play.guiInput(30);
		    for (int i = 0; i < play.getResults().length; i++) {
			results[i] = play.getResults()[i];
		    }
		    text.setText(results[0]);
		    wheel1prev.setIcon(new ImageIcon(results[1]+".png"));
		    wheel1.setIcon(new ImageIcon(results[2]+".png"));
		    wheel1next.setIcon(new ImageIcon(results[3]+".png"));
		    wheel2prev.setIcon(new ImageIcon(results[4]+".png"));
		    wheel2.setIcon(new ImageIcon(results[5]+".png"));
		    wheel2next.setIcon(new ImageIcon(results[6]+".png"));
		    wheel3prev.setIcon(new ImageIcon(results[7]+".png"));
		    wheel3.setIcon(new ImageIcon(results[8]+".png"));
		    wheel3next.setIcon(new ImageIcon(results[9]+".png"));
		    win.setText(results[10]);
		    play.setFirst(false);
		    wheel2prev.setEnabled(true);
		    wheel2.setEnabled(true);
		    wheel2next.setEnabled(true);
		    play.setLock(false);
		}
	});

	// allows gui class to lock the second wheel
	wheel2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    boolean lock = play.guiLock(play.getFirst());
			if (lock == true){
				wheel2prev.setEnabled(false);
				wheel2.setEnabled(false);
				wheel2next.setEnabled(false);
				play.setLock(true);
			}
			else{
				wheel2prev.setEnabled(true);
				wheel2.setEnabled(true);
				wheel2next.setEnabled(true);
				play.setLock(false);
			}
		}
	});

	// renders the game window
	game.pack();
	game.setSize(300, 480);
	game.setVisible(true);
	game.setLayout(null);
    }

    // prints status updates to console when wheels are spun
    public void actionPerformed(ActionEvent e) {
	Container slots = getContentPane();
	if (e.getActionCommand().equals("Spin 10")) {
	    System.out.println("spin 10");
	}
	else if (e.getActionCommand().equals("Spin 20")) {
	    System.out.println("spin 20");
	}
	else if (e.getActionCommand().equals("Spin 30")) {
	    System.out.println("spin 30");
	}
	else {
	    System.out.println("Error");
	}
    }
}
