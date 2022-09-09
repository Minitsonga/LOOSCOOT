package Controllers;

import Models.Client;
import Models.Parc;
import Vue.ListScooterParc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListParcScooter implements ActionListener {

    Parc parc;
    JFrame frame;
    Client client;


    public ListParcScooter(Parc p, Client c, JFrame f) {
        parc = p;
        client = c;
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.setContentPane(new ListScooterParc(parc, client, frame));
        frame.repaint();
        frame.revalidate();


    }


}