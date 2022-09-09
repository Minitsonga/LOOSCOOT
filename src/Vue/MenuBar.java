package Vue;


import Controllers.ClientReservations;
import Controllers.ReturnMenuBar;
import Models.Client;
import Models.Parc;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(Parc p, Client c, JFrame f) {

        JMenu mesReservationButton = new JMenu("Mes Réservation");

        ClientReservations reservationClient = new ClientReservations(p, c, f);
        mesReservationButton.addMenuListener(reservationClient);
        add(mesReservationButton);

        JMenu retourButton = new JMenu("Retour");
        ReturnMenuBar returnMenuBar = new ReturnMenuBar(p, c, f);
        retourButton.addMenuListener(returnMenuBar);

        add(Box.createHorizontalGlue());
        add(retourButton);


    }
}
