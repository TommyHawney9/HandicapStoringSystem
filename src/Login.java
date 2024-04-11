import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


class Login{

    private JFrame frame;
    //Allows us to draw graphics to it

    private String title;
    private int width;
    private int height;

    Login(String title, int width, int height){

        this.title = title;
        this.width = width;
        this.height = height;

        //Calling the method to initialise the JFrame
        createDisplay();

    }

    //Label is just writing ("on the canvas")
    private JLabel login = new JLabel("Login");
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
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
        panel.add(login);
        panel.add(new JPanel());
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password"));
        panel.add(password);
        panel.add(new JPanel());
        panel.add(okay);
        okay.addActionListener(e -> {
                    String user = username.getText();
                    String pass = String.valueOf(password.getPassword());

                    File fileName = new File("users.txt");
                    String line;
                    boolean login = false;
                    String username1 = "";
                    String password1 = "";
                    String name1 = "";
                    int age1 = 0;
                    double handicap1 = 0.0;



                            try (Scanner scanner = new Scanner(new FileReader(fileName))){
                                while(scanner.hasNextLine() && !login){
                                    line = scanner.nextLine();
                                    String[] lines;
                                    lines = line.split(", ", 5);
                                    username1 = lines[0];
                                    password1 = lines[1];
                                    name1 = lines[2];
                                    age1 = Integer.parseInt(lines[3]);
                                    handicap1 = Double.parseDouble(lines[4]);
                                    if (user.equals(username1) && pass.equals(password1)) {
                                        login = true;
                                    }
                                }

                            } catch(Exception e1) {
                                login = false;
                            }




                    if(login) {
                        Golfer golfer1 = new Golfer(name1, age1, username1, password1, handicap1);
                        new Homepage("Handicap Helper", 210, 350, golfer1);
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(frame, "                  Error!\nThere was a problem signing in\n make sure your username and \n       password are correct.");
                    }


                });

        panel.add(cancel);
        cancel.addActionListener(e -> {
                new Menu("Handicap Helper", 210, 350);
                frame.dispose();
        });

        //adding the canvas to the JFrame and making sure its visible
        frame.add(panel);
        frame.pack();
    }
    public void importAccounts(){

    }
}
