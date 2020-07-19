import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.imageio.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;


class DisplayCharts extends JFrame
{
Container c;
JButton btnBack;


DisplayCharts()
{
DefaultCategoryDataset d1 = new DefaultCategoryDataset();
c = getContentPane();

setIconImage(Toolkit.getDefaultToolkit().getImage("growth.png"));
btnBack = new JButton("Back");
btnBack.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
btnBack.setBounds(170,220,120,30);

c.add(btnBack);

ActionListener e1 = (ae) -> {
MainFrameTest m = new MainFrameTest();
dispose();
};
btnBack.addActionListener(e1);

try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc123");

String sql = "select rno, name, marks1, marks2, marks3 from(select rno, name, marks1, marks2, marks3, (marks1 + marks2 + marks3) AS total from Student order by total desc) where rownum <= 3 order by total";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while(rs.next())
{
	d1.addValue(rs.getInt(3), rs.getString(2), "Subject1");
	d1.addValue(rs.getInt(4), rs.getString(2), "Subject2");
	d1.addValue(rs.getInt(5), rs.getString(2), "Subject3");
}
rs.close();
stmt.close();
con.close();
JFreeChart chart = ChartFactory.createBarChart("Students Performance", "Subject", "Marks", d1, PlotOrientation.VERTICAL, true, false, false);
ChartPanel cp = new ChartPanel(chart);
setContentPane(cp);

try
{
File marks = new File("Marks.jpeg");
ChartUtilities.saveChartAsJPEG(marks, chart, 500, 400);
}
catch(IOException e)
{
System.out.println(e);
}



setTitle("Student marks");
setSize(500, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
catch(SQLException se)
	{
		JOptionPane.showMessageDialog(new JDialog(), "se " + se);
	}
catch(Exception e)
	{
		JOptionPane.showMessageDialog(new JDialog(), "e" + e);
	}
}
}





