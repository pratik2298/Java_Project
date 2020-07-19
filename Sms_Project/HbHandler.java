import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

class HbHandler extends JFrame
{
public static void addStudent(int rno, String name, int marks1, int marks2, int marks3)
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();

Session session = null;
Transaction t = null;
try {
	session = sfact.openSession();
	System.out.println("Open");
	t = session.beginTransaction();
	
	Student stu = new Student();
	stu.setRno(rno);
	Student s = (Student)session.get(Student.class, rno);
	if(s != null)
	{
		stu.setRno(rno);
		stu.setName(name);
		stu.setMarks1(marks1);
		stu.setMarks2(marks2);
		stu.setMarks3(marks3);
		session.save(stu);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(), "Record Added");
	}
	else
	{
		JOptionPane.showMessageDialog(new JDialog(), " " + "Roll No "+ rno + " Already Exist");
	}
}
catch(Exception e) {
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(), " "+ "Roll No " + rno + " Already Exist");
}
finally {
	session.close();
	System.out.println("close");
}
}

public static String getStudent()
{
	String data = "";
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sfact = cfg.buildSessionFactory();
	Session session = null;
	 Transaction t = null;

try {
	session = sfact.openSession();
	System.out.println("Open");
	 t = session.beginTransaction();
	
	List<Student> stu = new ArrayList<>(); 
	stu = session.createQuery("from Student").list();
	for(Student s : stu)
		data = data + " Rollno :  " + s.getRno()  + "   "  +  "  Name :  " + s.getName()  + "   "  +    " Subject1 :  " +  s.getMarks1()  + "   "  +    " Subject2:  " + s.getMarks2()  + "   "  + " Subject3:  " + s.getMarks3() + "\n";

}
catch(Exception e) 
{
t.rollback();
JOptionPane.showMessageDialog(new JDialog(), "issue");
}
finally{
System.out.println("Close");
}
return data;
} 
// end of getStudent

public static void delStudent(int rno)
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;

try {
	session = sfact.openSession();
	System.out.println("open");
	t = session.beginTransaction();
	Student stu = new Student();
	stu.setRno(rno);
	Student s = (Student)session.get(Student.class, rno);
if(s != null)
	{
		session.delete(s);
		 t.commit();
		 JOptionPane.showMessageDialog(new JDialog(), "Record Deleted");
	} 
	else
		 JOptionPane.showMessageDialog(new JDialog(), "  "  + rno  +  " does not exist");
}
catch(Exception e)  {
	t.rollback();
	System.out.println("issues" + e);
}
finally {
		System.out.println("close");
}
}


// Update Student()
public static void updateStudent(int rno, String name, int marks1, int marks2, int marks3)
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();

Session session = null;
Transaction t = null;

try {
	session = sfact.openSession();
	System.out.println("open");
	t = session.beginTransaction();
	Student stu = new Student();
	stu.setRno(rno);
	Student s = (Student)session.get(Student.class, rno);
if(s != null)
	{
		s.setName(name);
		s.setMarks1(marks1);
		s.setMarks2(marks2);
		s.setMarks3(marks3);
		session.save(s);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(), "Record Updated");
}
else
	{
		JOptionPane.showMessageDialog(new JDialog(), " " + rno + " does not exist");
}
}
catch(Exception e) {
	t.rollback();
	System.out.println("issue" + e);
}
finally {
	session.close();
	System.out.println("close");
}
}





} // end of HbHandler	