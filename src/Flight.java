package src;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private double price;
    private int seats;
    private int numberOfBooked = 0;


    public Flight() {

    }

    public Flight(String flightId, String origin, String destination, String date, String time, double price, String seats) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = Integer.parseInt(seats);
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getNumberOfBooked() {
        return numberOfBooked;
    }

    public void setNumberOfBooked(int numberOfBooked) {
        this.numberOfBooked = numberOfBooked;
    }
}
