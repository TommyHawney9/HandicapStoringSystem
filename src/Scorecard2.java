import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;


class Scorecard2 extends JFrame {

    private int totalPar;
    private int totalScore;
    private int totalAdScore;
    //Creating a window (so that we can see the game)
    private JFrame frame;
    //Allows us to draw graphics to it
    private JPanel panel;
    //Label is just writing ("on the canvas")
    private JLabel hole = new JLabel("Hole");
    private JLabel par = new JLabel("Par");
    private JLabel score = new JLabel("Score");
    private JLabel hole1 = new JLabel("10");
    private JLabel hole2 = new JLabel("11");
    private JLabel hole3 = new JLabel("12");
    private JLabel hole4 = new JLabel("13");
    private JLabel hole5 = new JLabel("14");
    private JLabel hole6 = new JLabel("15");
    private JLabel hole7 = new JLabel("16");
    private JLabel hole8 = new JLabel("17");
    private JLabel hole9 = new JLabel("18");
    private JTextField[] scores = new JTextField[9];
    private JTextField[] pars = new JTextField[9];
    private int[] intScores = new int[9];
    private int[] intPars = new int[9];
    //Buttons will complete a task/action
    private JButton cont = new JButton("Continue");
    private JButton cancel = new JButton("Cancel");

    private String title;
    private int width;
    private int height;
    private Golfer golfer;

    Scorecard2(String title, int width, int height, Golfer golfer) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.golfer = golfer;

