public class Booking {
    private int bookingId;
    private User user;
    private Train train;
    private String pickupLocation;
    private String dropLocation;
    private int numberOfTickets;
    private double totalPrice;

    // Constructor, Getters, and Setters
    public Booking(int bookingId, User user, Train train, String pickupLocation, String dropLocation, int numberOfTickets, double totalPrice) {
        this.bookingId = bookingId;
        this.user = user;
        this.train = train;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public User getUser() { return user; }
    public Train getTrain() { return train; }
    public int getNumberOfTickets() { return numberOfTickets; }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " [Passenger: " + user.getName() +
                ", Train: " + train.getTrainName() + ", NumberOfTickets: " + numberOfTickets +
                ", Pickup: " + pickupLocation + ", Drop: " + dropLocation +
                ", Total Price: $" + totalPrice + "]";
    }
}

//class Booking{
//    private static int idCounter = 1; // Static counter for unique ID
//    private int bookingId;
//    private Train train;
//
//    private Passenger passenger;
//    private int numTickets;
//    private String pickupLocation;
//    private String dropLocation;
//    private double totalPrice;
//
//    public Booking(Train train, Passenger passenger,int numTickets,String pickupLocation,String dropLocation) {
//        this.bookingId = idCounter++;
//        this.train = train;
//        this.passenger = passenger;
//        this.numTickets = numTickets;
//        this.totalPrice = train.getpriceperseat()*numTickets;
//        this.pickupLocation = pickupLocation;
//        this.dropLocation = dropLocation;
//
//    }
//
//    public Train getTrain() {
//        return train;
//    }
//    public Passenger getPassenger() {
//        return passenger;
//    }
//    public int getNumTickets(){return numTickets;}
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//    public String getPickupLocation() {return pickupLocation;}
//    public String getDropLocation() {return dropLocation;}
//    public int getBookingId(){return bookingId;}
//
//    public String toString() {
//        return "Booking ID: " + bookingId + " [Passenger: " + passenger.getname() +
//                ", Train: " + train.gettrainname() +
//                ", NumberOfTicket: " + numTickets +
//                ", Pickup: " + pickupLocation +
//                ", Drop: " + dropLocation +
//                ", Price: $" + totalPrice + "]";
//    }
//}