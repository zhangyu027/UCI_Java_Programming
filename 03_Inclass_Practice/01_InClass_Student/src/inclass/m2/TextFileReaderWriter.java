package inclass.m2;

/*
 * IN-CLASS STUDENT HINTS
 * ----------------------
 * This starter follows the Canvas Project 2 structure.
 * Work incrementally and run after each small change.
 * Use BufferedReader/FileReader to read a text file.
 * Use BufferedWriter/FileWriter to write a text file.
 * Complete the TODO sections instead of replacing the whole program.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/** Module 2 practice: Swing text-file reader/writer. */
public class TextFileReaderWriter {

    private JFrame frame;
    private JTextArea textArea;
    private JTextField fileNameField;

    public TextFileReaderWriter() {

        frame = new JFrame("Text File Reader/Writer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel controlPanel = new JPanel();

        fileNameField = new JTextField(20);
        JButton readFileButton = new JButton("Read File");
        JButton writeFileButton = new JButton("Write File");

        readFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String fileName = fileNameField.getText();

                // TODO 1: Create a BufferedReader using FileReader.
                // TODO 2: Clear the text area before reading.
                // TODO 3: Read the file one line at a time.
                // TODO 4: Append each line to textArea.
                // TODO 5: Close the reader and handle IOException.

                /*
                 * HINT / CODE PATTERN:
                 * try {
                 *     BufferedReader reader =
                 *         new BufferedReader(new FileReader(fileName));
                 *
                 *     String line;
                 *     textArea.setText("");
                 *
                 *     while ((line = reader.readLine()) != null) {
                 *         // append line to textArea
                 *     }
                 *
                 *     reader.close();
                 * } catch (IOException ex) {
                 *     // display an error message
                 * }
                 */
            }
        });

        writeFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String fileName = fileNameField.getText();
                String content = textArea.getText();

                // TODO 6: Create a BufferedWriter using FileWriter.
                // TODO 7: Write content to the selected file name.
                // TODO 8: Close the writer and handle IOException.

                /*
                 * HINT / CODE PATTERN:
                 * try {
                 *     BufferedWriter writer =
                 *         new BufferedWriter(new FileWriter(fileName));
                 *
                 *     writer.write(content);
                 *     writer.close();
                 * } catch (IOException ex) {
                 *     // display an error message
                 * }
                 */
            }
        });

        controlPanel.add(fileNameField);
        controlPanel.add(readFileButton);
        controlPanel.add(writeFileButton);

        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFileReaderWriter();
            }
        });
    }
}
