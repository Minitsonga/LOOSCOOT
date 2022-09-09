package Vue;

import Models.Scooter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientReservation_CellInfo extends JPanel {


    public ClientReservation_CellInfo(Scooter scooter, LocalDate d1, LocalDate d2) {


        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;


        JLabel titleTxt = new JLabel(scooter.model.brand.name + " : " + scooter.model.label + " (ID : " + scooter.id + ")");
        titleTxt.setForeground(new Color(227, 63, 63));

        JLabel permisTxt = new JLabel("Permis " + scooter.model.licenceType.type + " nécessaire");
        JLabel kmTxt = new JLabel("Km : " + scooter.nbKm);
        JLabel capacityTxt = new JLabel("Centimètres cubes : " + scooter.model.capacity);

        String dateReservation;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");

        if (LocalDate.now().isBefore(d1)) {
            dateReservation = "Réservé du " + d1.format(formatter) + " au " + d2.format(formatter);
        } else {
            dateReservation = "En location depuis " + d1.format(formatter) + " jusqu'au " + d2.format(formatter);
        }

        JLabel stateTxt = new JLabel("<html><p style=\"width:200px\">" + dateReservation + "</p></html>");

        add(titleTxt, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 15, 0, 0);
        add(permisTxt, gbc);
        add(kmTxt, gbc);
        add(capacityTxt, gbc);
        add(stateTxt, gbc);


    }


}
