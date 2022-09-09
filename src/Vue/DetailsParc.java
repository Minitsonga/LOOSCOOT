package Vue;

import Controllers.PageParcChoice;
import Models.Client;
import Models.Parc;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

public class DetailsParc extends JPanel {

    public DetailsParc(Parc p, Client c, JFrame f) {

        Vector<Integer> summary = p.parcSummary(LocalDate.now());
        


        int nbScooterLocation = summary.get(0);
        int nbScooterDisp = summary.get(1);
        int kmMoyen = summary.get(2);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        JLabel titleTxt = new JLabel("Details de LOUSCOOT");
        titleTxt.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(titleTxt, gbc);

        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        panel.setPreferredSize(new Dimension(400, 400));

        JLabel nbScooter = new JLabel("Total de Scooter : " + p.getListScooter().size());
        nbScooter.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel scootDisp = new JLabel("Nombre de Scooter Disponible : " + nbScooterDisp);
        scootDisp.setFont(new Font("Tahoma", Font.PLAIN, 20));


        JLabel scootLoc = new JLabel("Nombre de Scooter en Location : " + nbScooterLocation);
        scootLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));


        JLabel nbKmTxt = new JLabel("Kilometrage Total Moyen : " + kmMoyen);
        nbKmTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));


        gbc.weighty = 1;

        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nbScooter, gbc);
        panel.add(scootDisp, gbc);
        panel.add(scootLoc, gbc);
        panel.add(nbKmTxt, gbc);

        gbc.anchor = GridBagConstraints.CENTER;

        add(panel, gbc);

        JPanel panel2 = new JPanel(new GridBagLayout());

        gbc.insets = new Insets(25, 0, 25, 0);

        JButton button1 = new JButton("Retour");
        button1.setBackground(new Color(182, 59, 59));
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setForeground(Color.WHITE);
        button1.setFocusPainted(false);
        button1.setPreferredSize(new Dimension(150, 30));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        PageParcChoice pageParc = new PageParcChoice(p, c, f);
        button1.addActionListener(pageParc);

        panel2.add(button1);
        add(panel2, gbc);


    }


}
