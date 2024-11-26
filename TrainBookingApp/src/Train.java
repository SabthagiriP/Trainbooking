public class Train {
    private String trainId;
    private String trainName;
    private int availableSeats;
    private double ticketPrice;

    // Constructor, Getters, and Setters
    public Train(String trainId, String trainName, int availableSeats, double ticketPrice) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public String getTrainId() { return trainId; }
    public String getTrainName() { return trainName; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public double getTicketPrice() { return ticketPrice; }
}

//class Train{
//    private int trainNo;
//    private String trainName;
//    private int NoOfSeat;
//    private double pricePerSeat;
//
//    public Train(int trainNo,String trainName,int NoOfSeat,double pricePerSeat){
//        this.trainNo = trainNo;
//        this.trainName = trainName;
//        this.NoOfSeat = NoOfSeat;
//        this.pricePerSeat = pricePerSeat;
//    }
//
//    public int gettrainno(){
//        return trainNo;
//    }
//    public String gettrainname(){
//        return trainName;
//    }
//    public int getNoOfSeat(){
//        return NoOfSeat;
//    }
//    public double getpriceperseat(){
//        return pricePerSeat;
//    }
//    public boolean bookSeat(){
//        if(NoOfSeat > 0){
//            NoOfSeat--;
//            return true;
//        }
//        return false;
//    }
//    public void releaseSeats(int numSeats) {
//        NoOfSeat += numSeats;
//    }
//}
