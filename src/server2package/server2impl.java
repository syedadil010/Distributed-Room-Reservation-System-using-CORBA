package server2package;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

import org.omg.CORBA.ORB;

import corbamodule.commonPOA;
import server1package.server1interface;

import server2package.server2interface;
import server2package.threadlistner;
import server2package.threadsender2;
import server3package.server3interface;
import server3package.threadsender3;
public class server2impl extends commonPOA 
{
	
	static HashMap<String,HashMap<String,String>> b=new HashMap<String,HashMap<String,String>>();
	static HashMap<String,String> c=new HashMap<String,String>();   
	static HashMap<String,HashMap<String,HashMap<String,String>>> a=new HashMap<String,HashMap<String,HashMap<String,String>>>();
	static HashMap<String,ArrayList<String>> d=new HashMap<String,ArrayList<String>>();
	static ArrayList<String> e=new ArrayList<String>();
	String bookingid;
	double w1;
	int i=0;
	String date;
	String rno;
	String timeslot;
	server1interface si1;
	server3interface si3;
	public static String fcount;
	private ORB orb;	
	 

	public server2impl() 
	{
		super();
	}  
	public void setORB(ORB orb_val) {
	orb = orb_val; 
	  }
	public String localcount(String date)
	{
		int lcount=0;
		String s3="Available"; 
		if(!a.isEmpty())
		{
			Set<String> set= a.get(date).keySet();
			Iterator it=set.iterator();
			while(it.hasNext())
			{
				String s =(String)it.next();
				Set<String> set1 =	a.get(date).get(s).keySet();
				Iterator it1 =set1.iterator();
				while(it1.hasNext())
				{
					String s1=(String)it1.next();
					if(s3.equals(a.get(date).get(s).get(s1)))
					{
						System.out.println(s3.equals(a.get(date).get(s).get(s1)));
						
							System.out.println(lcount);
						
						lcount++;
						System.out.println(lcount);
						}
				}
	
			}
		}
		String s=Integer.toString(lcount);
		return s;
	}
	
