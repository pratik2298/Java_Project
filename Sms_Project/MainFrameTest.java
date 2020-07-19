import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;


class MainFrameTest extends JFrame {
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts;

MainFrameTest() {
c = getContentPane();
setIconImage(Toolkit.getDefaultToolkit().getImage("home.png"));
        
btnAdd = new JButton("Add");
btnAdd.setBounds(10, 50, 180, 30);
btnAdd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));

btnView = new JButton("View");
btnView.setBounds(200, 50, 180, 30);
btnView.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));

btnUpdate = new JButton("Update");
btnUpdate.setBounds(10, 130, 180, 30);
btnUpdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));

btnDelete =  new JButton("Delete");
btnDelete.setBounds(200, 130, 180, 30);
btnDelete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));

btnCharts = new JButton("Charts");
btnCharts.setBounds(100, 200, 180, 30);
btnCharts.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));


// AddFrameTest
ActionListener e1 = (ae) -> {
AddFrameTest af = new AddFrameTest();
dispose();
};
btnAdd.addActionListener(e1);

// ViewFrameTest
ActionListener e2 = (ae) -> {
ViewFrameTest vf = new ViewFrameTest();
dispose();
};
btnView.addActionListener(e2);


// UpdateFrameTest
ActionListener e3 = (ae) -> {
UpdateFrameTest uf = new UpdateFrameTest();
dispose();
};
btnUpdate.addActionListener(e3);


// DeleteFrameTest
ActionListener e4  = (ae) -> {
DeleteFrameTest df = new DeleteFrameTest();
dispose();
};
btnDelete.addActionListener(e4);


// DisplayCharts
ActionListener e5  = (ae) -> {
DisplayCharts dc = new DisplayCharts();
dispose();
};
btnCharts.addActionListener(e5);


// Adding to Conatiner
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnCharts);


setTitle("S.M.S");
setSize(400, 500);
setLocationRelativeTo(null);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

