package Controllers;

import Models.Client;
import Models.Parc;
import Vue.Home;
import Vue.MenuBar;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static Vue.GUI.windowOpen;

public class ReturnMenuBar implements MenuListener, ActionListener {

    JFrame frame;
    Client client;
    Parc parc;
    LocalDate date;

    public ReturnMenuBar(Parc p, Client c, JFrame f) {
        parc = p;
        client = c;
        frame = f;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        frame.setJMenuBar(new MenuBar(parc, client, frame));
        frame.setContentPane(new Home(parc, client, frame, date));
        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (!windowOpen) {
            frame.setJMenuBar(new MenuBar(parc, client, frame));
            frame.setContentPane(new Home(parc, client, frame, date));
            frame.repaint();
            frame.revalidate();
        }
    }
}
