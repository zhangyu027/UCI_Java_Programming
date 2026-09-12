package inclass.m6.project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Java Project I - Photo Viewer (student starter). */
public class PhotoViewerLab extends JFrame {
    private static final long serialVersionUID = 1L;
    private final List<ImageIcon> imageIcons = new ArrayList<>();

    public PhotoViewerLab() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Photo Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO: Use JFileChooser to select a directory.
        // TODO: Load JPEG/JPG files from the selected directory.
        // TODO: Display the images in a scrollable panel.

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadImages(File directory) throws IOException {
        if (directory == null || !directory.isDirectory()) {
            throw new IOException("Please select a valid directory.");
        }
        // TODO: Read JPEG/JPG files with ImageIO and add ImageIcons to imageIcons.
        ImageIO.getReaderFormatNames();
    }

    private void setupImageLabels() {
        // TODO: Create JLabels for the images and refresh the scrollable panel.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhotoViewerLab::new);
    }
}
