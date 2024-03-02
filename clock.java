import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

class DigitalClock extends JFrame {
    private JLabel timeLabel;

    public DigitalClock() {
        // Set up the JFrame
        setTitle("Digital Clock");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and format the time label
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel);

        // Create a timer to update the time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DigitalClock clock = new DigitalClock();
                clock.setVisible(true);
            }
        });
    }
}