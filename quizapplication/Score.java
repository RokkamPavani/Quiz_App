package quizapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener
{
    Score(String name, int score)
    {
        // Create a JPanel with a solid color background
        JPanel solidColorPanel = new JPanel();
        solidColorPanel.setBackground(Color.YELLOW); // Set the background color to black
        solidColorPanel.setLayout(null); // Set null layout
        setContentPane(solidColorPanel); // Set solidColorPanel as the content pane
        
        // Adding image and header
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bulb.png"));
        Image im = img.getImage();
        Image resizedIm = im.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon im1 = new ImageIcon(resizedIm);
        JLabel image = new JLabel(im1);
        image.setBounds(135, 0, 150, 150);
        solidColorPanel.add(image);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing.");
        heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        heading.setForeground(Color.BLACK);
        heading.setBounds(50,130, 600, 50);
        solidColorPanel.add(heading);
        
        JLabel scores = new JLabel("Your Score is " + score + " .");
        scores.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        scores.setForeground(Color.BLACK);
        scores.setBounds(120, 180, 600, 50);
        solidColorPanel.add(scores);
        
        JButton play = new JButton("Play Again");
        play.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        play.setForeground(Color.BLACK);
        play.setBounds(135, 250, 150, 50);
        play.setBackground(Color.YELLOW);
        play.setOpaque(true); // Set opaque to true for the button to show its background color
        play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        play.addActionListener(this);
        play.setCursor(new Cursor(Cursor.HAND_CURSOR));
        solidColorPanel.add(play);
        
        setBounds(400, 140, 450, 350);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) 
    {
        new Score("User ", 0);
    }
}