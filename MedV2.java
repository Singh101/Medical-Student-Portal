import java.util.Scanner;
import java.util.*;



public class MedV2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int stNum=0; //used to assign new student number to ppl who register
        int stNumAccess =0; //used to access info from students who are already logged in
        String emailActual;
        ArrayList<Student> studentArray = new ArrayList<Student>();
        for (int p =1; p>0;p++) {

        System.out.println("Welcome to the Medical School Login Portal");
        System.out.println("Press [1] to login or press [2] to register:");
        int opt1 = s.nextInt();
            if (opt1 == 1) {
                System.out.println("What is your email?");
                String stEmailCheck = s.next();

                for (int i = 0; i > 1; i++) {

                    emailActual = studentArray.get(i).getEmail();

                    if (stEmailCheck.equalsIgnoreCase(emailActual)) {
                        stNumAccess = studentArray.get(i).getStNum();
                        System.out.print("Welcome back ");
                        System.out.println(studentArray.get(stNumAccess).getFullName());  //printing students name
                        System.out.println("What would you like to do today?");
                        System.out.println("[1] Submit rotation information");
                        System.out.println("[2] Update/Delete Rotation Information");
                        System.out.println("[3] Logout");
                        System.out.println("Enter your choice:");
                        int loginChoice = s.nextInt();

                        if (loginChoice == 1) {
                            studentArray.get(stNumAccess).setRotation();
                            studentArray.get(stNumAccess).rotationDate();
                        } else if (loginChoice == 2) {
                            System.out.println("Here are your options:");
                            System.out.println("1) Edit/Update Rotations");
                            System.out.println("2) Delete Rotations");
                            System.out.println("Enter your option:");
                            int opt2 = s.nextInt();

                            if (opt2 == 1) {

                            }

                        }
                        i--;
                    } else {
                        System.out.println("This email is invalid.");
                    }
                }

                System.out.println("Hello ");


            } else {
                studentArray.add(new Student());
                System.out.println("Let's make a new account for you");
                System.out.println("Your Student ID Number is: " + stNum);
                studentArray.get(stNum).setStNum(stNum);
                studentArray.get(stNum).setFirstName();
                studentArray.get(stNum).setLastNameName();
                studentArray.get(stNum).setAddress();
                studentArray.get(stNum).setPostalCode();
                studentArray.get(stNum).setDOB();
                studentArray.get(stNum).setEmail();
                studentArray.get(stNum).setPass();
                studentArray.get(stNum).setPhone();
                studentArray.get(stNum).setPrgName();
                studentArray.get(stNum).setInstitution();
                stNum++; // increases student number for when next student is registered
            }
        }
    }
}

  class Student extends Rotation {
    Scanner s1 = new Scanner(System.in);
      ArrayList<Rotation> rotationArrayList = new ArrayList<Rotation>();

    int stID;
    String FirstName;
    String LastName;
    String Address;
    String PostalCode;
    int DOB;
    String email;
    String pass;
    String Phone;
    String PrgType;
    String PrgName;
    String Institution;

    public void setStNum (int stNum){
        stID = stNum;
    }
    public int getStNum(){
        return stID;
    }

    public void setFirstName(){
        System.out.println("What is your first name?");
        FirstName = s1.next();
    }

    public void setLastNameName(){
          System.out.println("What is your last name?");
          LastName = s1.next();
    }

    public String getFullName (){
        String fullName = (FirstName +" "+ LastName);
        return (fullName);
    }

    public void setAddress(){
          System.out.println("What is your Address?");
        Address = s1.next();
      }
      public void setPostalCode(){
          System.out.println("What is your Postal Code?");
          PostalCode = s1.next();
      }
      public void setDOB(){
          System.out.println("What is your Date of Birth in (mmddyyyy) format?");
          DOB = s1.nextInt();
      }
      public void setEmail() {
          for (int j = 1; j > 0; j++) {
              System.out.println("What is your email?");
              email = s1.next();
              char[] emailCheck = email.toCharArray();
              int emailChecker = 0; //this number will go up when there is a . or @ in the email meaning that it is valid

              for (int e = 0; e < emailCheck.length; e++) {
                  if (emailCheck[e] == '.' || emailCheck[e] == '@') {
                      emailChecker++;
                  }
              }
              if (emailChecker != 2) {
                  System.out.println("This email is invalid. Try again.");
              }
              j = -2;
          }
      }

      public String getEmail (){
          return (email);
      }

      public void setPass(){
          System.out.println("What is your password?");
          pass = s1.next();
          System.out.println("Retype your password just to be sure:");
          String passCheck = s1.next();
          if(passCheck.equals(pass) == false){
              setPass();
          }
      }
      public void setPhone(){
          System.out.println("What is your Phone Number?");
          Phone = s1.next();
      }
      public void setPrgName(){
          System.out.println("What is your Program Name?");
          System.out.println("1) Allergy");
          System.out.println("2) RPN");
          System.out.println("3) Other");
          System.out.println("Enter the number that is associated with your program name:");
          int opt2 = s1.nextInt();
          if (opt2 ==1){
              PrgName = "Allergy";
              PrgType = "Postgraduate";
              System.out.println("You are a(n) "+PrgType+ " student in the "+PrgType+" program.");
          }
          else if (opt2 ==2){
              PrgName = "RPN";
              PrgType = "Nursing";
              System.out.println("You are a(n) "+PrgType+ " student in the "+PrgType+" program.");

          }
          else if (opt2 ==3){
              System.out.println("What is the name of your program?");
              PrgName = s1.next();
              System.out.println("What type of program are you in?");
              PrgType = s1.next();
              System.out.println("You are a(n) "+PrgType+ " student in the "+PrgType+" program.");
          }
          else {
              System.out.println("Invalid option");
              setPrgName();
          }
      }

      public void setInstitution(){
        System.out.println("What institution are you studying at?");
        System.out.println("1) University of Toronto");
        System.out.println("2) Conestoga");
        System.out.println("3) University of Waterloo");
        System.out.println("4) Other");
          System.out.println("Enter the number that is associated with your institution:");
        int opt3 = s1.nextInt();

        if (opt3 == 1){
            Institution = "University of Toronto";
            System.out.println("You must be studying at "+Institution);
        }
        else if (opt3 ==2){
            Institution= "Conestoga";
        }
        else if (opt3 ==3){
            Institution = "University of Waterloo";
        }
        else if (opt3 ==4){
            System.out.println("What institution are you studying at?");
            Institution = s1.next();
        }
        else {
            System.out.println("Invalid option");
            setInstitution();
        }


      }

      public void newRotation () {
          rotationArrayList.add(new Rotation());

      }

  }

  class Rotation {
      Scanner s1 = new Scanner(System.in);

      String rotation;
      int dateStart;
      int dateEnd;
      String Supervisor;

      public void setRotation () {

          System.out.println("What rotation are you going to be on?");
          System.out.println("1) Anaesthesia");
          System.out.println("2) Orthopedics");
          System.out.println("3) Emergency");
          System.out.println("4) Other");
          System.out.println("Enter the number that is associated with your rotation:");
          int opt4 = s1.nextInt();

          if (opt4 == 1) {
              rotation = "Anaesthesia";
              Supervisor = "Andrew Chan";
              System.out.println("You will be on the " + rotation + " rotation with " + Supervisor);
          } else if (opt4 == 2) {
              rotation = "Orthopedics";
              Supervisor = "Pawan Singh";
              System.out.println("You will be on the " + rotation + " rotation with " + Supervisor);
          } else if (opt4 == 3) {
              rotation = "Emergency";
              Supervisor = "Sheldon Cooper";
              System.out.println("You will be on the " + rotation + " rotation with " + Supervisor);

          } else {
              System.out.println("What is the rotation you will be on?");
              rotation = s1.next();
              System.out.println("Who is the Supervisor?");
              Supervisor = s1.next();
          }
      }

          public  void rotationDate(){
              System.out.println("What day will you start? (ddmmyyyy)");
              dateStart = s1.nextInt();

              //getting month of starting
              String numberS = String.valueOf(dateStart);
              char[] digits1 = numberS.toCharArray();
              String stringMonthStart = new String(digits1, 2, 2);
              int monthStart = Integer.parseInt(stringMonthStart);

              //getting day of starting
              String numberSD = String.valueOf(dateStart);
              char[] digits2 = numberSD.toCharArray();
              String stringDayStart = new String(digits2,0,2);
              int dayStart = Integer.parseInt(stringDayStart);

              //getting month of ending
              System.out.println("What day will you end? (ddmmyyyy)");
              dateEnd = s1.nextInt();
              String numberE = String.valueOf(dateEnd);
              char[] digits3 = numberE.toCharArray();
              String stringMonthEnd = new String(digits3, 2, 2);
              int monthEnd = Integer.parseInt(stringMonthEnd);

              //getting day of end
              String numberED = String.valueOf(dateEnd);
              char[] digits4 = numberED.toCharArray();
              String stringDayEnd = new String(digits4,0,2);
              int dayEnd = Integer.parseInt(stringDayEnd);

              if (monthEnd<monthStart){
                  System.out.println("Invalid Date....the start month you entered comes before the end date ");
                  rotationDate();
              }
              else if (dayStart>dayEnd){
                  System.out.println("Invalid Date.... the start date you entered is before the end date!");
                  rotationDate();

          }

      }





  }


