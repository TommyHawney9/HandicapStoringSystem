import javax.swing.*;
import java.awt.*;


public class Homepage {

    public JFrame frame;
    //Allows us to draw graphics to it
    public JPanel panel;


    private String title;
    private int width;
    private int height;
    private Golfer golfer;
    private String handicap;
    private int age;
    private String name;


    Homepage(String title, int width, int height, Golfer golfer){
        this.title = title;
        this.width = width;
        this.height = height;
        this.golfer = golfer;
        if (golfer.getHandicap() > 0.4) {
            this.handicap = Double.toString(golfer.getHandicap());
        }else if (golfer.getHandicap() < 0 && golfer.getHandicap() > -0.5){
            this.handicap = ("Scratch (" + ("+" + (-golfer.getHandicap())) + ")");
        }else if (golfer.getHandicap() < 0.5 && golfer.getHandicap() >= 0){
            this.handicap = ("Scratch (" + golfer.getHandicap()+")");
        }else{
            this.handicap = ("+" + (-golfer.getHandicap()));
        }
        this.age = golfer.getAge();
        this.name = golfer.getName();
        //Calling the method to initialise the JFrame
        createDisplay();
    }

    private JButton changeHandicap = new JButton("Change Handicap");
    private JButton changeAge = new JButton("Change Age");
    private JButton changeUsername = new JButton("Change Username");

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
        panel.add(new JLabel("Name: " + name));
        panel.add(new JLabel("Age: " + age));
        panel.add(new JLabel("Handicap: " + handicap));
        panel.add(new JPanel());
        panel.add(changeAge);
        changeAge.addActionListener(e -> {

                });
        panel.add(changeHandicap);
        changeHandicap.addActionListener(e -> {


        });
        panel.add(changeUsername);
        changeUsername.addActionListener(e -> {
            new ChangeUsername("Handicap Helper", 210, 350, golfer);
            frame.dispose();
        });
        frame.add(panel);
        frame.pack();
    }
}