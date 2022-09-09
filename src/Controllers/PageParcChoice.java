package Controllers;

import Models.Client;
import Models.Parc;
import Vue.ParcPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageParcChoice implements ActionListener {

    Parc parc;
    JFrame frame;
    Client client;


    public PageParcChoice(Parc p, Client c, JFrame f) {
        parc = p;
        frame = f;
        client = c;


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.setJMenuBar(null);
        frame.setContentPane(new ParcPage(parc, client, frame));
        frame.repaint();
        frame.revalidate();
    }
}