	public boolean createroom(String rno,String date,String timeslot)
	{
		
		/*Set<String> setr=b.keySet();
		Set<String> sett=c.keySet();
		Set<String> setd=a.keySet();
		Iterator ir=setr.iterator();
		Iterator it=sett.iterator();
		Iterator id=setd.iterator();
		while(id.hasNext())
		{
			String m=(String )id.next();
		if(m.equals(date))
		{
		while(ir.hasNext())
		{	
			String s=(String)ir.next();
			System.out.println(s);
			if(s.equals(rno))
				{
				System.out.println("in if");
				System.out.println(s);
				System.out.println(rno);
				
					while(it.hasNext())
					{
		                String s1=(String)it.next();
						if(s1.equals(timeslot))
						{
							System.out.println("Timeslot Already Exists");
						return false;
						}
					}
			}
		}
		}	
		}*/
		if(a.isEmpty())
		{
				a.put(date, new HashMap<String,HashMap<String,String>>());
				a.get(date).put(rno, new HashMap<String,String>());
				a.get(date).get(rno).put(timeslot,"Available");
				//b.put(rno,c);
			//	a.put(date,b);
				System.out.println(a);
				return true;
		}
		else
		{
			Set<String> setd= a.keySet();
			Iterator itd=setd.iterator();
			while(itd.hasNext())
			{
				String s1=(String)itd.next();
				if(date.equals(s1))
				{
					Set<String> setr =	a.get(date).keySet();
					Iterator itr =setr.iterator();
					while(itr.hasNext())
					{
						String s2=(String)itr.next();
						if(rno.equals(s2))
						{
							Set<String> sett =	a.get(date).get(rno).keySet();
							Iterator itt =setr.iterator();
							while(itt.hasNext())
							{
								String s3=(String)itt.next();
								if(timeslot.equals(s3))
								{
									System.out.println("Timeslot already exists");
									System.out.println(a);
									return false;
									
								}
							}
							a.get(date).get(rno).put(timeslot,"Available");
							System.out.println(a);
							return true;
						}
					}
					a.get(date).put(rno,new HashMap<String,String>());
					a.get(date).get(rno).put(timeslot,"Available");
					System.out.println(a);
					return true;
				}
			}	
			a.put(date, new HashMap<String,HashMap<String,String>>());
			a.get(date).put(rno, new HashMap<String,String>());
			a.get(date).get(rno).put(timeslot,"Available");
			System.out.println(a);
			return true;
		}				
			
		/*try {	
				FileOutputStream fos = new FileOutputStream("src/admin.txt",true);
			    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
			    outStream.write(System.getProperty("line.separator").getBytes());
				
			      Date date1 = new Date();
			      outStream.writeUTF(date1.toString());
				outStream.writeUTF(date);
				 
				 outStream.writeUTF(rno);
				 outStream.writeUTF(timeslot);
				 outStream.writeUTF("Available(room created)");
				 
				 outStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}*/
		
	}	
	public boolean deleteroom(String rno, String date, String timeslot)
	{
		
		a.get(date).get(rno).remove(timeslot);
		try
		{
		FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    outStream.write(System.getProperty("line.separator").getBytes());
	    Date date1 = new Date();
	      outStream.writeUTF(date1.toString());
	    outStream.writeUTF(date);
		 outStream.writeUTF(rno);
		 outStream.writeUTF(timeslot);
		 outStream.writeUTF("(room deleted)");
		 outStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return true;
	}
	public synchronized String bookroom(String campusName,String rno,String date,String timeslot,String UID)
	{
		int i=0;
		  
			if(d.isEmpty())
			{  
				d.put(UID,new ArrayList<String>());	
				System.out.println("in 1st if");
			}
			Set<String> set=d.keySet();
			Iterator it=set.iterator();
			while(it.hasNext())
			{
			
				String s=(String)it.next();
			
				if(UID.equals(s))
				{
					i++;
					System.out.println("in 2st if");
				}
			}
			if(i==0)
			{   
				d.put(UID,new ArrayList<String>());
				i=0;
				System.out.println("in 3rd if");
			}
			
			if(d.get(UID).size()>3)
			{	System.out.println("You have reached the booking limit already");
			try
			{
			FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
		    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
		    FileOutputStream dos = new FileOutputStream("src/server2client.txt",true);
		    DataOutputStream inStream = new DataOutputStream(new BufferedOutputStream(dos));
		    outStream.write(System.getProperty("line.separator").getBytes());
		    Date date1 = new Date();
		      outStream.writeUTF(date1.toString());
		    outStream.writeUTF("room booking failed  in KKL");
		    outStream.writeUTF(date);
		    
			 outStream.writeUTF(rno);
			 outStream.writeUTF(timeslot);
			 outStream.writeUTF(UID);
			// outStream.writeUTF();
			 outStream.close();
			 inStream.write(System.getProperty("line.separator").getBytes());
			 inStream.writeUTF(date1.toString());
			    inStream.writeUTF("room booking failed  in KKL");
			    inStream.writeUTF(date);
			    
				 inStream.writeUTF(rno);
				 inStream.writeUTF(timeslot);
				 inStream.writeUTF(UID);
				 inStream.close();
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
				return "limit reached";
			}
			else
			{
				System.out.println("in else part");
				System.out.println(a);
				if(campusName.equals(new String("KKL")))
				{
					if(a.get(date).get(rno).get(timeslot).equals("Available"))
					{
						bookingid = UUID.randomUUID().toString();
						a.get(date).get(rno).put(timeslot,bookingid);
						System.out.println(a);
						System.out.println("booked");
					}
					else
					{
						System.out.println("its already booked");
						return "its already booked";
					}
					try
					{
					FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
				    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
				    FileOutputStream dos = new FileOutputStream("src/server2client.txt",true);
				    DataOutputStream inStream = new DataOutputStream(new BufferedOutputStream(dos));
				    outStream.write(System.getProperty("line.separator").getBytes());
				    Date date1 = new Date();
				      outStream.writeUTF(date1.toString());
				    outStream.writeUTF("room booked in KKL");
				    outStream.writeUTF(date);
				    
					 outStream.writeUTF(rno);
					 outStream.writeUTF(timeslot);
					 outStream.writeUTF(UID);
					 outStream.close();
					    inStream.write(System.getProperty("line.separator").getBytes());
					 inStream.writeUTF(date1.toString());
					    inStream.writeUTF("room booked in KKL");
					    inStream.writeUTF(date);
					    
						 inStream.writeUTF(rno);
						 inStream.writeUTF(timeslot);
						 inStream.writeUTF(UID);
						 inStream.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e);
					}
					catch(IOException e)
					{
						System.out.println(e);
					}
				}
			else if(campusName.equals(new String("DVL")))
				{
					
				String s1=new String("DVL");
				String s2=new String(date);
				String s3=new String(rno);
				String s4=new String(timeslot);
				String s5=new String(UID);
				String s7=new String("BR");
				String s6 =new String();
			   s6=s6.concat(s1);
				s6=s6.concat(s2);
				s6=s6.concat(s3);
				s6=s6.concat(s4);
				s6=s6.concat(s5);
				s6=s6.concat(s7);
				threadsender2 ts1=new threadsender2(s6,4000);
				Thread t1=new Thread(ts1);
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Returned value from DVL"+ts1.dstring);
				bookingid=ts1.dstring.substring(0,36);
				try
					{
					FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
				    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
				    outStream.write(System.getProperty("line.separator").getBytes());
				    outStream.writeUTF("room booked in DVL");
				    Date date1 = new Date();
				      outStream.writeUTF(date1.toString());
				    outStream.writeUTF(date);
				    
					 outStream.writeUTF(rno);
					 outStream.writeUTF(timeslot);
					 outStream.writeUTF(UID);
					 outStream.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e);
					}
					catch(IOException e)
					{
						System.out.println(e);
					}
				}
				else if(campusName.equals(new String("WST")))
				{
					String s1=new String("WST");
					String s2=new String(date);
					String s3=new String(rno);
					String s4=new String(timeslot);
					String s5=new String(UID);
					String s7=new String("BR");
					String s6 =new String();
				   s6=s6.concat(s1);
					s6=s6.concat(s2);
					s6=s6.concat(s3);
					s6=s6.concat(s4);
					s6=s6.concat(s5);
					s6=s6.concat(s7);
					threadsender2 ts2=new threadsender2(s6,4002);
					Thread t2=new Thread(ts2);
					t2.start();
					try {
						t2.join();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Returned value from WST"+ts2.dstring);
					bookingid=ts2.dstring.substring(0,36);
				try
					{
					FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
				    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
				    outStream.write(System.getProperty("line.separator").getBytes());
				    outStream.writeUTF("room booked in WST");
				    Date date1 = new Date();
				      outStream.writeUTF(date1.toString());
				    outStream.writeUTF(date);
				    
					 outStream.writeUTF(rno);
					 outStream.writeUTF(timeslot);
					 outStream.writeUTF(UID);
					 outStream.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e);
					}
					catch(IOException e)
					{
						System.out.println(e);
					}
				}
			}
			if(d.get(UID).equals(new String("UID")))
			{	d.get(UID).remove(0);
			}
			d.get(UID).add((bookingid));
			System.out.println(d);
	return bookingid;
	}
		
		
	
