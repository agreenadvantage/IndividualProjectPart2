package edu.jsu.mcis;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToeButtons extends JFrame
{
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton start;
    private JButton reset;

    public TicTacToeButtons()
    {
        super("TheTitle");
        setLayout(new GridLayout());
        button1 = new JButton();
        add(button1);
        
        
    }
    
    
    
}
 



/* import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class TicTacToeButtons extends JFrame
{	
   /*private String letter = "";
	public JFrame frame = new JFrame("TicTacToe");
	public JButton[][] buttons = new JButton[3][3];
	public JButton start = new JButton("Start");
	public JButton reset = new JButton("Reset");
    
    
        
    
    public void initialize()
	{
   
        frame.setSize(350,450);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new BorderLayout());
		JPanel game = new JPanel(new GridLayout(3,3));//4x4 because it is the dividers and not the cells
		
		frame.add(mainPanel);
		
		mainPanel.setPreferredSize(new Dimension(325,425));
		
        menu.setPreferredSize(new Dimension(300,50));
		game.setPreferredSize(new Dimension(250,250));
	
		mainPanel.add(menu, BorderLayout.NORTH);
		mainPanel.add(game, BorderLayout.SOUTH);
		menu.add(start, BorderLayout.WEST);
		menu.add(reset, BorderLayout.EAST);
        frame.pack();
        myHandler handler = new myHandler();
        
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
                buttons[i][j] = new JButton();
                buttons[i][j].setName("Location " + i + ", " + j);
				buttons[i][j].setText("_");
				buttons[i][j].setVisible(true);
                buttons[i][j].addActionListener(handler);
				game.add(buttons[i][j]);
			}
		}    
    }
    private class myHandler implements ActionListener
    {
        public void actionPreformed(ActionEvent event)
        {
            if (xturn == true)
            {
                letter = "X";
            }
            else if (xturn ==false)
            {
                letter = "O";
            }
            
            if (event.getSource() == buttons[0][0])
            {
                buttons[0][0].setText(letter);
                buttons[0][0].setEnabled(false);
            }
           
            
            
        }
    }
} */