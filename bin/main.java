import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class main {
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
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230, 123)); // Color celeste claro transparente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usar un diseño vertical

        notificationLabel = new JLabel();
        notificationLabel.setForeground(Color.YELLOW);

        JLabel label = new JLabel("Sistema Medico de Triage");
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto

        ImageIcon imageIcon = new ImageIcon("res/log.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar la imagen


        JLabel userLabel = new JLabel("USUARIO");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto
        userField = new JTextField(25);
        userField.setMaximumSize(userField.getPreferredSize()); // Alinear al centro
        

        JLabel passLabel = new JLabel("CONTRASENA");
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto
        passField = new JPasswordField(25);
        passField.setMaximumSize(passField.getPreferredSize());
        /* 
        passField = new JPasswordField(25);
        passField.setMaximumSize(passField.getPreferredSize()); // Alinear al centro
        panel.add(passField);
        userField = new JTextField(25);
        userField.setMaximumSize(userField.getPreferredSize()); // Alinear al centro
        passField = new JPasswordField(25);
        passField.setMaximumSize(passField.getPreferredSize()); // Alinear al centro
        */
        // nueva ventana .... 

        JButton plusButton = new JButton("+");
        plusButton.setFont(new Font("Arial", Font.PLAIN, 45));
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addUserFrame = new JFrame("Agregar usuario nuevo");
                addUserFrame.setSize(400, 400);
                addUserFrame.setLayout(new BoxLayout(addUserFrame.getContentPane(), BoxLayout.Y_AXIS));
                addUserFrame.setLocationRelativeTo(frame); // This will center the addUserFrame relative to the main frame
                frame.setResizable(false);

                
                userField = new JTextField(25);
                userField.setMaximumSize(userField.getPreferredSize());
                


                JLabel newuserLabel = new JLabel("NOMBRE");
                JTextField nameField = new JTextField(25);
                JLabel newespLabel = new JLabel("ESPECIALIDAD");
                JTextField specialtyField = new JTextField(25);
                JLabel newpaswordLabel = new JLabel("CONTRASENA");
                JPasswordField passwordField = new JPasswordField(25);


                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addUserFrame.dispose();
                    }
                });
                
                JButton registerButton = new JButton("Registrar");
                
                registerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Aquí se puede agregar la lógica del registro de los datos.
                        // Para este ejemplo, solo se imprimirá la fecha actual.
                        String name = nameField.getText();
                        String specialty = specialtyField.getText();
                        String password = new String(passwordField.getPassword());

                        if (!name.isEmpty() && !specialty.isEmpty() && !password.isEmpty()) {
                            notificationLabel.setText("Usuario registrado con éxito: " + name);
                            notificationLabel.setBackground(Color.GREEN);
                            System.out.println("Usuario registrado: " + name + ", Especialidad: " + specialty + ", Fecha: " + new java.util.Date());
                        } else {
                            notificationLabel.setText("Error en el registro, por favor complete todos los campos");
                            notificationLabel.setBackground(Color.RED);
                        }

                        addUserFrame.dispose();
                    }
                });
                addUserFrame.add(newuserLabel);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 20)));
                addUserFrame.add(nameField);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 20)));
                addUserFrame.add(newespLabel);
                addUserFrame.add(specialtyField);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 20)));
                addUserFrame.add(newpaswordLabel);
                addUserFrame.add(passwordField);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 20)));

                addUserFrame.add(cancelButton); addUserFrame.add(registerButton);
                
                addUserFrame.setVisible(true);
            }
        });
        

        //fin de la ventana...

        
        JButton button = new JButton("INGRESAR");
        
        
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Botón centrado
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se puede agregar la lógica del chequeo de los datos.
                // Para este ejemplo, siempre asumiré que los datos son incorrectos.
                notificationLabel.setText("Falla de acceso, vuelva a intentar");
                notificationLabel.setBackground(Color.RED);
                userField.setText(""); // Limpiar campos de texto
                passField.setText("");
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(imageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(userLabel);
        panel.add(userField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(passLabel);
        panel.add(passField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JPanel plusButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        plusButtonPanel.add(plusButton);
        plusButtonPanel.setBackground(new Color(173, 216, 230, 123));
        panel.add(plusButtonPanel);
        

        //panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        frame.add(panel);
        frame.setVisible(true);
    }
}