	public synchronized String getAvailableTimeSlot ( String date)
	{	
	
		int count1=0,count2=0;
		int sc1=0,sc2=0,sc3=0;
		String s3="Available";
		String cou1=localcount(date);
		/*if(!a.isEmpty())
		{  
			
			Set<String> set= a.get(date).keySet();
		Iterator it=set.iterator();
		while(it.hasNext())
		{
		String s =(String)it.next();
		Set<String> set1 =	a.get(date).get(s).keySet();
		Iterator it1 =set1.iterator();
		while(it1.hasNext())
		{
			String s1=(String)it1.next();
			if(s3.equals(a.get(date).get(s).get(s1)))
			{
				cou++;
			}
		}
		}}*/
		System.out.println("local count of KKL  "+cou1);
		threadsender2 ts1=new threadsender2(date,4000); 
		threadsender2 ts2=new threadsender2(date,4002);
		Thread t1=new Thread(ts1);
		Thread t2=new Thread(ts2);
		
		t1.start();
		t2.start();
		String j=new String("");
		String k=new String("");
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		j=ts1.dstring;
		j=j.substring(0,1);
		System.out.println("After j in DVL and the value from KKL is  "+j);
		k=ts2.dstring;
		k=k.substring(0,1);
		System.out.println("After K in DVL and the value from KKL is  "+k);	
		//String z=Integer.toString(cou);
			String z=cou1;
		try
		{
		FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    FileOutputStream dos = new FileOutputStream("src/server2client.txt",true);
	    DataOutputStream inStream = new DataOutputStream(new BufferedOutputStream(dos));
	    outStream.write(System.getProperty("line.separator").getBytes());
	    Date date1 = new Date();
	      outStream.writeUTF(date1.toString());
	    outStream.writeUTF(date);
	    outStream.writeUTF(z);
	    outStream.writeUTF("KKL count");
	    outStream.writeUTF(j);
	    outStream.writeUTF("DVL count ");
	    outStream.writeUTF(k);
	    outStream.writeUTF("WST count ");
		 outStream.close();
		 inStream.write(System.getProperty("line.separator").getBytes());
		 inStream.writeUTF(date1.toString());
		    inStream.writeUTF(date);
		    inStream.writeUTF(z);
		    inStream.writeUTF("KKL count");
		    inStream.writeUTF(j);
		    inStream.writeUTF("DVL count ");
		    inStream.writeUTF(k);
		    inStream.writeUTF("WST count ");
		    inStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
      return "KKL("+z+")  "+"DVL("+j+")  "+"WST("+k+")";
		
}
	  
	  public synchronized String  cancelBooking (String bookingID, String userid)
	  {
		  	int c=0;
			String s3=bookingID;
			Set<String> set= a.keySet();
			Iterator it=set.iterator();
			while(it.hasNext())
			{
				String s =(String)it.next();
				Set<String> set1 =	a.get(s).keySet();
				Iterator it1 =set1.iterator();
				while(it1.hasNext())
				{
					String s1=(String)it1.next();
					Set<String> set2=a.get(s).get(s1).keySet();
					Iterator it2=set2.iterator();
					while(it2.hasNext())
					{
						String s2=(String)it2.next();
						if(s3.equals(a.get(s).get(s1).get(s2)));
						{	
							Set<String> setb= d.keySet();
							Iterator idb=setb.iterator();
							while(idb.hasNext())
							{
								
								String s9=(String)idb.next();
								System.out.println(s9+" s9");
								System.out.println(d.get(s9)+" d.get(s9)");
								//System.out.println(d.get(s9).get(1)+" d.get(s9).get(1)");
								
								Iterator setn1=d.get(s9).iterator();
								while(setn1.hasNext())
								{
									String sn1=(String)setn1.next();
									if((s9.equals(userid)) && sn1.equals(bookingID))
			  					{	
										a.get(s).get(s1).put(s2,"Available");
										System.out.println(a);
									a.get(s).get(s1).put(s2,"Available");
									System.out.println(bookingID);
									System.out.println(a);
									//roomcount++;
									System.out.println("Booking cancellation was successful");
									Set<String> set3= d.keySet();
									Iterator it3=set3.iterator();
									while(it3.hasNext())
									{
										String s4=(String)it3.next();
										for(i=0;i<e.size();i++)
										{
											if(bookingID.equals(d.get(s4).get(i)))
											d.get(s4).remove(i);
											try
											{
												FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
												DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
												FileOutputStream dos = new FileOutputStream("src/server2client.txt",true);
												DataOutputStream inStream = new DataOutputStream(new BufferedOutputStream(dos));
												outStream.write(System.getProperty("line.separator").getBytes());
												Date date1 = new Date();
												outStream.writeUTF(date1.toString());
												outStream.writeUTF(s4);
												outStream.writeUTF("cancelled room");
												outStream.close();
												inStream.write(System.getProperty("line.separator").getBytes());
												inStream.writeUTF(date1.toString());
											    inStream.writeUTF(s4);
												inStream.writeUTF("cancelled room");
												inStream.close();
											}
											catch(FileNotFoundException e)
											{
												System.out.println(e);
											}
											catch(IOException e)
											{
												System.out.println(e);
											}
										}
													
									}
									return "cancelled";
								}
								else
								{
									System.out.println("Invalid Access");
								}
							}
						}
					}
					}
			}}
			String w1=new String();
			String w2=new String(bookingID);
			String w3=new String(userid);
			w1=w1.concat(w2);
			w1=w1.concat(w3);
			System.out.println(w1);
			threadsender2 ts3=new threadsender2(w1,4000);
			Thread t3=new Thread(ts3);
			t3.start();
			try 
			{
				t3.join();
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String w4=ts3.dstring;
			String con=w4.substring(0,9);
			String con1=w4.substring(0,12);
			System.out.println(w4);
			System.out.println(w4.length());
			if(con.equals(new String("cancelled")))
			{
			    	return "cancelled";
			}
			else
			{     
					System.out.println(w1);
			    	threadsender2 ts4=new threadsender2(w1,4002);
			    	Thread t4=new Thread(ts4);
			    	t4.start();
			    	try 
			    	{
						t4.join();
					} 
			    	catch (InterruptedException e) 
			    	{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	String w5=ts4.dstring;
					 con=w5.substring(0,12);

			    	System.out.println(w5);
			    	if(con.equals(new String("cancelled")))
					{
					    	return "cancelled";
					 }
			    	
			 }
			
	  
			System.out.println("before the return of not cancelled");
			return "notcancelled";
	  }

public synchronized String  localcancelBooking (String bookingID, String userid)
{
	int c=0;

String s3=bookingID;
Set<String> set= a.keySet();
Iterator it=set.iterator();
while(it.hasNext())
{
	String s =(String)it.next();
	Set<String> set1 =	a.get(s).keySet();
	Iterator it1 =set1.iterator();
	while(it1.hasNext())
	{
		String s1=(String)it1.next();
		Set<String> set2=a.get(s).get(s1).keySet();
		Iterator it2=set2.iterator();
		while(it2.hasNext())
		{
			String s2=(String)it2.next();
			if(s3.equals(a.get(s).get(s1).get(s2)));
			{	
				Set<String> setb= d.keySet();
				Iterator idb=setb.iterator();
				while(idb.hasNext())
				{
					
					String s9=(String)idb.next();
					System.out.println(s9 +" S9");
					System.out.println(d.get(s9)+" d.get(s9)");
				//	System.out.println(d.get(s9).get(1)+" d.get(s9).get(1)");
					Iterator setn1=d.get(s9).iterator();
					while(setn1.hasNext())
					{
						String sn1=(String)setn1.next();
						if((s9.equals(userid)) && sn1.equals(bookingID))
  					{	
						a.get(s).get(s1).put(s2,"Available");
  						System.out.println(a.get(s).get(s1).get(s2)+" a.get(s).get(s1).get(s2)");

						System.out.println("Booking cancellation was successful");
						Set<String> set3= d.keySet();
						Iterator it3=set3.iterator();
						while(it3.hasNext())
						{
							String s4=(String)it3.next();
							for(i=0;i<e.size();i++)
							{
								if(bookingID.equals(d.get(s4).get(i)))
								d.get(s4).remove(i);
  								System.out.println(d);

								try
								{
									FileOutputStream fos = new FileOutputStream("src/admin2.txt",true);
									DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
									FileOutputStream dos = new FileOutputStream("src/server2client.txt",true);
									DataOutputStream inStream = new DataOutputStream(new BufferedOutputStream(dos));
									outStream.write(System.getProperty("line.separator").getBytes());
									Date date1 = new Date();
									outStream.writeUTF(date1.toString());
									outStream.writeUTF(s4);
									outStream.writeUTF("cancelled room");
									outStream.close();
									inStream.write(System.getProperty("line.separator").getBytes());
									inStream.writeUTF(date1.toString());
								    inStream.writeUTF(s4);
									inStream.writeUTF("cancelled room");
									inStream.close();
								}
								catch(FileNotFoundException e)
								{
									System.out.println(e);
								}
								catch(IOException e)
								{
									System.out.println(e);
								}
								return "cancelled";
							}
										
						}
						return "cancelled";
					}
					else
					{
						System.out.println("Invalid Access");
					}
				}
			}
		}
	
	}
}
}	
return "notcancelled";
}
public String changeReservation(String studentid,String booking_id,String new_date, String new_campus_name, String new_room_no, String new_time_slot) 
{
	  String ret=new String();
	Set<String> sb1=d.keySet();
	Iterator ib1=sb1.iterator();
	while(ib1.hasNext())
	{
		String s1=(String)ib1.next();
		Iterator setn1=d.get(s1).iterator();
		while(setn1.hasNext())
		{
			String sn1=(String)setn1.next();
			if((s1.equals(studentid)) && sn1.equals(booking_id))
			{
				System.out.println("After finding bookingID");
				if(d.get(studentid).size()==3)
				{   
					d.get(studentid).remove(booking_id);
					ret=bookroom( new_campus_name,new_room_no, new_date,new_time_slot,studentid);
					System.out.println(a);
					System.out.println("After if of size check");
					if(ret.equals("its already booked"))
		            {
		        	    d.get(studentid).add(booking_id);
		        	    return "its already booked";
		           }
		           
		           else
		           {
		        	   String cancel=cancelBooking(studentid,booking_id);
		        	   System.out.println("After else of cancel of size check");
		        	   System.out.println(a);
		        	   return ret;
		           }
				}
				else
				{
					ret=bookroom(new_campus_name,new_room_no, new_date,new_time_slot,studentid);
					System.out.println(a);
					System.out.println(ret);
					System.out.println("After else  of booking without doing sie check");
		           if(ret.equals("its already booked"))
		           {
		        	   System.out.println(a);
		        	   return "its already booked";
		           }
		           
		           else
		           {
						System.out.println("before else  of cancel without doing sie check");

		        	   String cancel=cancelBooking(booking_id,studentid);
		        	   System.out.println(a);
		        	   System.out.println(cancel);
		        	 //  System.out.println(a);
						System.out.println("After else  of cancel without doing sie check");
						System.out.println(d);
						return ret;

		           }
				
				
				}
			}	
		
	}
	}
	return ret;
	  
}
}