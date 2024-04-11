import javax.swing.*;
import java.awt.*;

public class Menu{

    private JFrame frame;

    private String title;
    private int width;
    private int height;
    Golfer golfer;

public Menu(String title, int width, int height){
    this.title = title;
    this.width = width;
    this.height = height;
    this.golfer = golfer;

    //Calling the method to initialise the JFrame
    createDisplay();

    }


    //Label is just writing ("on the canvas")
    private JLabel menu = new JLabel("Menu");
    //Buttons will complete a task/action
    private JButton login = new JButton("Login");
    private JButton signUp = new JButton("Sign Up");

        //Initialising the JFrame and the canvas in a new method

        private void createDisplay(){

            frame = new JFrame(title);
            frame.setSize(width, height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            panel.add(menu);
            panel.add(login);

            //action listener for when a button is pressed
            login.addActionListener(e -> {
                    new Login("Handicap Helper", 210, 350);
                    frame.dispose();
            });

            /*
            panel.add(new JPanel());
            panel.add(guest);
            guest.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Scorecard1 scorecard1 = new Scorecard1("Handicap Helper", 210, 350);
                    frame.dispose();
                }
            });
            */
            panel.add(new JPanel());
            panel.add(new JPanel());
            panel.add(signUp);
            signUp.addActionListener(e -> {
                    new Name("Handicap Helper", 210, 350);
                    frame.dispose();
            });
            //adding the canvas to the JFrame and making sure its visible
            frame.add(panel);
            frame.pack();
        }
    }


