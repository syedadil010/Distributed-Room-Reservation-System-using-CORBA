package corbamodule;


/**
* corbamodule/commonPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from client.idl
* Saturday, November 4, 2017 1:53:13 AM EDT
*/

public abstract class commonPOA extends org.omg.PortableServer.Servant
 implements corbamodule.commonOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createroom", new java.lang.Integer (0));
    _methods.put ("deleteroom", new java.lang.Integer (1));
    _methods.put ("bookroom", new java.lang.Integer (2));
    _methods.put ("getAvailableTimeSlot", new java.lang.Integer (3));
    _methods.put ("cancelBooking", new java.lang.Integer (4));
    _methods.put ("changeReservation", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // corbamodule/common/createroom
       {
         String rno = in.read_string ();
         String date = in.read_string ();
         String timeslot = in.read_string ();
         boolean $result = false;
         $result = this.createroom (rno, date, timeslot);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // corbamodule/common/deleteroom
       {
         String rno = in.read_string ();
         String date = in.read_string ();
         String timeslot = in.read_string ();
         boolean $result = false;
         $result = this.deleteroom (rno, date, timeslot);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // corbamodule/common/bookroom
       {
         String campusName = in.read_string ();
         String rno = in.read_string ();
         String date = in.read_string ();
         String timeslot = in.read_string ();
         String UID = in.read_string ();
         String $result = null;
         $result = this.bookroom (campusName, rno, date, timeslot, UID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // corbamodule/common/getAvailableTimeSlot
       {
         String date = in.read_string ();
         String $result = null;
         $result = this.getAvailableTimeSlot (date);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // corbamodule/common/cancelBooking
       {
         String bookingID = in.read_string ();
         String userid = in.read_string ();
         String $result = null;
         $result = this.cancelBooking (bookingID, userid);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // corbamodule/common/changeReservation
       {
         String studentid = in.read_string ();
         String booking_id = in.read_string ();
         String new_date = in.read_string ();
         String new_campus_name = in.read_string ();
         String new_room_no = in.read_string ();
         String new_time_slot = in.read_string ();
         String $result = null;
         $result = this.changeReservation (studentid, booking_id, new_date, new_campus_name, new_room_no, new_time_slot);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corbamodule/common:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public common _this() 
  {
    return commonHelper.narrow(
    super._this_object());
  }

  public common _this(org.omg.CORBA.ORB orb) 
  {
    return commonHelper.narrow(
    super._this_object(orb));
  }


} // class commonPOA
