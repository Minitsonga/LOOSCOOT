package Controllers;

import Models.Client;
import Models.Parc;
import Vue.DetailsParc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatParc implements ActionListener {

    Parc parc;
    JFrame frame;
    Client client;


    public StatParc(Parc p, Client c, JFrame f) {
        parc = p;
        client = c;
        frame = f;



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.setContentPane(new DetailsParc(parc, client, frame));
        frame.repaint();
        frame.revalidate();


    }


}