package instructor.inclass.m2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Module 2 Programming Part II - instructor reference, version 2.
 *
 * This version keeps the original PersonalInfoFileApp.java intact and provides
 * a Canvas-aligned implementation using named Swing fields, traditional
 * ActionListener objects, BufferedReader/FileReader, and
 * BufferedWriter/FileWriter.
 */
public class PersonalInfoFileAppV2 {

    private JFrame frame;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;

    private final String fileName = "data/personal_info.txt";

    public PersonalInfoFileAppV2() {
        frame = new JFrame("Personal Information - V2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        nameField = new JTextField(20);
        addressField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        zipField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("City:"));
        formPanel.add(cityField);
        formPanel.add(new JLabel("State:"));
        formPanel.add(stateField);
        formPanel.add(new JLabel("ZIP Code:"));
        formPanel.add(zipField);
        formPanel.add(saveButton);
        formPanel.add(loadButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveInformation();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadInformation();
            }
        });

        frame.add(formPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void saveInformation() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String city = cityField.getText().trim();
        String state = stateField.getText().trim();
        String zip = zipField.getText().trim();

        if (name.isEmpty() || address.isEmpty() || city.isEmpty()
                || state.isEmpty() || zip.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All fields are required.");
            return;
        }

        File file = new File(fileName);
        File parent = file.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(name + "|" + address + "|" + city + "|" + state + "|" + zip);
            writer.newLine();
            JOptionPane.showMessageDialog(frame, "Information saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                frame,
                "Error saving file: " + ex.getMessage()
            );
        }
    }

    private void loadInformation() {
        File file = new File(fileName);

        if (!file.exists()) {
            JOptionPane.showMessageDialog(frame, "No saved information was found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String latestLine = null;

            while ((line = reader.readLine()) != null) {
                latestLine = line;
            }

            if (latestLine == null) {
                JOptionPane.showMessageDialog(frame, "The file is empty.");
                return;
            }

            String[] parts = latestLine.split("\\|", -1);

            if (parts.length == 5) {
                nameField.setText(parts[0]);
                addressField.setText(parts[1]);
                cityField.setText(parts[2]);
                stateField.setText(parts[3]);
                zipField.setText(parts[4]);

                JOptionPane.showMessageDialog(frame, "Information loaded successfully.");
            } else {
                JOptionPane.showMessageDialog(
                    frame,
                    "Saved data is not in the expected format."
                );
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                frame,
                "Error loading file: " + ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PersonalInfoFileAppV2();
            }
        });
    }
}
