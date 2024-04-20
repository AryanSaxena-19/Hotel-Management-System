import java.util.Scanner;

public class HotelManagementSystem  {
    public static void main(String[]args){
        HotelManager hotelManager = new HotelManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nHotel Management System Menu:");
            System.out.println("1.Add Room");
            System.out.println("2.Display Available Rooms");
            System.out.println("3.Display All Rooms");
            System.out.println("4.Add Customer");
            System.out.println("5.Display All Customer");
            System.out.println("6.Make Reservation");
            System.out.println("7.Display All Reservation");
            System.out.println("8.Cancel Reservation");
            System.out.println("9.Exit");


            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Room Number:");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter Room Rate per night:₹");
                    double rate = scanner.nextDouble();
                    hotelManager.addRoom(roomNumber, rate);
                    break;

                case 2:
                    hotelManager.displayAvailableRooms();
                    break;

                case 3:
                    hotelManager.displayAllRooms();
                    break;

                case 4:
                    System.out.print("Enter Customer ID:");
                    String customerId = scanner.next();
                    System.out.print("Enter Customer Name:");
                    String name = scanner.next();
                    System.out.print("Enter Customer Contact Number");
                    String contactNumber = scanner.next();
                    hotelManager.addCustomer(customerId, name, contactNumber);
                    break;

                case 5:
                    hotelManager.displayAllCustomers();
                    break;

                case 6:
                    System.out.print("Enter Customer ID:");
                    String reserveCustomerId = scanner.next();
                    System.out.print("Enter Room Number to Reserve:");
                    int reserveRoomNumber = scanner.nextInt();
                    System.out.print("Enter Check-In Date(YYYY-MM-DD):");
                    String checkInDate = scanner.next();
                    System.out.print("Enter Check-Out Date(YYYY-MM-DD):");
                    String checkOutDate = scanner.next();
                    hotelManager.makeReservation(reserveCustomerId, reserveRoomNumber, checkInDate, checkOutDate);
                    break;

                case 7:
                    hotelManager.displayAllReservations();
                    break;

                case 8:
                    System.out.print("Enter Reservation ID to Cancel:");
                    int cancelReservationId = scanner.nextInt();
                    hotelManager.cancelReservation(cancelReservationId);
                    break;

                case 9:
                    System.out.println("Exiting Hotel Management System.Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
