import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Frame extends JFrame {
    private static JButton button;
    private static JLabel sucessLabel;

    Frame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);



        JLabel passwordLabel = new JLabel("");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        button = new JButton("Fetch Data");
        button.setBounds(135, 90, 100, 25);

        sucessLabel = new JLabel("");
        sucessLabel.setBounds(16, 120, 300, 25);
        sucessLabel.setVerticalAlignment(JLabel.CENTER);
        sucessLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(sucessLabel);

        panel.add(button);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}