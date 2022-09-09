package Controllers;

import Models.Parc;
import Vue.SignIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class LoadSignIn implements ActionListener {

    Parc parc;
    JFrame frame;
    LocalDate date;

    public LoadSignIn(Parc p, JFrame f) {
        parc = p;
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setContentPane(new SignIn(parc, frame, date));
        frame.repaint();
        frame.revalidate();
    }
}
