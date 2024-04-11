import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class SignUp {

    private JFrame frame;
    //Allows us to draw graphics to it


    private String title;
    private int width;
    private int height;
    private Golfer golfer;
    String fileName = "users.txt";

    SignUp(String title, int width, int height, Golfer golfer){

        this.title = title;
        this.width = width;
        this.height = height;
        this.golfer = golfer;

        //Calling the method to initialise the JFrame
        createDisplay();
        addToDisplay();
        buttonFunction();
    }

    //Creating a window (so that we can see the game)
    //Label is just writing ("on the canvas")
    private JLabel signUp = new JLabel("Sign up");
    //Buttons will complete a task/action
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton okay = new JButton("Okay");
    private JButton cancel = new JButton("Cancel");
    private String newUser;
    private String newPass;

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
    }

    private void buttonFunction(){
        okay.addActionListener(e -> {
            actionPerformed(e);
        });
    }

    public void actionPerformed(ActionEvent e) {
        newUser = username.getText();
        newPass = String.valueOf(password.getPassword());
        try {
            fileWriter();
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(frame, "Error. Try Again");
        }
        new Login("Handicap Helper", 210, 350);
        frame.dispose();
    }

    private void addToDisplay(){
        JPanel panel;
        panel = new JPanel();
        //set the size of the JPanel (= to size of JFrame)
        panel.setPreferredSize(new Dimension(width, height));
        //Making sure you can't change the size of the JPanel
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        //Setting the layout for the JPanel
        panel.setLayout(new GridLayout(12, 5));
        addToDisplay();
        //Adding the menu label to the canvas
        panel.add(signUp);
        panel.add(new JLabel("Username you would like:"));
        panel.add(username);
        panel.add(new JLabel("Password you would like:"));
        panel.add(password);
        panel.add(new JPanel());
        panel.add(okay);
        panel.add(cancel);
        cancel.addActionListener(e -> {
            new Menu("Handicap Helper", 210, 350);
            frame.dispose();
        });
        //adding the canvas to the JFrame and making sure its visible
        frame.add(panel);
        frame.pack();
    }
    private void fileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(newUser + ", " + newPass + ", " + golfer.getName() + ", " + golfer.getAge() + ", " + golfer.getHandicap());
        printWriter.close();
    }
}

