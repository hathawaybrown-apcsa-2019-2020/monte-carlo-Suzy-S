
/**
 * Write a description of class AirlineMonteCarlo here.
 *
 * @author Suzy Schwabl
 * @version 2019-10-22
 */
public class AirlineMonteCarlo
{
   private int planeSeats;
   private double probabilityNoShow;
   private int seatsSold;
   private int shows = 0;
   private int accumulatingShows = 0;
   private double avgSeatsFilled;
   private int timesOverBooked = 0;
   private int totalShows;
   private double overBookPercent;
   private final int NUM_SIMULATIONS = 100000;
    /**
    * @param planeSeats             How many plane seats there are on the plane
    * @param seatsSold              How many seats are sold to passengers
    * @param probabilityNoShows     The percent probability that each passenger won't show up     
    */
   public AirlineMonteCarlo(int seatsSold, int planeSeats, double probabilityNoShow)
   {
        this.planeSeats = planeSeats;
        this.seatsSold = seatsSold;
        this.probabilityNoShow = probabilityNoShow;
   }
    /**
    * runs 100,000 simulations of the plane and calculates the average seats filled and the percentage that the plane overbooks
    */
   public void runSimulation()
   {   
        for(int n = 0; n < NUM_SIMULATIONS; n++ )
        {
            shows = 0;
            for(int k = 0; k < seatsSold; k++)
            {
                if(Math.random() > probabilityNoShow)
                  {
                   shows++;
                }
            }
            if(shows > planeSeats)
            {
                 timesOverBooked++;
            }
            accumulatingShows = Math.abs(accumulatingShows) + Math.abs(shows);
        }
        avgSeatsFilled = Math.abs((double)accumulatingShows/NUM_SIMULATIONS);
        overBookPercent = (double)timesOverBooked/NUM_SIMULATIONS * 100;
     }
    /**
     * prints the results of the parameters of the plane, the average seats filled, the number of times overbooked, and the percentage of times over booked 
     */
   public void reportResults()
    {
        System.out.println("Simulation: " + seatsSold + " tickets sold for " + planeSeats + " seats; no-show probability = " + probabilityNoShow);
        System.out.println("Based on these 100,000 simulations");
        System.out.println("Average seats filled: " + avgSeatsFilled);
        System.out.println("Number of times overbooked: " + timesOverBooked + " ( " + overBookPercent + " percent )");
        System.out.println();
    }
   public static void main (String[] args)
    {
        AirlineMonteCarlo mySim = new AirlineMonteCarlo(140, 136, .04);
        mySim.runSimulation();
        mySim.reportResults();
    }
}
