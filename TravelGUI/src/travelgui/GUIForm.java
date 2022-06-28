package travelgui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIForm extends JFrame{
    public static final int width=400;
    public static final int height=420;
    
    private Calculations calc=new Calculations();
    private JLabel lblTitle;
    private JLabel lblmtod;
    private JLabel lblmpg;
    private JLabel lblgp;
    private JLabel lblparking;
    private JLabel lbltolls;
    private JLabel lblresult;
    
    private JTextField txtmtod;
    private JTextField txtmpg;
    private JTextField txtgp;
    private JTextField txtparking;
    private JTextField txttolls;
    private JTextField txtresult;
    
    private JButton btnCalculate;
    private JButton btnClear;
    
    private JMenuBar mb;
    private JMenu f;
    private JMenu e;
    private JMenuItem calcu;
    private JMenuItem salir;
    
    Calculations c;
    public GUIForm()
    {
        super();
        createPanel();
        setFrame();
    }
    
    private void createPanel()
    {
        //GridLayout theGrid=new GridLayout(0,2);
        super.setLayout(null);
        
        lblTitle=new JLabel("TRAVEL COST APP");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(JTextField.CENTER);
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBounds(100, 20, 200, 30);
        this.add(lblTitle);
        
        mb=new JMenuBar();
        f=new JMenu("File");
        e=new JMenu("Edit");
        
        calcu=new JMenuItem("Calculate");
        calcu.addActionListener(new Calculate());
        salir=new JMenuItem("Clear");
        salir.addActionListener(new Clear());
        
        f.add(calcu);
        e.add(salir);
        mb.add(f);
        mb.add(e);
        this.setJMenuBar(mb);
        
        lblmtod=new JLabel("Miles to Drive : ");
        txtmtod=new JTextField(20);
        lblmtod.setHorizontalAlignment(JTextField.RIGHT);
        lblmtod.setBounds(100, 70, 100,25);
        txtmtod.setBounds(200, 70, 100,25);
        this.add(lblmtod);
        this.add(txtmtod);
        
        lblmpg=new JLabel("Mile per gallon : ");
        txtmpg=new JTextField(20);
        lblmpg.setHorizontalAlignment(JTextField.RIGHT);
        lblmpg.setBounds(100, 105, 100,25);
        txtmpg.setBounds(200, 105, 100,25);
        this.add(lblmpg);
        this.add(txtmpg);
        
        lblgp=new JLabel("Gasoline Price : ");
        txtgp=new JTextField(20);
        lblgp.setHorizontalAlignment(JTextField.RIGHT);
        lblgp.setBounds(100, 140, 100,25);
        txtgp.setBounds(200, 140, 100,25);
        this.add(lblgp);
        this.add(txtgp);
        
        lblparking=new JLabel("Parking Cost : ");
        txtparking=new JTextField(20);
        lblparking.setHorizontalAlignment(JTextField.RIGHT);
        lblparking.setBounds(100, 175, 100,25);
        txtparking.setBounds(200, 175, 100,25);
        this.add(lblparking);
        this.add(txtparking);
        
        lbltolls=new JLabel("Tolls Cost : ");
        txttolls=new JTextField(20);
        lbltolls.setHorizontalAlignment(JTextField.RIGHT);
        lbltolls.setBounds(100, 210, 100,25);
        txttolls.setBounds(200, 210, 100,25);
        this.add(lbltolls);
        this.add(txttolls);
        
        btnCalculate=new JButton("Calculate");
        btnCalculate.addActionListener(new Calculate());
        btnCalculate.setBounds(80, 250, 100, 25);
        this.add(btnCalculate);
        
        btnClear=new JButton("Clear");
        btnClear.addActionListener(new Clear());
        btnClear.setBounds(210, 250, 100, 25);
        this.add(btnClear);     

        lblresult=new JLabel("Result : ");
        lblresult.setHorizontalAlignment(JTextField.RIGHT);
        txtresult=new JTextField(20);
        txtresult.setBackground(Color.decode("#90EE90"));
        lblresult.setBounds(100, 300, 100,25);
        txtresult.setBounds(200, 300, 100,25);
        txtresult.setEditable(false);
        this.add(lblresult);
        this.add(txtresult);
    }
    
    private void setFrame()
    {
        Image icon = Toolkit.getDefaultToolkit().getImage("car.png"); 
        super.setIconImage(icon);
        super.setTitle("Travel Cost App ver. 2.0");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocation(200, 100);
        super.setResizable(false);
        super.setSize(width, height);
        super.setVisible(true);
    }
    
    private class Calculate implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double mtod=Double.parseDouble(txtmtod.getText());
            double mpg=Double.parseDouble(txtmpg.getText());
            double gp=Double.parseDouble(txtgp.getText());
            double p=Double.parseDouble(txtparking.getText());
            double t=Double.parseDouble(txttolls.getText());
            Double r=calc.getResult(mtod, mpg, gp, p, t);
            String str2 = String.format("$ %8.2f", r);
            txtresult.setText(str2);
        }
    }private class Clear implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            txtmtod.setText("");
            txtmpg.setText("");
            txtgp.setText("");
            txtparking.setText("");
            txttolls.setText("");
            txtresult.setText("");
            txtmtod.requestFocus();
        }
    }
}
