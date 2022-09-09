package Controllers;

import Models.Parc;
import Vue.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadLogin implements ActionListener {
    Parc parc;
    JFrame frame;

    public LoadLogin(Parc p, JFrame f) {
        parc = p;
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setContentPane(new Login(parc, frame));
        frame.repaint();
        frame.revalidate();
    }
}
