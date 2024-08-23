import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalToOctalConverter extends JFrame {
    private JLabel instructionLabel;
    private JTextField decimalInputField;
    private JButton convertButton;
    private JLabel resultLabel;

    public DecimalToOctalConverter() {
        setTitle("8 진수 변환");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        instructionLabel = new JLabel("양의 정수를 입력하세요");
        decimalInputField = new JTextField(10);
        convertButton = new JButton("8진수로 변환");
        resultLabel = new JLabel("");

        convertButton.addActionListener(new ConvertButtonListener());

        panel.add(instructionLabel);
        panel.add(decimalInputField);
        panel.add(convertButton);
        panel.add(resultLabel);

        add(panel);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int decimalNumber = Integer.parseInt(decimalInputField.getText());
                if (decimalNumber < 0) {
                    resultLabel.setText("양의 정수를 입력하세요.");
                } else {
                    String octalNumber = convertToOctal(decimalNumber);
                    resultLabel.setText(octalNumber);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("유효한 숫자를 입력하세요.");
            }
        }

        private String convertToOctal(int decimalNumber) {
            StringBuilder octalNumber = new StringBuilder();
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 8;
                octalNumber.insert(0, remainder); 
                decimalNumber /= 8;
            }
            return octalNumber.toString();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DecimalToOctalConverter().setVisible(true);
            }
        });
    }
}
