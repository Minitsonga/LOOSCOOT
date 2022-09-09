package Controllers;

import Models.Client;
import Models.Parc;
import Models.Scooter;
import Vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

import static Vue.GUI.windowOpen;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ValidateLoc_Return implements ActionListener {
    Scooter scooter;
    Client client;
    Parc parc;
    LocalDate startDate, endDate, date;
    JFrame mainFrame;
    Parc.ChoiceClient choiceClient;
    JTextField kilometers;
    JLabel erroTxt;


    public ValidateLoc_Return(Parc p, Scooter s, LocalDate d1, LocalDate d2, Client c, JFrame f, Parc.ChoiceClient choice, JTextField km, JLabel eT) {
        scooter = s;
        client = c;
        parc = p;
        startDate = d1;
        endDate = d2;
        mainFrame = f;
        choiceClient = choice;
        kilometers = km;
        erroTxt = eT;
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (!windowOpen) {
            JFrame frame = new JFrame("VERIFICATION");
            if (choiceClient == Parc.ChoiceClient.location) {

                if (parc.location(scooter, startDate, endDate, client)) {

                    frame.setContentPane(new ReservationValidate());
                    frame.setResizable(false);
                    frame.setSize(300, 300);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    windowOpen = true;
                }
            } else if (choiceClient == Parc.ChoiceClient.retour) {

                if (isNumeric(kilometers.getText())) {


                    if (parc.returnScooter(scooter, Integer.parseInt(kilometers.getText()), startDate, endDate, client)) {


                        frame.setContentPane(new Return());
                        frame.setResizable(false);
                        frame.setSize(300, 300);
                        //frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        windowOpen = true;

                    }

                } else {
                    erroTxt.setText("ERROR : Valeur des kilometres incorrect");
                }

            }
            else if (choiceClient == Parc.ChoiceClient.cancel) {
                if (parc.returnScooter(scooter, 0, startDate, endDate, client)) {


                    frame.setContentPane(new Cancel());
                    frame.setResizable(false);
                    frame.setSize(300, 300);
                    //frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    windowOpen = true;
                }
            }

            final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            final Runnable runnable = new Runnable() {
                int countdownStarter = 1;

                public void run() {
                    countdownStarter--;

                    if (countdownStarter < 0) {
                        frame.dispose();
                        windowOpen = false;
                        mainFrame.setJMenuBar(new MenuBar(parc, client, mainFrame));
                        mainFrame.setContentPane(new Home(parc, client, mainFrame, date));
                        mainFrame.repaint();
                        mainFrame.revalidate();
                        scheduler.shutdown();
                    }
                }
            };

            scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
        }
    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
