/**
* This program will predict your future
* @author Luke Hindman
*/
 
import java.util.Random;
 
public class Future {
 
   /* Constants */
   public static final String[] HOME_LIST = {"mansion", "apartment", "shack", "house"};
   public static final String[] SPOUSE_LIST_MALE = {"Bob", "Jim", "Hank", "Julio"};
   public static final String[] SPOUSE_LIST_FEMALE = {"Bobbie","Veronica", "Sara", "Alexa"};
   public static final String[] TRANSPORTATION_LIST = {"ride a unicycle", "ride the bus", "pogo on a pogostick"};
   public static final String[] OCCUPATION_LIST = {"computer scientist", "acrobat", "accountant", "vigilante", "professional frisbee player"};
   public static final String[] HOMETOWN_LIST = {"Boise", "Phoenix", "Las Vegas", "Shanghai", "Tokyo", "Budapest"};
 
   /* Instance Variables */
   private String firstHome;
   private String secondHome;
   private String spouse;
   private String transportation;
   private String occupation;
   private String hometown;
   private String name;  
   
   private int yearsOfMarriage;
   private int numberOfKids;
   private int numberOfCats;
   private int numberOfDogs;
 
   /* Constructor */
   /**
    * Generate your future
    * @param name Your name
    * @param spouse Name of your spouse
    * @param firstHome Type of home
    * @param secondHome Type of home
    * @param transportation Method of transportation
    * @param occupation Form of employment
    * @param hometown City to live in.
    */
   public Future(String name, 
		   String spouse, 
		   String firstHome, 
		   String secondHome, 
		   String transportation, 
		   String occupation,
		   String hometown) {
       this.name = name;
       this.firstHome = firstHome;
       this.secondHome = secondHome;
       this.transportation = transportation;
       this.occupation = occupation;
       this.hometown = hometown;
       
       /* Randomly select values for the following */
       Random r = new Random();
       yearsOfMarriage = r.nextInt(5) + 3; // 3 to 8 years
       numberOfKids = r.nextInt(7);
       numberOfCats = r.nextInt(18);
       numberOfDogs = r.nextInt(4);
   }
   
   /**
    * Generate your future
    * @param name Your Name
    * @param preferredGenderOfSpouse Gender of spouse
    */
   public Future(String name, String preferredGenderOfSpouse) {
       this.name = name;
       Random r = new Random();
       firstHome = HOME_LIST[r.nextInt(HOME_LIST.length)];
       secondHome = HOME_LIST[r.nextInt(HOME_LIST.length)];
       
       if (preferredGenderOfSpouse.toLowerCase().equals("female")){
           spouse = SPOUSE_LIST_FEMALE[r.nextInt(SPOUSE_LIST_FEMALE.length)];
 
       } else {
           spouse = SPOUSE_LIST_MALE[r.nextInt(SPOUSE_LIST_MALE.length)];
       }
 
       transportation = TRANSPORTATION_LIST[r.nextInt(TRANSPORTATION_LIST.length)];
       occupation = OCCUPATION_LIST[r.nextInt(OCCUPATION_LIST.length)];
       hometown = HOMETOWN_LIST[r.nextInt(HOMETOWN_LIST.length)];
       
       yearsOfMarriage = r.nextInt(5) + 3; // 3 to 8 years
       numberOfKids = r.nextInt(7);
       numberOfCats = r.nextInt(18);
       numberOfDogs = r.nextInt(4);
   } 
 
   /**
    *  Override toString() 
    */
   public String toString() {
       String output = "";
       
       output += "Hello " + name + ", This is your future... \n";
       output += "You will marry " + spouse + " and live in a " + firstHome + ". " ;
       output += "After " + yearsOfMarriage + " years of marriage, you will finally get your dream job of being a " + occupation + ". ";        
       output += "Your family will move to a " + secondHome + " in " + hometown + " where you will " + transportation + " to work each day. ";
       output += "You and " + spouse + " will have " + numberOfKids + " kids, " + numberOfCats + " cats, and " + numberOfDogs + " dogs ";
       output += "and will live happily ever after in " + hometown + ".";
       
       return output;    
   }


   /* Main Method */
   public static void main(String[] args) {
 
       if (args.length != 2 ) {
           System.out.println ("usage: java Future <name> <gender of spouse>");
           System.exit(1);
       }
       String myName = args[0];
       String preferredGenderOfSpouse = args[1];
 
       Future myFuture = new Future(myName, preferredGenderOfSpouse);
 
       System.out.println(myFuture);
   }
   
 
}