        //Calling the method to initialise the JFrame
        createDisplay();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scores[0].setHorizontalAlignment(SwingConstants.CENTER);
        scores[0].setPreferredSize(new Dimension(25, 25));
        scores[1].setHorizontalAlignment(SwingConstants.CENTER);
        scores[1].setPreferredSize(new Dimension(25, 25));
        scores[2].setHorizontalAlignment(SwingConstants.CENTER);
        scores[2].setPreferredSize(new Dimension(25, 25));
        scores[3].setHorizontalAlignment(SwingConstants.CENTER);
        scores[3].setPreferredSize(new Dimension(25, 25));
        scores[4].setHorizontalAlignment(SwingConstants.CENTER);
        scores[4].setPreferredSize(new Dimension(25, 25));
        scores[5].setHorizontalAlignment(SwingConstants.CENTER);
        scores[5].setPreferredSize(new Dimension(25, 25));
        scores[6].setHorizontalAlignment(SwingConstants.CENTER);
        scores[6].setPreferredSize(new Dimension(25, 25));
        scores[7].setHorizontalAlignment(SwingConstants.CENTER);
        scores[7].setPreferredSize(new Dimension(25, 25));
        scores[8].setHorizontalAlignment(SwingConstants.CENTER);
        scores[8].setPreferredSize(new Dimension(25, 25));
        pars[0].setHorizontalAlignment(SwingConstants.CENTER);
        pars[0].setPreferredSize(new Dimension(25, 25));
        pars[1].setHorizontalAlignment(SwingConstants.CENTER);
        pars[1].setPreferredSize(new Dimension(25, 25));
        pars[2].setHorizontalAlignment(SwingConstants.CENTER);
        pars[2].setPreferredSize(new Dimension(25, 25));
        pars[3].setHorizontalAlignment(SwingConstants.CENTER);
        pars[3].setPreferredSize(new Dimension(25, 25));
        pars[4].setHorizontalAlignment(SwingConstants.CENTER);
        pars[4].setPreferredSize(new Dimension(25, 25));
        pars[5].setHorizontalAlignment(SwingConstants.CENTER);
        pars[5].setPreferredSize(new Dimension(25, 25));
        pars[6].setHorizontalAlignment(SwingConstants.CENTER);
        pars[6].setPreferredSize(new Dimension(25, 25));
        pars[7].setHorizontalAlignment(SwingConstants.CENTER);
        pars[7].setPreferredSize(new Dimension(25, 25));
        pars[8].setHorizontalAlignment(SwingConstants.CENTER);
        pars[8].setPreferredSize(new Dimension(25, 25));

    }

    //Initialising the JFrame and the canvas in a new method
    private void createDisplay() {
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));

        for (int y = 0; y < 9; y++) {
            scores[y] = new JTextField();
            pars[y] = new JTextField();
        }
        //Adding the menu label to the canvas
        panel.add(new JLabel("Back 9"));
        panel.add(new JLabel("                                          "));
        panel.add(hole);
        panel.add(new JLabel("     "));
        panel.add(par);
        panel.add(new JLabel("     "));
        panel.add(score);
        panel.add(new JLabel("                   "));
        panel.add(hole1);
        panel.add(new JLabel("           "));
        panel.add(pars[0]);
        panel.add(new JLabel("     "));
        panel.add(scores[0]);
        panel.add(new JLabel("                    "));
        panel.add(hole2);
        panel.add(new JLabel("           "));
        panel.add(pars[1]);
        panel.add(new JLabel("     "));
        panel.add(scores[1]);
        panel.add(new JLabel("                    "));
        panel.add(hole3);
        panel.add(new JLabel("           "));
        panel.add(pars[2]);
        panel.add(new JLabel("     "));
        panel.add(scores[2]);
        panel.add(new JLabel("                    "));
        panel.add(hole4);
        panel.add(new JLabel("           "));
        panel.add(pars[3]);
        panel.add(new JLabel("     "));
        panel.add(scores[3]);
        panel.add(new JLabel("                    "));
        panel.add(hole5);
        panel.add(new JLabel("           "));
        panel.add(pars[4]);
        panel.add(new JLabel("     "));
        panel.add(scores[4]);
        panel.add(new JLabel("                    "));
        panel.add(hole6);
        panel.add(new JLabel("           "));
        panel.add(pars[5]);
        panel.add(new JLabel("     "));
        panel.add(scores[5]);
        panel.add(new JLabel("                    "));
        panel.add(hole7);
        panel.add(new JLabel("           "));
        panel.add(pars[6]);
        panel.add(new JLabel("     "));
        panel.add(scores[6]);
        panel.add(new JLabel("                    "));
        panel.add(hole8);
        panel.add(new JLabel("           "));
        panel.add(pars[7]);
        panel.add(new JLabel("     "));
        panel.add(scores[7]);
        panel.add(new JLabel("                    "));
        panel.add(hole9);
        panel.add(new JLabel("           "));
        panel.add(pars[8]);
        panel.add(new JLabel("     "));
        panel.add(scores[8]);
        panel.add(new JLabel("                    "));
        panel.add(cont);
        cont.addActionListener(e -> {
            addScores();
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
        public void addScores() {
            boolean error = false;
            for (int i = 0; i < 9; i++) {
                try {
                    intScores[i] = Integer.parseInt(scores[i].getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "Error. Make sure all boxes are filled out with numbers");
                    error = true;
                    break;
                }
                try {
                    intPars[i] = Integer.parseInt(pars[i].getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "Error. Make sure all boxes are filled out with numbers");
                    error = true;
                    break;
                }

            }
            if (!error) {

                totalScore = IntStream.of(intScores).sum();
                for (int x = 0; x < 9; x++) {
                    if ((intScores[x] - intPars[x]) > 1) {
                        intScores[x] = intPars[x] + 2;
                        scores[x].setText(Integer.toString(intScores[x]));
                    }
                }

                for (int x = 0; x < 9; x++)
                    if (pars[0].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[1].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[2].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[3].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[4].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[5].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[6].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[7].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (pars[8].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[0].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[1].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[2].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[3].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[4].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[5].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[6].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[7].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else if (scores[8].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "You have left a box empty");
                    } else
                        totalAdScore = IntStream.of(intScores).sum();
                totalPar = IntStream.of(intPars).sum();
                new Confirm2("Handicap Helper", 210, 350, totalAdScore, totalPar, totalScore, golfer);
                frame.dispose();

            }
        }
    }

