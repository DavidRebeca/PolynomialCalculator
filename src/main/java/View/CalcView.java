package View;
import Model.Polinomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcView extends JFrame{
    Polinomial model;///model
    private JPanel panel1;
    private JButton a1Button;
    private JButton a4Button;
    private JButton button4;
    private JButton button5;
    private JButton a0Button;
    private JButton a7Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton a2Button;
    private JButton xButton;
    private JButton button7;
    private JButton DELButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton CALCULEAZAButton;
    private JButton EXITButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton CLEARButton;

    public CalcView(Polinomial modelPolinomial)
    {
        model=modelPolinomial;
        setContentPane(panel1);
        setTitle("CALCULATOR POLINOAME");
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        comboBox1.removeAllItems();
        comboBox1.addItem("Polinom 1");
        comboBox1.addItem("Polinom 2");
        comboBox2.removeAllItems();
        comboBox2.addItem("ADUNARE");
        comboBox2.addItem("SCADERE");
        comboBox2.addItem("INMULTIRE");
        comboBox2.addItem("IMPARTIRE");
        comboBox2.addItem("INTEGRARE");
        comboBox2.addItem("DERIVARE");
        EXITButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
     a0Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"0");
                else
                    textField2.setText(textField2.getText()+"0");
            }});
        a1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"1");
                else
                    textField2.setText(textField2.getText()+"1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"2");
                else
                    textField2.setText(textField2.getText()+"2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"3");
                else
                    textField2.setText(textField2.getText()+"3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"4");
                else
                    textField2.setText(textField2.getText()+"4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"5");
                else
                    textField2.setText(textField2.getText()+"5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                textField1.setText(textField1.getText()+"6");
                else
                textField2.setText(textField2.getText()+"6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"7");
                else
                    textField2.setText(textField2.getText()+"7");
            }});
        a8Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"8");
                else
                    textField2.setText(textField2.getText()+"8");
            }});
        a9Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"9");
                else
                    textField2.setText(textField2.getText()+"9");
            }});
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"+");
                else
                    textField2.setText(textField2.getText()+"+");
            }});
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"-");
                else
                    textField2.setText(textField2.getText()+"-");
            }
        });
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                    textField1.setText(textField1.getText()+"^");
                else
                    textField2.setText(textField2.getText()+"^");
            }
            });
        xButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1")
                        textField1.setText(textField1.getText()+"X");
                else
                    textField2.setText(textField2.getText()+"X");
                }
            });
        DELButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="Polinom 1"){
                    String s=textField1.getText();
                    if (s.length()>=1)
                        textField1.setText(s.substring(0, s.length() - 1));
                }
                else{
                    String s=textField2.getText();
                    if (s.length()>=1)
                        textField2.setText(s.substring(0, s.length() - 1));
                }
            }});
        CLEARButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }});
    };

    public String getOperatie(){
        if(comboBox2.getSelectedItem().toString()=="ADUNARE")
            return "ADUNARE";
        if(comboBox2.getSelectedItem().toString()=="SCADERE")
            return "SCADERE";
        if(comboBox2.getSelectedItem().toString()=="INMULTIRE")
            return "INMULTIRE";
        if(comboBox2.getSelectedItem().toString()=="IMPARTIRE")
            return "IMPARTIRE";
        if(comboBox2.getSelectedItem().toString()=="DERIVARE")
            return "DERIVARE";
        if(comboBox2.getSelectedItem().toString()=="INTEGRARE")
            return "INTEGRARE";
        return null;
    }
    public String getPolinomSelectat(){
        if(comboBox1.getSelectedItem().toString()=="Polinom 1")
            return "Polinom 1";
        else
            return "Polinom 2";
    }
    public String getPolinom1() {
        return textField1.getText();
    }
    public String getPolinom2() {
        return textField2.getText();
    }
    public void showRezultat(String rez) {
        textField3.setText(rez);
    }
    public void addCalculeazaListener(ActionListener calc){
        CALCULEAZAButton.addActionListener(calc);
    }

}
