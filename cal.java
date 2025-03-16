import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

class Myframe extends JFrame implements ActionListener, KeyListener {
    JPanel panel,panel2,panel3,panel4,panel5,panel6;
    JButton but1,but2,but3,but4,but5,but6,but7,but8,but9,but0,butp,butm,bute,butMul,butD,butDot,butc,butb;
    JLabel label;
    int output;
    private StringBuilder input;
    private double previousNumber;
    private char Operator;
    double currentNumber;
    double result;

    Myframe(){

        input = new StringBuilder();
        previousNumber = 0;
        Operator = ' ';

        label = new JLabel();
        label.setText("");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));

        but1 = new JButton("1");
        but1.setPreferredSize(new Dimension(45,45));

        but2 =new JButton("2");
        but2.setPreferredSize(new Dimension(45,45));

        but3 = new JButton("3");
        but3.setPreferredSize(new Dimension(45,45));

        but4 = new JButton("4");
        but4.setPreferredSize(new Dimension(45,45));

        but5 = new JButton("5");
        but5.setPreferredSize(new Dimension(45,45));

        but6 = new JButton("6");
        but6.setPreferredSize(new Dimension(45,45));

        but7 = new JButton("7");
        but7.setPreferredSize(new Dimension(45,45));

        but8 = new JButton("8");
        but8.setPreferredSize(new Dimension(45,45));

        but9 = new JButton("9");
        but9.setPreferredSize(new Dimension(45,45));

        but0 = new JButton("0");
        but0.setPreferredSize(new Dimension(45,45));

        butp = new JButton("+");
        butp.setPreferredSize(new Dimension(45,45));

        butm = new JButton("-");
        butm.setPreferredSize(new Dimension(45,45));

        bute = new JButton("=");
        bute.setPreferredSize(new Dimension(45,45));

        butD = new JButton("/");
        butD.setPreferredSize(new Dimension(45,45));

        butDot = new JButton(".");
        butDot.setPreferredSize(new Dimension(45,45));

        butMul = new JButton("x");
        butMul.setPreferredSize(new Dimension(45,45));

        butc = new JButton("C");
        butc.setPreferredSize(new Dimension(100,45));

        butb = new JButton("⌫");
        butb.setPreferredSize(new Dimension(100,45));


        panel = new JPanel(new GridLayout());
        panel.setPreferredSize(new Dimension(420,20));
        panel.add(label);
        panel.setBorder(BorderFactory.createLineBorder(Color.black,5));

        panel2 = new JPanel();
        panel2.add(but1);
        panel2.add(but2);
        panel2.add(but3);
        panel2.add(butp);

        panel3 = new JPanel();
        panel3.add(but4);
        panel3.add(but5);
        panel3.add(but6);
        panel3.add(butm);

        panel4 = new JPanel();
        panel4.add(but7);
        panel4.add(but8);
        panel4.add(but9);
        panel4.add(butD);

        panel5 = new JPanel();
        panel5.add(but0);
        panel5.add(butMul);
        panel5.add(butDot);
        panel5.add(bute);

        panel6= new JPanel();
        panel6.add(butc);
        panel6.add(butb);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(panel);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);

        but0.addActionListener(this);
        but1.addActionListener(this);
        but2.addActionListener(this);
        but3.addActionListener(this);
        but4.addActionListener(this);
        but5.addActionListener(this);
        but6.addActionListener(this);
        but7.addActionListener(this);
        but8.addActionListener(this);
        but9.addActionListener(this);
        butD.addActionListener(this);
        butDot.addActionListener(this);
        butp.addActionListener(this);
        butm.addActionListener(this);
        butMul.addActionListener(this);
        bute.addActionListener(this);
        butc.addActionListener(this);
        butb.addActionListener(this);

        this.addKeyListener(this);
        this.setFocusable(true);

    }

    public void actionPerformed(ActionEvent e){
        Object source= e.getSource();


        if (source instanceof JButton) {
            JButton button = (JButton) source;
            String buttonText = button.getText();
    
            if (buttonText.matches("[0-9.]")) { // Handles numbers and decimal point
                input.append(buttonText);
                label.setText(input.toString());
            }
    
            else if (buttonText.matches("[+\\-x/]")) { // Fix multiplication symbol
                if (input.length() == 0) return;  // Prevents error if no number entered
              
                previousNumber = Double.parseDouble(input.toString());
                Operator = buttonText.charAt(0);
                input.setLength(0); // Clear input for next number
                
                
            }
    
            else if (buttonText.equals("=")) {
                if (Operator == ' ' || input.length() == 0) return; // Prevent errors
    
                currentNumber = Double.parseDouble(input.toString());
                result = 0;
    
                switch (Operator) {
                    case '+': result = previousNumber + currentNumber; break;
                    case '-': result = previousNumber - currentNumber; break;
                    case 'x': result = previousNumber * currentNumber; break;
                    case '/': result = (currentNumber == 0) ? 0 : previousNumber / currentNumber; break;
                }
    
                label.setText(String.valueOf(result));
                input.setLength(0);
                input.append(result);
                Operator = ' '; // Reset operator
            }
    
            else if (source == butc) { // Fix clear button
                previousNumber = 0;
                currentNumber = 0;
                result = 0;
                input.setLength(0);
                label.setText("");
            }

            else if(source == butb & input.length()>0){
                input.deleteCharAt(input.length()-1);
                label.setText(input.toString());
            }
    
            }
        }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
        switch (e.getKeyChar()) {
            case '0':
                but0.doClick();
                break;
            case '1':
                but1.doClick();
                break;
            case '2':
                but2.doClick();
                break;
            case '3':
                but3.doClick();
                break;
            case '4':
                but4.doClick();
                break;
            case '5':
                but5.doClick();
                break;
            case '6':
                but6.doClick();
                break;
            case '7':
                but7.doClick();
                break;
            case '8':
                but8.doClick();
                break;
            case '9':
                but9.doClick();
                break;
            case '+':
                butp.doClick();
                break;
            case '-':
                butm.doClick();
                break;
            case '*':
                butMul.doClick();
                break;
            case '.':
                butDot.doClick();
                break;
            case '/':
                butD.doClick();
                break;
        }
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        switch (e.getKeyCode()) {
            case 10:
                bute.doClick();
                break;
            case 32:
                butc.doClick();
                break;
            case 8:
                butb.doClick();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        System.out.println("You Enterd :"+e.getKeyCode());
        //System.out.println("You Enterd :"+e.getKeyChar());
    }
}

class cal{
    public static void main(String[] args) {
        Myframe frame = new Myframe();
        
        frame.setTitle("Calculator");
        frame.setSize(420, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
}

