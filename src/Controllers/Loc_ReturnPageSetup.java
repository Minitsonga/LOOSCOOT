package Controllers;

import Models.Client;
import Models.Parc;
import Vue.Locate_Return_PageChoice;
import Vue.MenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loc_ReturnPageSetup implements ActionListener {

    Parc parc;

    JFrame frame;
    Client client;

    public Loc_ReturnPageSetup(Parc p, Client c, JFrame f) {
        parc = p;
        frame = f;
        client = c;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.setJMenuBar(new MenuBar(parc, client, frame));
        frame.setContentPane(new Locate_Return_PageChoice(parc, client, frame));
        frame.repaint();
        frame.revalidate();


    }
}