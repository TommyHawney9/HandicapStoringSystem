import javax.swing.*;
import java.awt.*;

 class StartSignUp {

    private JFrame frame;
    //Allows us to draw graphics to it


    private String title;
    private int width;
    private int height;
    private Golfer golfer;

    StartSignUp(String title, int width, int height, Golfer golfer) {

        this.title = title;
        this.width = width;
        this.height = height;
        this.golfer = golfer;

        //Calling the method to initialise the JFrame
        createDisplay();

    }

    private JButton okay = new JButton("Okay");
     private JButton cancel = new JButton("Cancel");
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
        //Adding the menu label to the canvas
        panel.add(new JLabel("To sign up you must first fill in a "));
        panel.add(new JLabel("scorecard to obtain a handicap"));
        panel.add(new JPanel());
        panel.add(new JPanel());
        panel.add(new JLabel("Click okay to continue"));

        panel.add(okay);
        okay.addActionListener(e -> {
            frame.dispose();
            new Scorecard1("Handicap Helper", 210, 350, golfer);
        });
        panel.add(cancel);

        cancel.addActionListener(e -> {
            frame.dispose();
            new Menu("Handicap Helper", 210, 350);
        });
        frame.add(panel);
        frame.pack();
    }
}