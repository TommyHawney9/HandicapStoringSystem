import javax.swing.*;
import java.awt.*;


class Name{

    private JFrame frame;
    //Allows us to draw graphics to it

    private String title;
    private int width;
    private int height;

    Name(String title, int width, int height){

        this.title = title;
        this.width = width;
        this.height = height;

        //Calling the method to initialise the JFrame
        createDisplay();

    }

    //Label is just writing ("on the canvas")
    private JLabel login = new JLabel("Personal Details");
    private JTextField name = new JTextField();
    private JTextField age = new JTextField();
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
        panel.add(new JLabel("What is your name:"));
        panel.add(name);
        panel.add(new JLabel("How old are you"));
        panel.add(age);
        panel.add(new JPanel());
        panel.add(okay);
        okay.addActionListener(e -> {

            try {
                boolean error = false;
                char[] chars = name.getText().toCharArray();
                for(int x = 0 ; x < chars.length; x ++){
                    if((int)chars[x] != 32 && (int)chars[x] < 64 || (int)chars[x] > 123){
                        error = true;
                    }
                }
                if(!error) {
                    String name1 = name.getText();
                    int age1 = Integer.parseInt(age.getText());
                    Golfer golfer = new Golfer(name1, age1);
                    new StartSignUp("Handicap Helper", 210, 350, golfer);
                    frame.dispose();
                }else if(error){
                    JOptionPane.showMessageDialog(frame, "Error. Name must include letters only");
                }

            }catch(Exception e1){
                JOptionPane.showMessageDialog(frame, "Error. You must enter an number for your age");
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
}