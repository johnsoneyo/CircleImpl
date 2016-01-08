package bounce;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Launch extends JFrame {

    Circles circles;

    public Launch() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(500, 250);
        setTitle("Animated Circles");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

    }

    public void showCircle(int noOfCircles, int lowerRange, int higherRange) {
        circles = new Circles(noOfCircles, lowerRange, higherRange);

        add(circles);

        setVisible(true);

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
            }
            remove(circles);
            circles.updateCirclesLocation();
            add(circles);

            repaint();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Launch runCircle = new Launch();

        Panel optionsPanel = new Panel(runCircle, true);

        runCircle.showCircle(optionsPanel.getNoOfCircles(), optionsPanel.getLowerRange(), optionsPanel.getHigherRange());

    }

}
