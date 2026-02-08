/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author omare
 */
public class Calculator implements ActionListener {

    JFrame frame;
    
    JTextField textfield;
    
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    
    JPanel panel;
    
    Font myfont = new Font("Ink Free" ,Font.BOLD,30);
            
    double Num1=0, Num2=0, Result=0;
    char operator;
            
    Calculator(){
        
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        
        for(int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }
        
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430,145, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Calculator Calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        
        if(e.getSource() == decButton){
                textfield.setText(textfield.getText().concat("."));
            }
        
        if(e.getSource() == addButton){
                Num1 = Double.parseDouble(textfield.getText());
                operator = '+';
                textfield.setText("");
            }
        
        if(e.getSource() == subButton){
                Num1 = Double.parseDouble(textfield.getText());
                operator = '-';
                textfield.setText("");
            }
        
        if(e.getSource() == mulButton){
                Num1 = Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
            }
        
        if(e.getSource() == divButton){
                Num1 = Double.parseDouble(textfield.getText());
                operator = '/';
                textfield.setText("");
            }
        
        if(e.getSource() == equButton){
                Num2 = Double.parseDouble(textfield.getText());
                
                switch(operator){
                    case'+':
                        Result = Num1 + Num2;
                        break;
                        
                    case'-':
                        Result = Num1 - Num2;
                        break;
                        
                    case'*':
                        Result = Num1 * Num2;
                        break;
                        
                    case'/':
                        Result = Num1 / Num2;
                        break;
                }
                textfield.setText(String.valueOf(Result));
                Num1 = Result; 
            }
        
        if(e.getSource() == clrButton){
                textfield.setText("");
            }
        
        if(e.getSource() == delButton){
            String string = textfield.getText();
                textfield.setText("");
                for(int i=0; i < string.length()-1; i++){
                    textfield.setText(textfield.getText()+string.charAt(i));
                }
            }

    }
    
}
