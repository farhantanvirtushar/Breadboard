import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Linker extends JComponent{

    public Map<JComponent, JComponent> linked;

    void clear()
    {
        for ( JComponent c1 : linked.keySet () )
        {
            JComponent c2=linked.get ( c1 );
            ((JRadioButton)c1).setSelected(false);
            ((JRadioButton)c2).setSelected(false);
        }
        linked.clear();
        repaint ();
    }
    public Linker()
    {
        super ();
        linked = new HashMap<>();
    }

    public void link ( JComponent c1, JComponent c2 ,boolean connect)
    {
        if(connect)
        {

            linked.put ( c1, c2 );
            linked.put ( c2, c1 );
            ((JRadioButton)c1).setSelected(true);
            ((JRadioButton)c2).setSelected(true);

        }
        else
        {
            ((JRadioButton)c1).setSelected(false);
            ((JRadioButton)c2).setSelected(false);
            linked.remove(c1);
            linked.remove(c2);
        }
        repaint ();
    }

    protected void paintComponent ( Graphics g )
    {
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

        g2d.setPaint ( Color.BLACK );
        for ( JComponent c1 : linked.keySet () )
        {
            Point p1 = getRectCenter ( getBoundsInWindow ( c1 ) );
            Point p2 = getRectCenter ( getBoundsInWindow ( linked.get ( c1 ) ) );
            g2d.drawLine ( p1.x, p1.y, p2.x, p2.y );
        }
    }

    private Point getRectCenter ( Rectangle rect )
    {
        return new Point ( rect.x + rect.width / 2, rect.y + rect.height / 2 );
    }

    private Rectangle getBoundsInWindow ( Component component )
    {
        return getRelativeBounds ( component, getRootPaneAncestor ( component ) );
    }

    private Rectangle getRelativeBounds ( Component component, Component relativeTo )
    {
        return new Rectangle ( getRelativeLocation ( component, relativeTo ),
                component.getSize () );
    }

    private Point getRelativeLocation ( Component component, Component relativeTo )
    {
        Point los = component.getLocationOnScreen ();
        Point rt = relativeTo.getLocationOnScreen ();
        return new Point ( los.x - rt.x, los.y - rt.y );
    }

    private JRootPane getRootPaneAncestor ( Component c )
    {
        for ( Container p = c.getParent (); p != null; p = p.getParent () )
        {
            if ( p instanceof JRootPane )
            {
                return ( JRootPane ) p;
            }
        }
        return null;
    }

    public boolean contains ( int x, int y )
    {
        return false;
    }

}
