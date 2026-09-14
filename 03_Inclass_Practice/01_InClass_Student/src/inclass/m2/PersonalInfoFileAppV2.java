package inclass.m2;

/*
 * MODULE 2 PROGRAMMING PART II - STUDENT VERSION 2
 * -------------------------------------------------
 * This starter follows the Canvas challenge structure.
 * Complete the TODO sections incrementally and test after each change.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/** Module 2 challenge: save and load personal information using Swing + file I/O. */
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

        // TODO 1: Validate that all five fields contain data.
        // If a field is empty, display a meaningful JOptionPane error and return.

        // TODO 2: Create the data directory if necessary.

        // TODO 3: Open the file in APPEND mode using FileWriter(file, true)
        // wrapped in BufferedWriter.

        // TODO 4: Save one record containing name, address, city, state, and ZIP.
        // Use a delimiter such as | between the five values and then writer.newLine().

        // TODO 5: Show a success message after the information is saved.

        /*
         * HINT:
         * File file = new File(fileName);
         *
         * try (BufferedWriter writer =
         *          new BufferedWriter(new FileWriter(file, true))) {
         *     // writer.write(...);
         *     // writer.newLine();
         * } catch (IOException ex) {
         *     // show an informative error message
         * }
         */
    }

    private void loadInformation() {
        // TODO 6: Check whether the file exists before attempting to read it.

        // TODO 7: Use BufferedReader and FileReader to read the saved records.
        // Because Save appends records, keep track of the latest line read.

        // TODO 8: Split the latest record into five parts and populate:
        // nameField, addressField, cityField, stateField, and zipField.

        // TODO 9: Display success/error feedback with JOptionPane.

        /*
         * HINT:
         * try (BufferedReader reader =
         *          new BufferedReader(new FileReader(fileName))) {
         *     String line;
         *     String latestLine = null;
         *
         *     while ((line = reader.readLine()) != null) {
         *         latestLine = line;
         *     }
         *
         *     // split latestLine and place values in the fields
         * } catch (IOException ex) {
         *     // show an informative error message
         * }
         */
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PersonalInfoFileAppV2();
            }
        });
    }
}
