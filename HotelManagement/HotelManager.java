import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HotelManager {
    private Map<Integer, Room> rooms;
    private Map<String, Customer> customers;
    private List<Reservation> reservations;
    private int nextReservationId;

    public HotelManager(){
        rooms = new HashMap<>();
        customers = new HashMap<>();
        reservations = new ArrayList<>();
        nextReservationId = 1;
    }

    public void addRoom(int roomNumber, double rate){
        rooms.put(roomNumber, new Room(roomNumber, rate));
    }

    public void displayAvailableRooms(){
        System.out.println("Available Rooms:");
        for(Room room: rooms.values()){
            if(!room.isOccupied()){
                System.out.println("Room" + room.getRoomNumber()+"-Rate:₹" + room.getRate()+"per night");
            }
        }
    }

    public void displayAllRooms(){
        System.out.println("All Rooms:");
        for(Room room : rooms.values()){
            System.out.println("Room" + room.getRoomNumber()+"-Rate:₹"+room.getRate()+"per night");
        }
    }

    public void addCustomer(String customerId, String name, String contactNumber){
        customers.put(customerId,new Customer(customerId, name,contactNumber));
    }

    public void displayAllCustomers(){
        System.out.println("All Customers:");
        for(Customer customer : customers.values()){
            System.out.println("Customer ID:" + customer.getCustomerId()+
                    ",Name:" + customer.getName()+
                    ",Contact Number:" + customer.getContactNumber());
        }
    }

    public void makeReservation(String customerId, int roomNumber, String checkInDate, String checkOutDate){
        Room room = rooms.get(roomNumber);
        Customer customer = customers.get(customerId);

        if(room!= null && customer != null && !room.isOccupied()){
            room.occupyRoom();

            Reservation reservation = new Reservation(nextReservationId++, roomNumber, customerId, checkInDate, checkOutDate);

            reservations.add(reservation);

            System.out.println("Reservation successful.Reservation ID:" + reservation.getReservationId());
        }else{
            System.out.println("Room not available for reservation or invalid customer details.");
        }
    }

    public void displayAllReservations(){
        System.out.println("All Reservations:");
        for(Reservation reservation : reservations){
            System.out.println("Reservation ID:" + reservation.getReservationId() + ",Room:" +
                    reservation.getRoomNumber() +
                    ",Customer:" + reservation.getCustomerId() +
                    ",Check-In:" + reservation.getCheckInDate() +
                    ",Check-Out:" + reservation.getCheckOutDate());
        }
    }

    public void cancelReservation(int reservationId){
        Reservation reservation = findReservationById(reservationId);

        if(reservation != null){
            Room room = rooms.get(reservation.getRoomNumber());
            room.vacateRoom();
            reservations.remove(reservation);
            System.out.println("Reservation canceled successfully");
        }else{
            System.out.println("Invalid Reservation ID.");
        }
    }

    private Reservation findReservationById(int reservationId){
        for(Reservation reservation : reservations){
            if(reservation.getReservationId() == reservationId){
                return reservation;
            }
        }
        return null;
    }
}


