import javax.swing.*;
import java.awt.*;

public class Main {

    private static String[] titles;
    private static String[] dates;
    private static String[] links;
    public static void main(String[] args) throws Exception {
        setContentWith(new Client());
        setup();
    }
    private static void setup() {
        int y = 16;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        for (int i=0; i<titles.length; i++) {
            JTextArea label = new JTextArea();
            label.setBounds(16, y, 800, 50);
            label.setEditable(false);
            label.setBackground(Color.LIGHT_GRAY);
            label.setText(labelText(i));
            panel.add(label);
            y += 60;
        }

        panel.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 800, 800);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800, 800));
        contentPane.add(scrollPane);
        panel.setLayout(null);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle(Constants.FRAME_TITLE.rawValue);
    }

    private static void setContentWith(Client client) {
        titles = client.getTitles();
        dates = client.getDates();
        links = client.getLinks();
    }

    private static String labelText(int index) {
        return "Title: " + titles[index] + "\n" + "Date: " + dates[index] + "\n" + "Link: " + links[index];
    }
}