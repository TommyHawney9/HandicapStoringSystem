import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class ChangeUsername {

    public JFrame frame;
    //Allows us to draw graphics to it
    public JPanel panel;


    private String title;
    private int width;
    private int height;
    private Golfer golfer;



    ChangeUsername(String title, int width, int height, Golfer golfer){
        this.title = title;
        this.width = width;
        this.height = height;
        this.golfer = golfer;

        //Calling the method to initialise the JFrame
        createDisplay();
    }

    private JLabel confirm = new JLabel("Confirm your previous login details");
    private JLabel user = new JLabel("Username:");
    private JLabel pass = new JLabel("Password:");
    private JLabel newUsername = new JLabel("Enter the username you would like");
    private JButton cancel = new JButton("Cancel");
    private JButton change = new JButton("Change");
    private JTextField newUsernameBox = new JTextField();
    private JTextField oldUsername = new JTextField();
    private JPasswordField oldPassword = new JPasswordField();


    public void createDisplay() {
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

        panel = new JPanel();
        //set the size of the JPanel (= to size of JFrame)
        panel.setPreferredSize(new Dimension(width, height));
        //Making sure you can't change the size of the JPanel
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        //Setting the layout for the JPanel
        panel.setLayout(new GridLayout(12, 5));
        panel.add(confirm);
        panel.add(user);
        panel.add(oldUsername);
        panel.add(pass);
        panel.add(oldPassword);
        panel.add(newUsername);

        panel.add(newUsernameBox);
        panel.add(new JPanel());
        panel.add(change);
        change.addActionListener(e -> {
            String user = oldUsername.getText();
            String pass = String.valueOf(oldPassword.getPassword());
            String newUser = newUsernameBox.getText();
           if(user.equals(golfer.getUsername()) && pass.equals(golfer.getPassword())) {
               golfer.setUsername(newUser);
               File fileName = new File("users.txt");
               String line;


               if (golfer.getUsername() == oldUsername.getText() && golfer.getPassword() == String.valueOf(oldPassword.getPassword())){

           }


               try (Scanner scanner = new Scanner(new FileReader(fileName))){
                   while(scanner.hasNextLine() ){
                       line = scanner.nextLine();
                       String[] lines;
                       lines = line.split(", ", 5);
                       String username1 = lines[0];
                       String password1 = lines[1];


                   }

               } catch(Exception e1) {
                   new ChangeUsername("Handicap Helper", 210, 350, golfer);
               }
           }

           new Homepage("Handicap Helper", 210, 350, golfer);
            frame.dispose();
        });
        panel.add(cancel);
        cancel.addActionListener(e -> {

            frame.dispose();
        });

        frame.add(panel);
        frame.pack();
    }
}
