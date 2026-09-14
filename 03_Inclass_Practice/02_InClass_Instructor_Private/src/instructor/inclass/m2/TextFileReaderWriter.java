package instructor.inclass.m2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String line;
                    textArea.setText("");

                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }

                    reader.close();
                } catch (IOException ex) {
                    textArea.setText("File not found or an error occurred.");
                }
            }
        });

        writeFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                String content = textArea.getText();

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    writer.write(content);
                    writer.close();
                } catch (IOException ex) {
                    textArea.setText("Error writing to the file.");
                }
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
