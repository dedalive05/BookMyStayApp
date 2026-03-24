public class BookMyStayApp {
    public abstract class Room {

      protected int numberOfBeds;
      protected int squareFeet;
      protected double pricePerNight;

      public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
      }

      public void displayRoomDetails() {
        System.out.println("Room Details:");
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Room Size (sq ft): " + squareFeet);
        System.out.println("Price per Night: $" + pricePerNight);
      }
   }
}
