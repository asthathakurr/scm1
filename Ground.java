import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ground extends JFrame implements  ActionListener{
	private Whole whole;
	private JLabel jname;
	private  JLabel jemail;
	private JLabel jphone;
	private JLabel jcost;
	private JLabel jtime;
	private JTextField tname;
	private  JTextField temail;
	private JTextField tphone;
	private JTextField ttime;
	private JButton confrim;
	private JButton back;
	private JLabel notice;
	private JLabel background;

public Ground(Whole w){
	super("Ground Booking");
	this.whole=w;
	
	jname=new JLabel ("Name");
	jemail=new JLabel("Email");
	jphone=new JLabel("Phone");
	jcost=new  JLabel("*Fee= 200 tk/hr ");
	jtime=new JLabel("Time");
	confrim=new JButton("Confirm");
	back=new JButton("Back");
	tname=new JTextField();
	temail=new JTextField();
	tphone=new JTextField();
	ttime=new JTextField();
	notice=new JLabel();
	background=new JLabel(new ImageIcon("image/ground.jpg"));
	
	jcost.setForeground(Color.RED);
    notice.setForeground(Color.RED);

	jname.setBounds(100,50,40,40);
	jemail.setBounds(100,100,40,40);
	jphone.setBounds(100,150,40,40);
	jtime.setBounds(100,200,40,40);
	jcost.setBounds(350,10,250,30);
	tname.setBounds(140,50,250,40);
	temail.setBounds(140,100,250,40);
	tphone.setBounds(140,150,250,40);
	ttime.setBounds(140,200,250,40);
	confrim.setBounds(200,250,100,40);
	notice.setBounds(100,300,400,40);
	back.setBounds(10,300,70,40);
	background.setBounds(0,0,800,400);
	
	 confrim.addActionListener(this);
	 back.addActionListener(this);



	add(notice);
	add(jname);
	add(jemail);
	add(jphone);
	add(jcost);
	add(jtime);
	add(confrim);
	add(temail);
	add(tname);
	add(tphone);
	add(ttime);
	add(back);
	add(background);
		setSize(500,400);
		setLocation(100,100);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
       }
	
	public void actionPerformed(ActionEvent e){
		
		String s=e.getActionCommand();
		if(e.getActionCommand()=="Confirm"){
			DataAccess da=new DataAccess();
		if(!tname.getText().isEmpty() && !tphone.getText().isEmpty() && !temail.getText().isEmpty() && !ttime.getText().isEmpty()){
		String sql="INSERT INTO `tground` (`G_Name`, `G_Phone`, `G_Email`, `G_Time`) VALUES ('"+tname.getText()+"', '"+tphone.getText()+"','"+temail.getText()+"','"+ttime.getText()+"')";
		//System.out.println(sql);
		whole.first.setVisible(true);
		whole.ground.setVisible(false);
		notice.setText("");
		try{
			da.updateDB(sql);
		}
		catch(Exception ex){ ex.printStackTrace(); }
		
	}
	else
		notice.setText("*You havent typed anything in one/more field,fill it first*"); 
		
	}
	else{
		if(e.getActionCommand()=="Back"){whole.first.setVisible(true);
		whole.ground.setVisible(false); notice.setText("");}
		else{}
		
		
	}
	}
} 

	