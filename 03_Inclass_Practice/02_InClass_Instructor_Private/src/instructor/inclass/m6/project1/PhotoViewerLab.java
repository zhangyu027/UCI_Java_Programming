package instructor.inclass.m6.project1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/** Java Project I - Photo Viewer instructor reference. */
public class PhotoViewerLab extends JFrame {
    private static final long serialVersionUID = 1L;
    private final List<ImageIcon> imageIcons = new ArrayList<>();
    private final JPanel imagePanel = new JPanel(new GridLayout(0, 2, 8, 8));

    public PhotoViewerLab() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Photo Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JScrollPane(imagePanel), BorderLayout.CENTER);

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                loadImages(chooser.getSelectedFile());
                setupImageLabels();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadImages(File directory) throws IOException {
        imageIcons.clear();
        File[] files = directory.listFiles(file -> {
            String name = file.getName().toLowerCase();
            return name.endsWith(".jpg") || name.endsWith(".jpeg");
        });
        if (files == null) throw new IOException("Unable to read selected directory.");
        for (File file : files) {
            Image image = ImageIO.read(file);
            if (image != null) {
                imageIcons.add(new ImageIcon(image.getScaledInstance(320, 220, Image.SCALE_SMOOTH)));
            }
        }
    }

    private void setupImageLabels() {
        imagePanel.removeAll();
        for (ImageIcon icon : imageIcons) imagePanel.add(new JLabel(icon));
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhotoViewerLab::new);
    }
}
