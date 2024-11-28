package quizapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Quiz extends JFrame implements ActionListener {
    String name;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, submit;
    ButtonGroup group;
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userans[][] = new String[10][1];
    public static int count = 0;
    public static int ansgiven = 0;
    public static int score = 0;
    public static int timer = 20;

    Quiz(String name) {
        this.name = name;

        // Custom JPanel with solid color background
        JPanel solidPanel = new JPanel();
        solidPanel.setLayout(null); // Set null layout
        solidPanel.setBackground(Color.BLACK); // Set solid color as the background
        setContentPane(solidPanel); // Set solidPanel as the content pane

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/choose.png"));
        Image img2 = img1.getImage();
        Image resizedImg = img2.getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        ImageIcon i1 = new ImageIcon(resizedImg);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(250, 50, 260, 260);
        solidPanel.add(image1);

        qno = new JLabel();
        qno.setBounds(40, 320, 700, 50);
        qno.setForeground(Color.CYAN);
        qno.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        solidPanel.add(qno);

        question = new JLabel();
        question.setBounds(75, 320, 1000, 50);
        question.setForeground(Color.CYAN);
        question.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        solidPanel.add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(55, 370, 700, 30);
        opt1.setForeground(Color.CYAN);
        opt1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt1.setOpaque(false); // Makes the background transparent
        solidPanel.add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(55, 400, 700, 30);
        opt2.setForeground(Color.CYAN);
        opt2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt2.setOpaque(false); // Makes the background transparent
        solidPanel.add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(55, 430, 700, 30);
        opt3.setForeground(Color.CYAN);
        opt3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt3.setOpaque(false); // Makes the background transparent
        solidPanel.add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(55, 460, 700, 30);
        opt4.setForeground(Color.CYAN);
        opt4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt4.setOpaque(false); // Makes the background transparent
        solidPanel.add(opt4);

        // Group radio buttons
        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        // Next button
        next = new JButton("Next");
        next.setBounds(300, 570, 150, 50);
        next.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        next.setForeground(Color.CYAN);
        next.setBackground(Color.BLACK);
        next.setOpaque(false);
        next.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        next.addActionListener(this);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        solidPanel.add(next);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(600, 570, 150, 50);
        submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        submit.setForeground(Color.CYAN);
        submit.setBackground(Color.BLACK);
        submit.setOpaque(false);
        submit.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        submit.addActionListener(this);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setEnabled(false);
        solidPanel.add(submit);

        // Loading the questions and answers
        addQuestionsAnswers();
        start(count);

        setBounds(200, 0, 1100, 1200);
        setResizable(false);
        setVisible(true);
    }

    void addQuestionsAnswers() {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            // Checking whether user selected any option or not
            if (group.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            // Checking if user's answer is correct
            if (userans[count][0].equals(answers[count][1])) {
                score += 2;
            }

            // Reset timer
            timer = 20;

            // Enabling the submit button and disabling the next button
            if (count == 8) { // When the user is at 9th question
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            // Checking whether user selected any option or not
            if (group.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            // Checking if user's answer is correct
            if (userans[count][0].equals(answers[count][1])) {
                score += 2;
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        group.clearSelection();
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left- " + timer + " seconds";
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        if (timer <= 10) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.GREEN);
        }
        if (timer > 0) {
            g.drawString(time, 550, 200);
        } else {
            if (count == 9) {
                g.drawString("Time up!!!", 1110, 500);
            }
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ansgiven == 1) {
            ansgiven = 0;
            timer = 20;
        } else if (timer < 0) {
            timer = 20;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (group.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }
                if (userans[count][0].equals(answers[count][1])) {
                    score += 2;
                }
                setVisible(false);
                new Score(name, score);
            } else {
                if (group.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }
                if (userans[count][0].equals(answers[count][1])) {
                    score += 2;
                }
                count++;
                start(count);
            }
        }
    }

    public static void main(String[] args) {
        new Quiz("user");
    }
}