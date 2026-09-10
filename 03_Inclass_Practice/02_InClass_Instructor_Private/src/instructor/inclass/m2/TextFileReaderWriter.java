package instructor.inclass.m2;

import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.io.*;

public class TextFileReaderWriter extends JFrame {

    private final JTextArea area = new JTextArea();

    public TextFileReaderWriter() {

        super("Text File Reader/Writer");

        JButton read = new JButton("Read File");
        JButton write = new JButton("Write File");

        read.addActionListener(e -> read());
        write.addActionListener(e -> write());

        JPanel top = new JPanel();

        top.add(read);
        top.add(write);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void read() {

        JFileChooser c = new JFileChooser();

        if (c.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            try {

                area.setText(
                    Files.readString(
                        c.getSelectedFile().toPath()
                    )
                );

            } catch (IOException x) {

                JOptionPane.showMessageDialog(
                    this,
                    x.getMessage()
                );
            }
        }
    }

    private void write() {

        JFileChooser c = new JFileChooser();

        if (c.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            try {

                Files.writeString(
                    c.getSelectedFile().toPath(),
                    area.getText()
                );

                JOptionPane.showMessageDialog(
                    this,
                    "File saved."
                );

            } catch (IOException x) {

                JOptionPane.showMessageDialog(
                    this,
                    x.getMessage()
                );
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
            () -> new TextFileReaderWriter().setVisible(true)
        );
    }
}