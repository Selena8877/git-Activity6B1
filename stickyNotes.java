import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StickyNotesApp {
    private JFrame frame;
    private JPanel notesPanel;
    private ArrayList<JTextArea> notes;

    public StickyNotesApp() {
        frame = new JFrame("Sticky Notes");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton addButton = new JButton("Add Note");
        addButton.addActionListener(e -> addNote());
        frame.add(addButton, BorderLayout.NORTH);

        notesPanel = new JPanel();
        notesPanel.setLayout(new FlowLayout());
        frame.add(new JScrollPane(notesPanel), BorderLayout.CENTER);

        notes = new ArrayList<>();
        
        frame.setVisible(true);
    }

    private void addNote() {
        JPanel notePanel = new JPanel();
        notePanel.setLayout(new BorderLayout());
        notePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        notePanel.setPreferredSize(new Dimension(150, 150));
        
        JTextArea noteArea = new JTextArea();
        notes.add(noteArea);
        notePanel.add(new JScrollPane(noteArea), BorderLayout.CENTER);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            notesPanel.remove(notePanel);
            notes.remove(noteArea);
            notesPanel.revalidate();
            notesPanel.repaint();
        });
        notePanel.add(deleteButton, BorderLayout.SOUTH);
        
        notesPanel.add(notePanel);
        notesPanel.revalidate();
        notesPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StickyNotesApp::new);
    }
}