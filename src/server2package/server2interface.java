package server2package;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface server2interface extends Remote{

	public  boolean createroom(String rno,String date,String timeslot)throws java.rmi.RemoteException, IOException;;
	public boolean deleteroom(String rno, String date, String timeslot)throws java.rmi.RemoteException;;
	public 	String bookroom(String campusName,String rno,String date,String timeslot,String UID)throws java.rmi.RemoteException;;
    public String getAvailableTimeSlot ( String date)throws java.rmi.RemoteException, InterruptedException;;
    public String cancelBooking (String bookingID,String userid)throws java.rmi.RemoteException;;
    public String changeReservation(String studentid,String booking_id,String new_date, String new_campus_name, String new_room_no, String new_time_slot) throws java.rmi.RemoteException;;
	
   // public void listener(int a,int b,String date ) throws java.rmi.RemoteException;;
	
	
}
