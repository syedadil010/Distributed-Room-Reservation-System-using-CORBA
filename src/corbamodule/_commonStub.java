package corbamodule;


/**
* corbamodule/_commonStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from client.idl
* Saturday, November 4, 2017 1:53:13 AM EDT
*/

public class _commonStub extends org.omg.CORBA.portable.ObjectImpl implements corbamodule.common
{

  public boolean createroom (String rno, String date, String timeslot)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("createroom", true);
                $out.write_string (rno);
                $out.write_string (date);
                $out.write_string (timeslot);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return createroom (rno, date, timeslot        );
            } finally {
                _releaseReply ($in);
            }
  } // createroom

  public boolean deleteroom (String rno, String date, String timeslot)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("deleteroom", true);
                $out.write_string (rno);
                $out.write_string (date);
                $out.write_string (timeslot);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return deleteroom (rno, date, timeslot        );
            } finally {
                _releaseReply ($in);
            }
  } // deleteroom

  public String bookroom (String campusName, String rno, String date, String timeslot, String UID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("bookroom", true);
                $out.write_string (campusName);
                $out.write_string (rno);
                $out.write_string (date);
                $out.write_string (timeslot);
                $out.write_string (UID);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return bookroom (campusName, rno, date, timeslot, UID        );
            } finally {
                _releaseReply ($in);
            }
  } // bookroom

  public String getAvailableTimeSlot (String date)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAvailableTimeSlot", true);
                $out.write_string (date);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAvailableTimeSlot (date        );
            } finally {
                _releaseReply ($in);
            }
  } // getAvailableTimeSlot

  public String cancelBooking (String bookingID, String userid)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cancelBooking", true);
                $out.write_string (bookingID);
                $out.write_string (userid);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return cancelBooking (bookingID, userid        );
            } finally {
                _releaseReply ($in);
            }
  } // cancelBooking

  public String changeReservation (String studentid, String booking_id, String new_date, String new_campus_name, String new_room_no, String new_time_slot)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("changeReservation", true);
                $out.write_string (studentid);
                $out.write_string (booking_id);
                $out.write_string (new_date);
                $out.write_string (new_campus_name);
                $out.write_string (new_room_no);
                $out.write_string (new_time_slot);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return changeReservation (studentid, booking_id, new_date, new_campus_name, new_room_no, new_time_slot        );
            } finally {
                _releaseReply ($in);
            }
  } // changeReservation

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corbamodule/common:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _commonStub
