public class Reservation {
    private int reservationId;
    private int roomNumber;
    private String customerId;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(int reservationId,int roomNumber, String customerId, String checkInDate, String checkOutDate){
        this.reservationId = reservationId;
        this.roomNumber = roomNumber;
        this.customerId = customerId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationId(){
        return reservationId;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public String getCustomerId(){
        return customerId;
    }

    public String getCheckInDate(){
        return  checkInDate;
    }
    public String getCheckOutDate(){
        return checkOutDate;
    }
}
