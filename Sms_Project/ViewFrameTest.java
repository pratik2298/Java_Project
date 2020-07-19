import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

class ViewFrameTest extends JFrame {
Container c;

JTextArea taData;
JButton btnBack;

ViewFrameTest() {
c = getContentPane();
// c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
setIconImage(Toolkit.getDefaultToolkit().getImage("page-views.png"));

taData  = new JTextArea(60, 40);
taData.setBounds(20,0,450,200); 
btnBack = new JButton("Back");
btnBack.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
btnBack.setBounds(170,220,120,30);


c.add(taData);
c.add(btnBack);

ActionListener e1 = (ae) -> {
MainFrameTest m = new MainFrameTest();
dispose();
};
btnBack.addActionListener(e1);

HbHandler hb = new HbHandler();
String data = hb.getStudent();
taData.setText(data);






setTitle("View St.");
setSize(500, 300);
setLocationRelativeTo(null);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}


