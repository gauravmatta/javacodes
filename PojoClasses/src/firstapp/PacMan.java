package firstapp;

/*
   PacMan.java
   This is a lame replica of the game PacMan. The PacMan
   starts out on a random location on the board with
   6 ghosts & cheese. It must try to eat the cheese without
   getting eaten by the ghosts. The ghosts only move around
   when PacMan does. All characters on the board can only move
   around when PacMan does and can only move up, down, left,
   and right; diagonal movement isn't allowed. When PacMan eats
   all the cheese, the words 'YOU WIN! :)' will be displayed across
   the board; if you lose, 'YOU LOST! :(' will be shown.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacMan extends JApplet implements KeyListener
{
    private int chez, ghosts;
    private int currentx, currenty, direction, a;
    private int [][] grid;
    private int [] alienx, alieny;
    private DrawingArea canvas;
    private boolean lost;

  public void init()
  {
      setSize(500, 560);
      generateBoard();
      canvas = new DrawingArea(); // drawing area
      getContentPane().add(canvas, BorderLayout.CENTER);
      JPanel buttonPanel = new ButtonPanel();
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);
      canvas.setBackground(Color.black);
      canvas.addKeyListener(this);
      canvas.requestFocus();
  }
  public void generateBoard()
  {
      lost = false;
      chez = ghosts = currentx = currenty = 0;
      grid = new int[10][10]; // sets 2D array size
      alienx = new int[6];
      alieny = new int[6];
      do
      {
          currentx = (int)(Math.random() * 10);
          currenty = (int)(Math.random() * 10);
          if(grid[currentx][currenty] == 0 && chez < 6)
          {
              grid[currentx][currenty] = 1; // placement holder because 0 won't be read in
              chez++; // '1' is the cheese
          }
          if(grid[currentx][currenty] == 0 && ghosts < 6)
          {
              grid[currentx][currenty] = 2; // placement holder because 0 won't be read in
              alienx[ghosts] = currentx;
              alieny[ghosts] = currenty;
              ghosts++; // '2' is the ghosts
          }
      }
      while(chez < 6 || ghosts < 6);
      do  // this makes sure PacMan never respawns on a ghost or cheese
      {
          currentx = (int)(Math.random() * 10);
          currenty = (int)(Math.random() * 10);
      }
      while(grid[currentx][currenty] != 0);
      grid[currentx][currenty] = 3; // this is PacMan
      direction = 0;
  }
  public void moveGhosts(int a)
  {
      int oldx = alienx[a], oldy = alieny[a]; // coordinates of the aliens
      grid[oldx][oldy] = 0; // erases original spacing for monster/alien
      int stuff; // used for random statement
      boolean done = true;
      stuff = (int)(Math.random() * 8 + 1); // amount of random moves XD
      do
      {
         switch(stuff)
         {
            case 1: alienx[a]++; break; // down
            case 2: alienx[a]--; break; // up
            case 3: alieny[a]++; break; // right
            case 4: alieny[a]--; break; // left
            case 5: alienx[a]++; alieny[a]--; break; // down, left
            case 6: alienx[a]++; alieny[a]++; break; // down, right
            case 7: alienx[a]--; alieny[a]--; break; // up, left
            case 8: alienx[a]--; alieny[a]++; break; // up, right
         }
         if(alieny[a] == 10)
            alieny[a] = 0;
         if(alieny[a] == -1)
            alieny[a] = 9;
         if(alienx[a] == 10)
            alienx[a] = 0;
         if(alienx[a] == -1)
            alienx[a] = 9;
         if(grid[alienx[a]][alieny[a]] == 0 || grid[currentx][currenty] == 3)
            done = true; // only runs when ghost is on empty space or eats PacMan
         else
            done = false; // makes sure ghost never eats cheese
         for(int b = 0; b < 6; b++)
            if(alienx[b] == alienx[a] && alieny[b] == alieny[a] && b != a)
               done = false; // prevents ghosts from overlaping each other
         if (!done)
         {
            oldx = alienx[a];
            oldy = alieny[a];
         }
       } while (!done);
       grid[alienx[a]][alieny[a]] = 2;
  }
  class DrawingArea extends JPanel
  {
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         displayBoard(g);
         this.requestFocus();
      }
      public void displayBoard(Graphics g)
      {
          g.setColor(Color.gray);
          g.fillRect(116, 464, 270, 50); // gray background for board
          g.fillRect(30, 10, 445, 445); // gray background for 'cheese remaining'
          g.setColor(Color.yellow);
          g.drawRect(116, 464, 270, 50); // outlines 'cheese remaining' box
          if(grid[currentx][currenty] == 1) // makes cheese disappear when PacMan eats it
          {
             grid[currentx][currenty] = 0;
             chez--;
          }
          if(grid[currentx][currenty] == 2) // makes PacMan disappear when he hits a ghost
           lost = true;
          Font progress = new Font("Sans Serif", Font.PLAIN, 25);
             g.setFont(progress);
          if(!lost && chez > 0)
             g.drawString("Cheese Remaining:"+ chez, 130, 500); // shows # of cheese left
          else if(lost == true)
             g.drawString("YOU LOST! :(", 175, 500);
          else if(chez == 0)
             g.drawString("YOU WON! :)", 175, 500);
          g.setColor(Color.white);
          for(int row = 0; row < grid.length; row++)
             for(int col = 0; col < grid[row].length; col++)
             {
                 g.setColor(Color.white);
                 g.fillRect(30 + col * 45, 10 + row * 45, 40, 40); // prints grid
                 g.setColor(Color.blue); // primitive PacMan
                 if(!lost)
                     g.fillArc(30 + currentx * 45, 10 + currenty * 45, 40, 40, direction + 30, 300);
                 if(grid[col][row] == 1) // prints out cheese randomly if array encounters invisible '1'
                 {
                                                                                    // while scanning
                     g.setColor(Color.yellow);
                     g.fillRect(33 + col * 45, 13 + row * 45, 33, 33); // blocks of cheese
                 }
                 if(grid[col][row] == 2) // prints out ghosts randomly if array encounters invisible '2'
                 {
                                                                                        // while scanning
                     g.setColor(Color.red);
                     g.fillOval(30 + col * 45, 10 + row * 45, 40, 40); // ghosts' body
                     g.setColor(Color.black);
                     g.fillOval(38 + col * 45, 20 + row * 45, 8, 8); // left eye
                     g.fillOval(53 + col * 45, 20 + row * 45, 8, 8); // right eye
                     g.drawLine(38 + col * 45, 37 + row * 45, 61 + col * 45, 37 + row * 45); // mouth
                 }
             }
       }
  }
  public void keyPressed(KeyEvent evt)
  {
      int value = evt.getKeyCode();
      if(!lost && chez > 0)
      switch(value)
      {
       case KeyEvent.VK_LEFT:
          {
           currentx--;   // PacMan moves left
              if(currentx == -1) // makes sure the PacMan can 'loop' around through 'portals'
               currentx = 9;
              direction = 180; //faces left
              for(int a = 0; a < 6; a++)
              moveGhosts(a);
          } break;
       case KeyEvent.VK_RIGHT:
          {
              currentx++;   // PacMan moves right
              if(currentx == 10) // makes sure the PacMan can 'loop' around through 'portals'
               currentx = 0;
              direction = 0; //faces right
              for(int a = 0; a < 6; a++)
              moveGhosts(a);
          } break;
          case KeyEvent.VK_UP:
          {
              currenty--;   // PacMan moves up
              if(currenty == -1) // makes sure the PacMan can 'loop' around through 'portals'
               currenty = 9;
              direction = 90; //faces up
              for(int a = 0; a < 6; a++)
              moveGhosts(a);
          } break;
          case KeyEvent.VK_DOWN:
          {
              currenty++;   // PacMan moves down
              if(currenty == 10) // makes sure the PacMan can 'loop' around through 'portals'
               currenty = 0;
              direction = 270; //faces down
              for(int a = 0; a < 6; a++)
              moveGhosts(a);
          } break;
     }
     if(value == KeyEvent.VK_SPACE)
     generateBoard(); // call on method to regenerate board
     canvas.repaint(); // repaints the board
  }
  class ButtonPanel extends JPanel implements ActionListener
  {
      private JButton left, right, up, down, reset;
      public ButtonPanel() // displays available buttons
      {
              left = new JButton("LEFT");
           left.addActionListener(this);
           this.add(left);
          right = new JButton("RIGHT");
           right.addActionListener(this);
           this.add(right);
          up = new JButton("UP");
           up.addActionListener(this);
               this.add(up);
          down = new JButton("DOWN");
           down.addActionListener(this);
           this.add(down);
          reset = new JButton("RESET");
           reset.addActionListener(this);
           this.add(reset);
     }
     public void actionPerformed(ActionEvent evt)
     {
         String command = evt.getActionCommand();
         if(!lost && chez > 0)
         {
                 if(command.equals("LEFT"))
             {
                 currentx--;   // PacMan moves left
                 if(currentx == -1) // makes sure the PacMan can 'loop' around through 'portals'
                 currentx = 9;
                 direction = 180; //faces left
                 for(int a = 0; a < 6; a++)
                 moveGhosts(a);
             }
             else if(command.equals("RIGHT"))
             {
                      currentx++;   // PacMan moves right
                 if(currentx == 10) // makes sure the PacMan can 'loop' around through 'portals'
                 currentx = 0;
                 direction = 0; //faces right
                 for(int a = 0; a < 6; a++)
                 moveGhosts(a);
             }
             else if(command.equals("UP"))
             {
                      currenty--;   // PacMan moves up
                 if(currenty == -1) // makes sure the PacMan can 'loop' around through 'portals'
                 currenty = 9;
                 direction = 90; //faces up
                 for(int a = 0; a < 6; a++)
                 moveGhosts(a);
             }
             else if(command.equals("DOWN"))
             {
                      currenty++;   // PacMan moves down
                 if(currenty == 10) // makes sure the PacMan can 'loop' around through 'portals'
                 currenty = 0;
                 direction = 270; //faces down
                 for(int a = 0; a < 6; a++)
                 moveGhosts(a);
             }
         }
        if(command.equals("RESET"))
        generateBoard(); // call on method to regenerate board
        canvas.repaint(); // repaints the board
       }
  }
  public void keyTyped(KeyEvent evt) {}
  public void keyReleased(KeyEvent evt) {}
  public void actionPerformed(ActionEvent evt) {}
}