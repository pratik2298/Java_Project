import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class AddFrameTest extends JFrame {
Container c;
JLabel lblRno, lblName, lblMarks1, lblMarks2, lblMarks3;
JTextField txtRno, txtName, txtMarks1, txtMarks2, txtMarks3;
JButton btnSave, btnBack;

AddFrameTest() {
c = getContentPane();
setIconImage(Toolkit.getDefaultToolkit().getImage("add.png"));

lblRno = new JLabel("enter rno :");
lblRno.setFont(new Font("Calibri", Font.BOLD, 20));
lblRno.setBounds(135, 25, 100, 50);
txtRno = new JTextField(15);
txtRno.setBounds(60, 70, 250, 25);

lblName = new JLabel("enter name:");
lblName.setFont(new Font("Calibri", Font.BOLD, 20));
lblName.setBounds(135,120, 150, 20);
txtName = new JTextField(15);
txtName.setBounds(60, 145, 250, 25);

lblMarks1 = new JLabel("enter sub marks 1 :");
lblMarks1.setFont(new Font("Calibri", Font.BOLD, 20));
lblMarks1.setBounds(120, 200, 220, 20);
txtMarks1 = new JTextField(15);
txtMarks1.setBounds(60, 225, 250, 25);

lblMarks2 = new JLabel("enter sub marks 2 :");
lblMarks2.setFont(new Font("Calibri", Font.BOLD, 20));
lblMarks2.setBounds(120, 280, 220, 20);
txtMarks2 = new JTextField(15);
txtMarks2.setBounds(60, 308, 250, 25);

lblMarks3 = new JLabel("enter sub marks 3 :");
lblMarks3.setFont(new Font("Calibri", Font.BOLD, 20));
lblMarks3.setBounds(120, 360, 220, 20);
txtMarks3 = new JTextField(15);
txtMarks3.setBounds(60, 385, 250, 25);

btnSave = new JButton("Save");
btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
btnSave.setBounds(120, 440, 140, 30);

btnBack = new JButton("Back");
btnBack.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
btnBack.setBounds(120, 500, 140, 30);

ActionListener e1 = (ae) -> {
try
{
String roll = txtRno.getText().toString();
String name = txtName.getText().toString();
String m1 = txtMarks1.getText().toString();
String m2 = txtMarks2.getText().toString();
String m3 = txtMarks3.getText().toString();


if((roll.isEmpty()) || (m1.isEmpty()) || (m2.isEmpty()) || (m3.isEmpty()))
JOptionPane.showMessageDialog(c, "fields  cannot be empty");
if(name.equals(null))
JOptionPane.showMessageDialog(c, "name cannot be cannot be empty");

int rno = Integer.parseInt(roll);
int marks1 = Integer.parseInt(m1);
int marks2 = Integer.parseInt(m2);
int marks3 = Integer.parseInt(m3);

if(rno < 0)
JOptionPane.showMessageDialog(c, "Roll no cannot be negative");
else if(name.isEmpty())
	JOptionPane.showMessageDialog(c, "fields  cannot be empty");
else if(name.length() == 1 )
	JOptionPane.showMessageDialog(c, "Single letter name is invalid");



if((marks1 < 0) || (marks1 > 100))
	JOptionPane.showMessageDialog(c, "Marks1 must be in range of 0 to 100");
if((marks2 < 0) || (marks2 > 100))
	JOptionPane.showMessageDialog(c, "Marks1 must be in range of 0 to 100");
if((marks3 < 0) || (marks3 > 100))
	JOptionPane.showMessageDialog(c, "Marks1 must be in range of 0 to 100");

Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\][0-9]~]");
Matcher m = p.matcher(name);
boolean b = m.find();

if(b)
	JOptionPane.showMessageDialog(c, "Name must Contain Alphabets only");
else if(!(name.isEmpty()) && (rno > 0)  && (name.length()>1) && ((marks1 >= 0) && (marks1 <= 100)) && ((marks2 >= 0) && (marks2 <= 100)) && ((marks3 >= 0) && (marks3 <= 100)))
{
HbHandler hb = new HbHandler();
hb.addStudent(rno, name, marks1, marks2, marks3);
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the data");
}
};
btnSave.addActionListener(e1);




ActionListener e2 = (ae) -> {
MainFrameTest m = new MainFrameTest();
dispose();
};
btnBack.addActionListener(e2);




c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblMarks1);
c.add(txtMarks1);
c.add(lblMarks2);
c.add(txtMarks2);
c.add(lblMarks3);
c.add(txtMarks3);
c.add(btnSave);
c.add(btnBack);


setTitle("Add St.");
setSize(400, 700);
setLocationRelativeTo(null);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}






        
