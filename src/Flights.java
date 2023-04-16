package src;

public class Flights {
    public Flight[] flight = new Flight[50];
    public void defFlights(Flights flights)
    {
        flights.flight[0] = new Flight("GT-25" , "Yazd" , "tehran" , "1402/03/25","22:10",700000,"25");
        flights.flight[1] = new Flight("LK-14" , "Shiraz" , "Ghom" , "1402/02/23","20:00",800000,"50");
        flights.flight[2] = new Flight("QW-69" , "Khozestan" , "Yazd" , "1402/01/25","12:30",600000,"78");
        flights.flight[3] = new Flight("UI-87" , "semnan" , "tehran" , "1402/03/15","15:45",500000,"26");
        flights.flight[4] = new Flight("HJ-45" , "rasht" , "mashhad" , "1402/02/12","2:30",900000,"59");

    }
}
