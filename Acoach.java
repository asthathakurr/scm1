import javax.swing.*;

public class Acoach extends JFrame{
	private final Whole whole;
	private final JTextField 	tid;
	private final JTextField tname;
	private final JTextField texp;
	private final JTextField tnation;
	private final JTextField tcareer;
	private final JTextField tdob;
	private final JTextField ttime;
	private final JTextField tspe;
	private final JTextField tsal;
	private final JTextField tpass;

	public Acoach(Whole w){
		super("Add Coach");
		this.whole=w;
		
		tid=new JTextField();
		tname=new JTextField();
		texp=new JTextField();
		tnation=new JTextField();
		tcareer=new JTextField();
		tdob=new JTextField();
		ttime=new JTextField();
		tspe=new JTextField();
		tsal=new JTextField();
		tpass=new JTextField();

		JLabel jid = new JLabel("ID");
		JLabel jname = new JLabel("Name");
		JLabel jexp = new JLabel("Experience");
		JLabel jnation = new JLabel("Nationality");
		JLabel jcareer = new JLabel("Career info");
		JLabel jdob = new JLabel("DOB");
		JLabel jtime = new JLabel("Time");
		JLabel jspe = new JLabel("Speciality");
		JLabel jsal = new JLabel("Salary");
		JLabel jpass = new JLabel("Pass");
		JButton back = new JButton("Back");
		JButton logout = new JButton("Logout");
		JButton confirm = new JButton("Confirm");
		
		jid.setBounds(10,10,150,40);
		jname.setBounds(10,60,150,40);
		jexp.setBounds(10,110,150,40);
		jnation.setBounds(10,160,150,40);
		jcareer.setBounds(10,210,150,40);
		jdob.setBounds(10,260,150,40);
		jtime.setBounds(10,310,150,40);
		jspe.setBounds(10,360,150,40);
		jsal.setBounds(10,410,150,40);
		jpass.setBounds(10,460,150,40);
		
		tid.setBounds(170,10,250,40);
		tname.setBounds(170,60,250,40);
		texp.setBounds(170,110,250,40);
		tnation.setBounds(170,160,250,40);
		tcareer.setBounds(170,210,250,40);
		tdob.setBounds(170,260,250,40);
		ttime.setBounds(170,310,250,40);
		tspe.setBounds(170,360,250,40);
		tsal.setBounds(170,410,250,40);
		tpass.setBounds(170,460,250,40);
		confirm.setBounds(200,510,150,40);
		back.setBounds(10,570,100,40);
		logout.setBounds(370,570,120,40);
		
	   
	   
	   
	   add(jid);
	   add(jname);
	   add(jexp);
	   add(jnation);
	   add(jcareer);
	   add(jtime);
	   add(jdob);
	   add(jspe);
	   add(jsal);
	   add(jpass);
	   
	   add(tid);
	   add(tname);
	   add(texp);
	   add(tnation);
	   add(tcareer);
	   add(ttime);
	   add(tdob);
	   add(tspe);
	   add(tsal);
	   add(tpass);
	   add(confirm);
	   add(back);
	   add(logout);
	   
	   
	   back.addActionListener(e -> {
	   tid.setText("");
	   tname.setText("");
	   texp.setText("");
	   tnation.setText("");
	   tcareer.setText("");
	   tdob.setText("");
	   ttime.setText("");
	   tspe.setText("");
	   tsal.setText("");
	   tpass.setText("");
	   whole.acoach.setVisible(false);
	   whole.add.setVisible(true);

	   });
			
		
	   logout.addActionListener(e -> {
		 JOptionPane.showMessageDialog(null,"Logging out from Admin.If you have changed/add/delete any data it would be wise to restart the software");
		 tid.setText("");
		   tname.setText("");
		   texp.setText("");
		   tnation.setText("");
		   tcareer.setText("");
		   tdob.setText("");
		   ttime.setText("");
		   tspe.setText("");
		   tsal.setText("");
		   tpass.setText("");
		 whole.first.setVisible(true);
		 whole.acoach.setVisible(false);

	   });
			
		confirm.addActionListener(e -> {

		boolean number=false;

			try
		{
		int s=Integer.parseInt(tid.getText());
		int l=Integer.parseInt(texp.getText());
			number=true;
		}
		catch(NumberFormatException nfe)
		{ System.out.println("String");  }


		if(tid.getText().isEmpty() || tname.getText().isEmpty() || texp.getText().isEmpty() || tnation.getText().isEmpty() || tcareer.getText().isEmpty() || tdob.getText().isEmpty() || ttime.getText().isEmpty() || tspe.getText().isEmpty() || tsal.getText().isEmpty() || tpass.getText().isEmpty())
			JOptionPane.showMessageDialog(null,"A Field is Empty try again!");

		else{
			if(!number || (tid.getText()).charAt(0) != '1' || (tid.getText()).length()!=4)
				JOptionPane.showMessageDialog(null,"Coach id must be a integer and four length long and Start with 1. (ex:1xxx) also only put Experience  time > int value (ex.10)");
			else
			{
				int chck=whole.buffercoach.getcid(tid.getText());
						  if( chck!=999)
						   {
							   JOptionPane.showMessageDialog(null,"Id for coach already exist");
						   }
						   else
						   { DataAccess da=new DataAccess();


							 try{
								da.updateDB("INSERT INTO `coach` (`C_id`, `C_Name`, `C_Experience`, `C_Nationality`, `C_Career info`, `C_DOB`, `C_Time`, `C_Speciality`, `C_Salary`, `C_Password`) VALUES ('"+tid.getText()+"', '"+tname.getText()+"', '"+texp.getText()+"', '"+tnation.getText()+"', '"+tcareer.getText()+"', '"+tdob.getText()+"', '"+ttime.getText()+"', '"+tspe.getText()+"', '"+tsal.getText()+"', '"+tpass.getText()+"');");
								da.updateDB("INSERT INTO `odi` (`ID`, `MATCHES`, `RUNS`, `50s`, `100s`, `HIGHEST SCORE`, `INNINGS`, `WICKETS`, `BEST FIGURE`, `5W`, `ECO RATE`, `CATCHES`) VALUES ('"+tid.getText()+"', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')");
								da.updateDB("INSERT INTO `t20` (`ID`, `MATCHES`, `RUNS`, `50s`, `100s`, `HIGHEST SCORE`, `INNINGS`, `WICKETS`, `BEST FIGURE`, `5W`, `ECO RATE`, `CATCHES`) VALUES ('"+tid.getText()+"', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')");
								da.updateDB("INSERT INTO `test` (`ID`, `MATCHES`, `RUNS`, `50s`, `100s`, `HIGHEST SCORE`, `INNINGS`, `WICKETS`, `BEST FIGURE`, `5W`, `ECO RATE`, `CATCHES`) VALUES ('"+tid.getText()+"', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')");
								System.out.println("ok");
								whole.buffercoach.loadcoach();
								}
							catch(Exception ex){ ex.printStackTrace();}
							tid.setText("");
							tname.setText("");
							texp.setText("");
							tnation.setText("");
							tcareer.setText("");
							tdob.setText("");
							ttime.setText("");
							tspe.setText("");
							tsal.setText("");
							tpass.setText("");
							JOptionPane.showMessageDialog(null,"Done!");

							}
			}
		}



		});
		
		
	
		setSize(540,700);
		setLocation(100,100);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
 
	}

}
