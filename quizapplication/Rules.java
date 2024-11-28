package quizapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton back, start;

    Rules(String name)
    {
        this.name = name;

        // Create a JPanel with a solid color background
        JPanel solidColorPanel = new JPanel();
        solidColorPanel.setBackground(Color.BLACK); // Set the background color to black
        solidColorPanel.setLayout(null); // Set null layout
        setContentPane(solidColorPanel); // Set solidColorPanel as the content pane
        
        // Adding image and header
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/question.png"));
        Image im = img.getImage();
        Image resizedIm = im.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon im1 = new ImageIcon(resizedIm);
        JLabel image = new JLabel(im1);
        image.setBounds(600, 150, 80, 80);
        solidColorPanel.add(image);
        
        JLabel heading = new JLabel("Welcome " + name + " to JAVA Quiz");
        heading.setBounds(320, 80, 700, 60);
        heading.setForeground(Color.YELLOW);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        solidColorPanel.add(heading);
        
        JLabel heading1 = new JLabel("Things to keep in mind!!!");
        heading1.setBounds(420, 220, 700, 60);
        heading1.setForeground(Color.YELLOW);
        heading1.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        solidColorPanel.add(heading1);
        
        JLabel rules = new JLabel();
        rules.setBounds(50, 200, 800, 440);
        rules.setForeground(Color.YELLOW);
        rules.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        rules.setText(
            "<html>" +
                "1. There will be a total of 10 questions." + "<br>" +
                "2. For each question, you will have 20 seconds to answer." + "<br>" +
                "3. Each question carries 2 marks." + "<br>" +
                "4. For every correct answer 2 marks will be awarded." + "<br>" +
                "5. There is no negative markings. " + "<br>" +
                "6. Wish you all the best for your exam. Good luck!" + "<br>" +
            "</html>"
        );
        solidColorPanel.add(rules);
        
        // Back button
        back = new JButton("Back");
        back.setBounds(650, 570, 150, 50);
        back.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        back.setForeground(Color.YELLOW);
        back.setBackground(Color.BLACK);
        back.setOpaque(true); // Set opaque to true for the button to show its background color
        back.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        solidColorPanel.add(back);
        
        // Start button
        start = new JButton("Start");
        start.setBounds(450, 570, 150, 50);
        start.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        start.setForeground(Color.YELLOW);
        start.setBackground(Color.BLACK);
        start.setOpaque(true); // Set opaque to true for the button to show its background color
        start.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        start.addActionListener(this);
        start.setCursor(new Cursor(Cursor.HAND_CURSOR));
        solidColorPanel.add(start);
        
        setBounds(100, 0, 1300, 1200);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
        else if (ae.getSource() == start)
        {
            setVisible(false);
            new Quiz(name);
        }
    }

    public static void main(String[] args) 
    {
        new Rules("User ");
    }
}