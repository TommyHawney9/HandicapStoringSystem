import javax.swing.*;
import java.awt.*;

class Confirm {

    //Creating a window (so that we can see the game)
    private JFrame frame;

    private JButton confirm = new JButton("Confirm");
private JButton back = new JButton("Back");

    private String title;
    private int width;
    private int height;
    private int totalScore;
    private int totalPar;
    private int totalAdScore;
    Golfer golfer;

    Confirm(String title, int width, int height, int totalAdScore, int totalPar, int totalScore, Golfer golfer) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.totalPar = totalPar;
        this.totalScore = totalScore;
        this.totalAdScore = totalAdScore;
        this.golfer = golfer;
        //Calling the method to initialise the JFrame
        createDisplay();
    }

    //Initialising the JFrame and the canvas in a new method
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        //very important line of code to make sure the window closes down properly
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //OPTIONAL EXTRAS
        //Making sure you cant resize the frame
        frame.setResizable(false);
        //Setting the location of where the window appears on the screen
        frame.setLocationRelativeTo(null);
        //Making sure the window is actually visible
        frame.setVisible(true);

        JPanel panel;
        panel = new JPanel();
        //set the size of the JPanel (= to size of JFrame)
        panel.setPreferredSize(new Dimension(width, height));
        //Making sure you can't change the size of the JPanel
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        //Setting the layout for the JPanel
        panel.setLayout(new GridLayout(12, 5));
        panel.add(new JLabel("Par: " + totalPar));
        panel.add(new JLabel("Score: " + totalScore));
        panel.add(new JLabel("Adjusted Score: " + totalAdScore));
        //Adding the menu label to the canvas
        panel.add(confirm);
        confirm.addActionListener(e ->  {
            new Scorecard2("Handicap Helper", 210, 350, golfer);
            frame.dispose();
            golfer.setAdScores1(totalAdScore);
            golfer.setPar1(totalPar);
        });
panel.add(back);
        back.addActionListener(e ->  {
            new Scorecard1("Handicap Helper", 210, 350, golfer);
            frame.dispose();
        });
        frame.add(panel);
        frame.pack();
    }
}
