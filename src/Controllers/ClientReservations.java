package Controllers;

import Models.Client;
import Models.Parc;
import Vue.ListScooterClient;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Vue.GUI.windowOpen;

public class ClientReservations implements ActionListener, MenuListener {

    Parc parc;
    Client client;
    JFrame frame;

    public ClientReservations(Parc p, Client c, JFrame f) {
        parc = p;
        client = c;
        frame = f;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!windowOpen) {
            frame.setContentPane(new ListScooterClient(parc, client, frame));
            frame.repaint();
            frame.revalidate();
        }

    }

    @Override
    public void menuSelected(MenuEvent e) {
        frame.setContentPane(new ListScooterClient(parc, client, frame));
        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
