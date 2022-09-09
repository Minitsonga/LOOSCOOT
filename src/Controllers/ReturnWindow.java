package Controllers;

import Models.Client;
import Models.Parc;
import Models.Scooter;
import Vue.Home;
import Vue.MenuBar;
import Vue.Return;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import static Vue.GUI.windowOpen;

public class ReturnWindow implements ActionListener {

    Scooter scooter;
    Client client;
    Parc parc;
    LocalDate date;
    JFrame mainFrame;

    public ReturnWindow(Parc p, Scooter s, Client c,LocalDate d, JFrame f) {
        scooter = s;
        client = c;
        parc = p;
        date = d;
        mainFrame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (!windowOpen) {

            //TODO animation "en cour de chargement" avec fenetre qui s'ouvre et ensuite validation (ouverture nouvelle fentre avec ligne idiquent ce qui ce passe comme logiciel installation)
            //Fermeture auto apres 5 sec.
            //Ajoute de nouvelle reservation

            JFrame frame = new JFrame("VALIDATION");

            frame.setContentPane(new Return());
            frame.setResizable(false);
            frame.setSize(300, 300);
            //frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            windowOpen = true;
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    windowOpen = false;
                    mainFrame.setJMenuBar(new MenuBar(parc, client, mainFrame));
                    mainFrame.setContentPane(new Home(parc, client, mainFrame, date));
                    mainFrame.repaint();
                    mainFrame.revalidate();
                }
            });


        }


    }
}
