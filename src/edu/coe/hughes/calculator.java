package edu.coe.hughes;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {

    static JTextField l;

    static JFrame frame;

    static calculator c;

    String s0, s1, s2;

    calculator()
    {
        s0 = s1 = s2 = "";
    }
    public static final String[][] BUTTON_TEXTS = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", " ", "=", "+"}
    };
    public static final Font BTN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 24);

    private static void createAndShowGui() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        l = new JTextField(10);
        l.setEditable(false);
        l.setFont(BTN_FONT.deriveFont(Font.PLAIN));
        JPanel btnPanel = new JPanel(new GridLayout(BUTTON_TEXTS.length,
                BUTTON_TEXTS[0].length));

        for (int i = 0; i < BUTTON_TEXTS.length; i++) {
            for (int j = 0; j < BUTTON_TEXTS[i].length; j++) {
                JButton btn = new JButton(BUTTON_TEXTS[i][j]);
                btn.addActionListener(c);
                btn.setFont(BTN_FONT);
                btnPanel.add(btn);
            }
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(l, BorderLayout.PAGE_START);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGui();
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";

            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            l.setText(s0 + s1 + s2 + "=" + te);

            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te;

                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                s0 = Double.toString(te);

                s1 = s;

                s2 = "";
            }

            l.setText(s0 + s1 + s2);
        }
    }
}
//current value: int
//setmode(operator)
//processnumber(int): int
//add(n1,n2)
//subtract(n1,n2)
//multiply(n1,n2)

//listen for numberButton press
//listen for operator process
//setdisplay(num)
//setcontroller(c)