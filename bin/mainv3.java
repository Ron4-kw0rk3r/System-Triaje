
/*
    * Author: Bryan Ronaldo Sánchez Mendoza
    * Version: 0.1.18v
    * fecha_dev: 15/10/23
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class mainv3 {
    private static JTextField userField;
    private static JPasswordField passField;
    private static JLabel notificationLabel;
    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Sistema de triaje - APP MEDIC");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(210, 199, 250));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        notificationLabel = new JLabel();
        notificationLabel.setForeground(Color.YELLOW);

        JLabel label = new JLabel("Sistema Medico de Triage");
        label.setFont(new Font("Arial", Font.BOLD, 28));

        // Crea un panel para la imagen y el botón de adición
        JPanel imageAndButtonPanel = new JPanel();
        imageAndButtonPanel.setLayout(new FlowLayout());

        ImageIcon imageIcon = new ImageIcon("res/log.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);

        JButton plusButton = new JButton("+");
        plusButton.setFont(new Font("Arial", Font.PLAIN, 35));
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código del botón + (registro de usuario) aquí...
            }
        });

        // Agrega la imagen y el botón al panel
        imageAndButtonPanel.add(imageLabel);
        imageAndButtonPanel.add(plusButton);

        userField = new JTextField(25);
        passField = new JPasswordField(25);

        // Etiquetas para los campos de entrada
        JLabel userLabel = new JLabel("USUARIO");
        JLabel passLabel = new JLabel("CONTRASEÑA");

        JButton button = new JButton("INGRESAR");
        button.setBackground(Color.WHITE); // Cambia el color de fondo del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código del botón "INGRESAR" aquí...
            }
        });

        // Resto del código...

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(imageAndButtonPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Panel para los campos de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(userLabel);
        inputPanel.add(userField);
        inputPanel.add(passLabel);
        inputPanel.add(passField);

        panel.add(inputPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);

        // Para centrar los elementos del panel
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        userField.setMaximumSize(userField.getPreferredSize());
        passField.setMaximumSize(passField.getPreferredSize());

        frame.add(panel);
        frame.setVisible(true);
    }
}

