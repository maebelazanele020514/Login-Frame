/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ac.za.tut.loginframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/**
 *
 * @author hifi
 */
public class LoginFrame extends JFrame{
//panels
    private JPanel headingPanel;
    private JPanel loginDetailsPanel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
//labels
    private JLabel headingLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    
//TextFields 
    private JTextField usernameTextField;
    
//buttons
    private JButton submitButton;
    private JButton clearButton;
    private JButton exitButton;
    
//password field
    private JPasswordField passwordField;
    
    public LoginFrame() {
        //basic frame settings 
        setTitle("Login Page");
        setSize(500,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        //create panels
        headingPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        loginDetailsPanel=new JPanel(new GridLayout(2,1,1,1));
        loginDetailsPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2), "Login Details"));
        
        usernamePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        buttonPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        mainPanel=new JPanel(new BorderLayout());
        
        //create Labels
        headingLabel=new JLabel("Login");
        headingLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD +Font.ITALIC, 20));
        headingLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        headingLabel.setForeground(Color.RED);
        
        usernameLabel=new JLabel("Username: ");
        passwordLabel=new JLabel("Password: ");
        
        //create text fields 
        usernameTextField=new JTextField(10);
        passwordField=new JPasswordField(10);
        
        //create buttons
        submitButton=new JButton("Submit");
       
        
        clearButton=new JButton("Clear");
        clearButton.addActionListener(new ClearBtnListener());
        
        exitButton=new JButton("Exit");
        exitButton.addActionListener(new ExitBtnListener());
        
        //add components to panels
        
        headingPanel.add(headingLabel);
        
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);
        
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        
        loginDetailsPanel.add(usernamePanel);
        loginDetailsPanel.add(passwordPanel);
        
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
 
        mainPanel.add(loginDetailsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
       mainPanel.add(headingPanel, BorderLayout.NORTH);
       add(mainPanel);
        
        pack();
        setVisible(true);
        
    }
    
    
    private class ClearBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            usernameTextField.setText("");
            passwordField.setText("");
        }
        
    }
    
    private class ExitBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
}
