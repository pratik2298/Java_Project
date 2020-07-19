import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

class DeleteFrameTest extends JFrame {
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave, btnBack;

DeleteFrameTest() {
c = getContentPane();
// c.setLayout(new FlowLayout());
setIconImage(Toolkit.getDefaultToolkit().getImage("delete.png"));

lblRno = new JLabel("enter rno :");
lblRno.setFont(new Font("Calibri", Font.BOLD, 20));
lblRno.setBounds(135, 25, 100, 50);
txtRno = new JTextField(15);
txtRno.setBounds(60, 75, 250, 25);

btnSave = new JButton("Save");
btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
btnSave.setBounds(120, 120, 140, 30);

btnBack = new JButton("Back");
btnBack.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
btnBack.setBounds(120, 160, 140, 30);


ActionListener e1 = (ae) -> {
MainFrameTest m = new MainFrameTest();
dispose();
};
btnBack.addActionListener(e1);

ActionListener e2 = (ae) -> {
try
{
String roll = txtRno.getText().toString();
if(roll.isEmpty())
	JOptionPane.showMessageDialog(c, "Roll no cannot be empty");
int rno = Integer.parseInt(roll);
if(rno < 0)
	JOptionPane.showMessageDialog(c, "Negative Rollno is Invalid");

else
{
HbHandler hb = new HbHandler();
hb.delStudent(rno);
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the data");
}
};
btnSave.addActionListener(e2);

c.add(lblRno);
c.add(txtRno);
c.add(btnSave);
c.add(btnBack);


setTitle("Delete St.");
setSize(400, 500);
setLocationRelativeTo(null);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

