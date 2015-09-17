package edu.jsu.mcis;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/*Remember*/
//don't output text inside of methods// THIS ONLY HAPPENS IN THE MAIN
//short and easy to write mains are a better design
//private methods for everything. Unless you need to make it public
//public = open door vs.  private = door with bouncer
//if you can collapse code in the main create a method for that
//Program should speak and listen through parameters and returns
//Declare closest to where they are used... Lowest scope possible
//A good function does one thing, they do it well they do it only
//functions should never return silently
//check for space return true for empty false for taken
//set mark should set the mark and access the methods for every essential thing you need
//look at code from the user perspective 
//name methods better
//make it easy and safe to use
//setMark(checkSpace>setMark>checkWin)
//Search.Maven.org search "robotframework" download pom.jar and makesure that it is in the classpath
//you changed the name of "RobotFramework" folder from "Robot Framework"
//robotframework.org/swinglibrary/swingLibrays-1.8.0.html#Launch Application
//theHandler handler = new theHandler();
//game.addActionListener(handler);


/***************acceptance testing with GUI***************/
//select Window selects by the title name the window "Tic Tac Toe"
//name button 

public class TicTacToe extends JFrame
{		
	public enum Mark{XMARK,OMARK,EMPTY};
	public enum gameStatus{XWIN,OWIN,TIE,ONGOING};
	public boolean xturn = true;
	public int moveCounter;
	private Mark[][] board = new Mark[3][3];
	//new variables
	public JFrame frame = new JFrame("TicTacToe");
	public JButton[][] buttons = new JButton[3][3];
	public JButton start = new JButton("Start");
	public JButton reset = new JButton("Reset");
	
    
	
    
 /*****************Main**********************/   
	public static void main(String[] args) 
	{
		TicTacToe game = new TicTacToe();
		game.initialize();
       
	}

/*****************constructor****************/	
	public TicTacToe() 
	{
		super();
		frame.setSize(350,450);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.setResizeable(false);
		clearBoard();
		initialize();
	}

/****************INITIALIZE*******************/	
	private void initialize()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new BorderLayout());
		JPanel game = new JPanel(new GridLayout(4,4));//4x4 because it is the dividers and not the cells
		
		frame.add(mainPanel);
		
		mainPanel.setPreferredSize(new Dimension(325,425));
		
        menu.setPreferredSize(new Dimension(300,50));
		game.setPreferredSize(new Dimension(250,250));
	
		mainPanel.add(menu, BorderLayout.NORTH);
		mainPanel.add(game, BorderLayout.SOUTH);
		menu.add(start, BorderLayout.WEST);
		menu.add(reset, BorderLayout.EAST);
        frame.pack();
	
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
                buttons[i][j] = new JButton();
                buttons[i][j].setName("Location " + i + ", " + j);
				buttons[i][j].setText("_");
				buttons[i][j].setVisible(true);
				game.add(buttons[i][j]);
			}
		}
	}

 
/******************CLEARBOARD*****************/ 
	public void clearBoard()
	{
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				board[row][col] = Mark.EMPTY;
				
			}
		}
		xturn = true;
		moveCounter = 0;
	}
	
/******************SetMark***************/    
	public void setMark(int x, int y)
	{	
		if (board[x][y] == Mark.EMPTY)
		{
			if (xturn == true)
			{
				board[x][y] = Mark.XMARK;
				xturn = false;
				moveCounter = moveCounter + 1;
			}
			else if (xturn == false)
			{
				board[x][y] = Mark.OMARK;
				xturn = true;
				moveCounter = moveCounter + 1;
			}
		}
		else 
		{
			System.out.println("Choose another Space!");
			//setMark();
		}
	}
/***************getMark****************/
	public Mark getMark(int x, int y)
	{
		Mark mark = board[x][y];
		System.out.println(mark);
		return mark;
	}
    
/***************checkForGameStatus****************/
	public gameStatus checkForWin()
	{
		boolean horizontal = false;
		boolean vertical = false;
		boolean diagonal = false;
		boolean diagonalLeft = false;
		
		for(int i=0; i<3; i++) 
		{
			horizontal = board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]);//&& board[0][0] != Mark.EMPTY;); for all tests);
			vertical = board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]);
			if(horizontal)
			{
				Mark mark = getMark(i,0);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
			else if (vertical)
			{
				Mark mark = getMark(0,i);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
			
		}
		diagonal = board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]);
		diagonalLeft = board[0][2].equals(board[1][1]) && board[1][1].equals(board[0][2]);
		
		if(diagonal)
			{
				Mark mark = getMark(0,0);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
		else if (diagonalLeft)
			{
				Mark mark = getMark(0,2);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
		else if (moveCounter == 9)//make this into if move counter == 9
		{
			return gameStatus.TIE;
		}			
		else return gameStatus.ONGOING;

	}
}