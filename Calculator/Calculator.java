import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

public class Calculator implements ActionListener {
    private JFrame frame;
    private JTextField field;
    private JButton b0, b1, b2, b3, b4, b5, b6, 
                    b7, b8, b9, badd, bsub, bmul,
                    bdiv, bcle, bequ, bpow, brot,
                    bln2, bdot, bsin, bcos, btan,
                    bpi;
    private double register1;
    private double register2;
    private byte opcode;
    
    public Calculator() {
        register1 = 0.0;
        register2 = 0.0;
        opcode = 0;
        frame = new JFrame("Pen Calculator");
        field = new JTextField();
        b0  = new JButton("0");
        b1  = new JButton("1");
        b2  = new JButton("2");
        b3  = new JButton("3");
        b4  = new JButton("4");
        b5  = new JButton("5");
        b6  = new JButton("6");
        b7  = new JButton("7");
        b8  = new JButton("8");
        b9  = new JButton("9");
        badd    = new JButton("+");
        bsub    = new JButton("-");
        bmul    = new JButton("x");
        bdiv    = new JButton("/");
        bcle    = new JButton("C");
        bequ    = new JButton("=");
        bpow    = new JButton("^");
        brot    = new JButton("sqrt()");
        bln2    = new JButton("log2()");
        bdot    = new JButton(".");
        bsin    = new JButton("sin()");
        bcos    = new JButton("cos()");
        btan    = new JButton("tan()");
        bpi     = new JButton("pi");
        
        //Set Layout
        field.setBounds(50, 30, 475, 50);
        b1.setBounds(20, 100, 60, 60);
        b2.setBounds(100, 100, 60, 60);
        b3.setBounds(180, 100, 60, 60);
        badd.setBounds(260, 100, 60, 60);
        bpow.setBounds(340, 100, 60, 60);
        bsin.setBounds(420, 100, 60, 60);
        b4.setBounds(20, 180, 60, 60);
        b5.setBounds(100, 180, 60, 60);
        b6.setBounds(180, 180, 60, 60);
        bsub.setBounds(260, 180, 60, 60);
        brot.setBounds(340, 180, 60, 60);
        bcos.setBounds(420, 180, 60, 60);
        b7.setBounds(20, 260, 60, 60);
        b8.setBounds(100, 260, 60, 60);
        b9.setBounds(180, 260, 60, 60);
        bmul.setBounds(260, 260, 60, 60);
        bln2.setBounds(340, 260, 60, 60);
        btan.setBounds(420, 260, 60, 60);
        bcle.setBounds(20, 340, 60, 60);
        b0.setBounds(100, 340, 60, 60);
        bequ.setBounds(180, 340, 60, 60);
        bdiv.setBounds(260, 340, 60, 60);
        bdot.setBounds(340, 340, 60, 60);
        bpi.setBounds(420, 340, 60, 60);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(b0);
        frame.add(bequ);
        frame.add(bcle);
        frame.add(badd);
        frame.add(bsub);
        frame.add(bdiv);
        frame.add(bmul);
        frame.add(bpow);
        frame.add(bsin);
        frame.add(brot);
        frame.add(bcos);
        frame.add(bln2);
        frame.add(btan);
        frame.add(bdot);
        frame.add(bpi);
        frame.add(field);
        frame.setLayout(null);
        frame.setSize(575, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        
        //Set action listeners
        field.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        badd.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        bsub.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bmul.addActionListener(this);
        bcle.addActionListener(this);
        b0.addActionListener(this);
        bequ.addActionListener(this);
        bdiv.addActionListener(this);
        bpow.addActionListener(this);
        bln2.addActionListener(this);
        brot.addActionListener(this);
        bdot.addActionListener(this);
        bsin.addActionListener(this);
        bcos.addActionListener(this);
        btan.addActionListener(this);
        bpi.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == field) {
            field.setText("Happy Easter");
        }
        if(e.getSource() == b0) {
            field.setText(field.getText().concat("0"));
        }
        if(e.getSource() == b1) {
            field.setText(field.getText().concat("1"));
        }
        if(e.getSource() == b2) {
            field.setText(field.getText().concat("2"));
        }
        if(e.getSource() == b3) {
            field.setText(field.getText().concat("3"));
        }
        if(e.getSource() == b4) {
            field.setText(field.getText().concat("4"));
        }
        if(e.getSource() == b5) {
            field.setText(field.getText().concat("5"));
        }
        if(e.getSource() == b6) {
            field.setText(field.getText().concat("6"));
        }
        if(e.getSource() == b7) {
            field.setText(field.getText().concat("7"));
        }
        if(e.getSource() == b8) {
            field.setText(field.getText().concat("8"));
        }
        if(e.getSource() == b9) {
            field.setText(field.getText().concat("9"));
        }
        if(e.getSource() == badd) {
            register1 = Double.parseDouble(field.getText());
            opcode = 1;
            field.setText("");
        }
        if(e.getSource() == bsub) {
            register1 = Double.parseDouble(field.getText());
            opcode = 2;
            field.setText("");
        }
        if(e.getSource() == bmul) {
            register1 = Double.parseDouble(field.getText());
            opcode = 3;
            field.setText("");
        }
        if(e.getSource() == bdiv) {
            register1 = Double.parseDouble(field.getText());
            opcode = 4;
            field.setText("");
        }
        if(e.getSource() == bequ) {
            register2 = Double.parseDouble(field.getText());
            double temp = 0.0;
            switch(opcode) {
                case 1:
                    temp = register2 + register1;
                    break;
                case 2:
                    temp = register1 - register2;
                    break;
                case 3:
                    temp = register1 * register2;
                    break;
                case 4:
                    temp = register1 / register2;
                    break;
                case 5:
                    temp = Math.pow(register1, register2);
                    break;
                case 6:
                    temp = Math.pow(register1, 1./register2);
                    break;
                    
                }
            field.setText(Double.toString(temp));
            opcode = 0;
            register1 = 0;
        }
        if(e.getSource() == bcle) {
            register1 = 0.0;
            register2 = 0.0;
            opcode = 0;
            field.setText("");
        }
        if(e.getSource() == bpow) {
            register1 = Double.parseDouble(field.getText());
            opcode = 5;
            field.setText("");
        }
        if(e.getSource() == brot) {
            register1 = Double.parseDouble(field.getText());
            opcode = 6;
            field.setText("");
        }
        if(e.getSource() == bln2) {
            register1 = Double.parseDouble(field.getText());
            field.setText(Double.toString((Math.log(register1)/ Math.log(2))));
        }
        if(e.getSource() == bdot) {
            field.setText(field.getText().concat("."));
        }
        if(e.getSource() == bsin) {
            register1 = Double.parseDouble(field.getText());
            field.setText(Double.toString((Math.sin(register1))));
        }
        if(e.getSource() == bcos) {
            register1 = Double.parseDouble(field.getText());
            field.setText(Double.toString((Math.cos(register1))));
        }
        if(e.getSource() == btan) {
            register1 = Double.parseDouble(field.getText());
            field.setText(Double.toString((Math.tan(register1))));
        }
        if(e.getSource() == bpi) {
            field.setText(Double.toString(Math.PI));
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
