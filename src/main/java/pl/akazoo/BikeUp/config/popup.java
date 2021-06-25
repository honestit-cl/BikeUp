package pl.akazoo.BikeUp.config;


import javax.swing.*;
import java.awt.*;

public class popup {

    public popup() {
        JFrame frame = new JFrame("Uwaga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 100, 400, 200);

        Container container = frame.getContentPane();
        container.setLayout(null);

        JLabel logo = new JLabel("Podana nazwa użytkownika jest już zajęta. Podaj proszę inna nazwę.");
        logo.setBounds(60, 60, 60, 60);
        container.add(logo);
        frame.setVisible(true);
    }
}
