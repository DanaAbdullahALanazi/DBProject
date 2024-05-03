import java.util.*;
import java.lang.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Branch{
private static Scanner input= new Scanner(System.in);

public static void main(String args[]){
    int choice1;
    do{
        System.out.println("Table Branch:\n 1) Insert new record \n2) Display all the records \n3) Exit\n Choose an operation:)");
        // Validate choice input
        while (!input.hasNextInt()) {
            System.out.println("Invalid input! Please enter an integer value.");
            input.next();
        }
        choice1 = input.nextInt();
        input.nextLine(); // Clear the newline character from the input stream
    switch(choice1){
 case 1:
 String choice2=null;//just to initilize it
 do{
    Integer EID=null;
 System.out.println("Branch - INSERTION:");
 System.out.print("Branch ID: ");
 String IDInput = input.nextLine();

 Integer branchID;
 if (IDInput.isEmpty()) {
 // If the input is empty, assign null to the Bphone variable
 branchID=null;
 }
 else {
 // If the input is not empty, parse the input as an integer
 try {
 branchID = Integer.parseInt(IDInput);
 }  
 catch (NumberFormatException e) {
 System.out.println("Invalid phone number input! please enter a correct ID Number");
 branchID=input.nextInt();
 return;
 }
 }
 input.nextLine();//to clean the garbage

    System.out.print("Branch Phone Number (optional): ");
        String phoneNumberInput = input.nextLine();

        Integer Bphone;
        if (phoneNumberInput.isEmpty()) {
        // If the input is empty, assign null to the Bphone variable
        Bphone=null;
        }
        else {
        // If the input is not empty, parse the input as an integer
        try {
        Bphone = Integer.parseInt(phoneNumberInput);
        }  
        catch (NumberFormatException e) {
        System.out.println("Invalid phone number input! please enter a correct phone Number");
        Bphone=input.nextInt();
        return;
        }
        }
    input.nextLine();//to clean the garbage
 String city;
 System.out.print("Branch City: ");
 while(input.hasNextLine()){
 city=input.nextLine();
 if(city.length()>15)
 System.out.print("The city name you have entered is too long make sure it's less than 16 characters!");
 city=input.nextLine();
 }
 System.out.print("Branch State (optional): ");
        String stateInput = input.nextLine();

        
        String state=null;//just to initilize it
        if (stateInput.isEmpty()) {
        // If the input is empty, assign null to the state variable
        state=input.nextLine();
        }
        else {
        // If the input is not empty, check the domain constraint
        while(state.length()>20)
        System.out.print("The state name you have entered is too long make sure it's less than 21 characters!");
        state=input.nextLine();
        }
    input.nextLine();//to clean the garbage
    System.out.print("Branch Zip Code: (optional): ");
        String ZIPInput = input.nextLine();

        Integer ZIP;;
        if (ZIPInput.isEmpty()) {
        // If the input is empty, assign null to the ZIP variable
        ZIP=null;
        }
        else {
        // If the input is not empty, parse the input as an integer
        try {
        ZIP = Integer.parseInt(ZIPInput);
        }  
        catch (NumberFormatException e) {
        System.out.println("Invalid ZIP code input! please enter a correct ZIP code Number");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input! Please enter an integer value.");
            input.next();
         }
         ZIP = input.nextInt();
        return;
        }
        }
    input.nextLine();//to clean the garbage 
    boolean validInput = false;
    while (!validInput) {
        System.out.print("Insert a new record (Y/N)? Enter Y for yes and N for no: ");
        choice2 = input.nextLine();

        if (choice2.equalsIgnoreCase("Y")||choice2.equalsIgnoreCase("N")) {
            validInput = true; // Set validInput to true to exit the loop
            break;
        } 
        else {
            // User entered an invalid input
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
    //here we call the insert method and paas it the values read bu the user plus the EID which is null
 }//end do
 while(choice2.equalsIgnoreCase("Y"));

 case 2: 


 case 3: 
 break;

 default:
 System.out.println("The number you have entered is incorrect! choose only 1, 2, or 3");

}//end switch
}//end do
while(choice1!=3);
System.exit(1);
}//end main 






private static void displayRecords(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM Branch";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            // Retrieve by column name
            int id = rs.getInt("BranchID");
            int phoneNumber = rs.getInt("BPhone");
            String city = rs.getString("City");
            String state = rs.getString("State");
            int zipCode = rs.getInt("ZIP");

            // Display values
            System.out.println("BranchID: " + id);
            System.out.println("PhoneNumber: " + phoneNumber);
            System.out.println("City: " + city);
            System.out.println("State: " + state);
            System.out.println("ZipCode: " + zipCode);
            System.out.println();
        }
        rs.close();
    }



}//end class