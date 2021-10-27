import java.awt.*;
import java.awt.event.*;


public class MovingRectangle extends Frame implements KeyListener {

    int x = 41;
    int y = 51;

    public MovingRectangle(){

        setSize(500,500);
        addKeyListener(this);       //key listener for arrows

        addWindowListener(new WindowAdapter() {        //window listener for closing frame
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g){
        g.drawString("x= "+x+", y= "+y, 40 ,45);
        g.drawRect(40,50,400,400);
        g.setColor(Color.cyan);
        g.fillRect(x,y,50,30);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        switch(keyCode){

            case KeyEvent.VK_UP:
                if (y>51) y -= 7;
                break;
            case KeyEvent.VK_LEFT:
                if (x> 41) x -= 7;
                break;
            case KeyEvent.VK_DOWN:
                if (y<420) y += 7;
                break;
            case KeyEvent.VK_RIGHT:
                if (x < 390) x+= 7;
                break;

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void  main(String[] args){
        new MovingRectangle().show();
    }
}
