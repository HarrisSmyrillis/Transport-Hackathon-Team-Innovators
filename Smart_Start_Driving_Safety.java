import javax.swing.*;
import java.awt.*;

public class Smart_Start_Driving_Safety {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JLabel successLabel;
    private JLabel failLabel;

    public Smart_Start_Driving_Safety() {
        frame = new JFrame("Smart Start Helper");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel menuPanel = createMenuPanel();
        JPanel scanFace = scanFacePanel();

        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(scanFace, "FACESCAN");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Hello, what would you like to do?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JButton startButton = new JButton("Access car key");
        JButton exitButton = new JButton("Exit Application");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e ->
                cardLayout.show(mainPanel, "FACESCAN")
        );

        exitButton.addActionListener(e -> System.exit(0));

        panel.add(Box.createVerticalStrut(50));
        panel.add(title);
        panel.add(Box.createVerticalStrut(50));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(exitButton);

        return panel;
    }

    private JPanel scanFacePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Facial Scan");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Camera placeholder
        JLabel cameraView = new JLabel("Camera Feed");
        cameraView.setPreferredSize(new Dimension(400, 200));
        cameraView.setMaximumSize(new Dimension(400, 200));
        cameraView.setHorizontalAlignment(SwingConstants.CENTER);
        cameraView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cameraView.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton scanButton = new JButton("Start Scan");
        scanButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        successLabel = new JLabel("Test successful, key is operable!");
        successLabel.setForeground(new Color(0, 150, 0));
        successLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        successLabel.setVisible(false);

        failLabel = new JLabel("Test failed, key is inoperable!");
        failLabel.setForeground(Color.RED);
        failLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        failLabel.setVisible(false);

        scanButton.addActionListener(e -> simulateScan());

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e ->
                cardLayout.show(mainPanel, "MENU")
        );

        panel.add(Box.createVerticalStrut(30));
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(cameraView);
        panel.add(Box.createVerticalStrut(20));
        panel.add(scanButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(successLabel);
        panel.add(failLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(backButton);

        return panel;
    }

    private void simulateScan() {
        successLabel.setVisible(false);
        failLabel.setVisible(false);

        boolean success = Math.random() > 0.5;

        if (success) {
            successLabel.setVisible(true);
        } else {
            failLabel.setVisible(true);
            
        }

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        new Smart_Start_Driving_Safety();
    }
}
