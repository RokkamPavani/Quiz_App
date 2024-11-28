package quizapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
    JTextField tfname;
    JButton back, rules;

    Login() 
    {
        // Create a JPanel with a solid color background
        JPanel solidColorPanel = new JPanel();
        solidColorPanel.setBackground(Color.BLACK); // Set the background color to black
        solidColorPanel.setLayout(null); // Set null layout
        setContentPane(solidColorPanel); // Set solidColorPanel as the content pane

        // Add first image
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.png"));
        Image img2 = img1.getImage();
        Image resizedImg1 = img2.getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(resizedImg1);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(300, 120, 350, 350);
        solidColorPanel.add(image1);

        // Name label
        JLabel name = new JLabel("Enter Your Name:");
        name.setBounds(210, 150, 900, 700);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        name.setForeground(Color.CYAN);
        solidColorPanel.add(name);

        // TextField for name
        tfname = new JTextField();
        tfname.setBounds(210, 530, 510, 50);
        tfname.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        tfname.setForeground(Color.CYAN);
        tfname.setOpaque(true); // Make background opaque
        tfname.setBackground(Color.BLACK); // Set background color to black
        tfname.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1)); // Optional border
        solidColorPanel.add(tfname);

        // Rules button
        rules = new JButton("Rules");
        rules.setBounds(300, 600, 150, 50);
        rules.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        rules.setForeground(Color.CYAN);
        rules.setBackground(Color.BLACK);
        rules.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set pointer cursor
        rules.setOpaque(true);
        rules.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        rules.addActionListener(this);
        solidColorPanel.add(rules);

        // Back button
        back = new JButton("Back");
        back.setBounds(480, 600, 150, 50);
        back.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        back.setForeground(Color.CYAN);
        back.setBackground(Color.BLACK);
        back.setOpaque(true);
        back.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set pointer cursor
        solidColorPanel.add(back);

        // Frame settings
        setBounds(300, 0, 950, 1200); // Size of the content pane
        setResizable(false);
        setVisible(true); // Visibility of the content pane
    }

    public void actionPerformed(ActionEvent ae)
    {
        String name = tfname.getText();
        if (ae.getSource() == rules)
        {
            setVisible(false);
            new Rules(name);
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}