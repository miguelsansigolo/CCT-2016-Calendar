import java.util.Scanner;

public class LeapYearCalculator {
  int dayMonth=0;
  int dayWeek=1;
  String monthName;
  int maxDay;
  int skip=0;
  static int dayTotal;
  static int year;
  static boolean yearCheck;

//This contructor was made so we could input the names of the months and the maxDay each month has.
  public LeapYearCalculator(String monthName, int maxDay){
    this.monthName = monthName;
    this.maxDay = maxDay;
  }
  public LeapYearCalculator(){}

  public void printMonth(){
    for(dayWeek =1 ;dayWeek<=maxDay;dayWeek++){
      dayMonth++;
      if(dayMonth==1){
        tabSystem();
      }
      if(dayMonth<=maxDay){
        if(dayMonth<10){
          System.out.print(" "+dayMonth+"  ");
        }else{
          System.out.print(""+dayMonth+"  ");}
          skip++;
        }
      if(dayMonth>=maxDay){
        for(skip=skip;skip<7;skip++){
          System.out.print("    ");
        }
        if(monthName=="March"||monthName=="June"||monthName=="September"||monthName=="December"){
          System.out.println();
        }
        skip=0;
        break;
      }
      if(skip>=7&&monthName=="March"||skip>=7&&monthName=="June"||skip>=7&&monthName=="September"||skip>=7&&monthName=="December"||skip!=7&&monthName=="March"&&dayMonth==maxDay){
        System.out.println();
      }
      if(skip>=7){
        skip=0;
        break;
      }
    }
  }
  
//The only use for this method is to check if the month of february has 28 or 29 days.
  public void checkName(){
    if(monthName=="February"){
      isLeap();
      if(yearCheck==true){
        maxDay=29;
      }else{
        maxDay=28;
      }
    }
  }

  //This is where all the alignment on the calendar happens.
  public void tabSystem(){
	//Here we are checking if it is a leap year or not and then we assing a value to the variable skip which is the variable that basically keeps track of the positions in the calendar.
    if(yearCheck==false){
      skip=dayTotal-1;
      if(dayTotal==0){
        skip=6;
      }
    }else{
      if(dayTotal>2){
        skip=dayTotal-2;
      }else if(dayTotal==1){
        skip=6;
      }else if(dayTotal==0){
        skip=5;
      }
    }
	//Here we check again if it is a leap year and if the name of the month is february.If it is, we give skip the value of dayTotal +2 or else we give it the value of dayTotal +1.
	//the "dayTotal" variable comes from the findDay() function and you can find an explanation of how it works there.
    if(monthName=="February"){
      if(yearCheck!=true){
        skip=dayTotal+2;
      }else{
        skip=dayTotal+1;
      }
    }
	//Here we check the names of the months and assign a positive value to dayTotal.
	//This value comes from the fact that the first day of any given month starts a certain number of days after the first day of january. 
    if(monthName=="March"||monthName=="November"){
      skip=dayTotal+2;
    }else if(monthName=="April"||monthName=="July"){
      skip=dayTotal+5;
    }else if(monthName=="May"){
      skip=dayTotal+7;
    }else if(monthName=="June"){
      skip=dayTotal+3;
    }else if(monthName=="August"){
      skip=dayTotal+1;
    }else if(monthName=="October"){
      skip=dayTotal+6;
    }else if(monthName=="September"||monthName=="December"){
      skip=dayTotal+4;
    }
	//This part of the code makes sure that if skip is more than 7, it will reset and go back to its right position. 
	//Lets say that skip is 9. It will subtract 7 from 9, which equals to 2, so skip will be 2.
    if(skip>=7){
      skip=skip-7;
    }
	//After i have the correct value for skip, i then use it in this loop which will basically press the spacebar multiple times to align everything.
    for(int h=0;h<skip;h++){
      System.out.print("    ");
    }
  }
  
  //This is the function where everything happens and i put together all the other methods inside this one.
  //I create an object for each individual month, then we use the function checkName() to see how many days the month has. I 
  public void printCalendarDays(){
    LeapYearCalculator jan = new LeapYearCalculator("January",31);
    LeapYearCalculator feb = new LeapYearCalculator("February",29);
    LeapYearCalculator mar = new LeapYearCalculator("March",31);
    LeapYearCalculator apr = new LeapYearCalculator("April",30);
    LeapYearCalculator may = new LeapYearCalculator("May",31);
    LeapYearCalculator jun = new LeapYearCalculator("June",30);
    LeapYearCalculator jul = new LeapYearCalculator("July",31);
    LeapYearCalculator aug = new LeapYearCalculator("August",31);
    LeapYearCalculator sep = new LeapYearCalculator("September",30); 
    LeapYearCalculator oct = new LeapYearCalculator("October",31);
    LeapYearCalculator nov = new LeapYearCalculator("November",30);
    LeapYearCalculator dec = new LeapYearCalculator("December",31);
    String weekDayNames = "Su  Mo  Tu  We  Th  Fr  Sa  | ";
    findDay();
    feb.checkName();
    String[]months ={"January","February","March","April","May","June","July","August","September","October","November","December"};
    if(yearCheck==true){
      System.out.println("                                  This is a leap year.");
    }else if(yearCheck==false){
      System.out.println("                                This is not a leap year.");
    }
    System.out.println("                                          "+year);
    
    //The following loops go through the names of the months and the days of each month. 
    //This one goes from January to March.
    for(int i = 0;i<3;i=i){
      for(int g =0;g<3;g++){
        System.out.print("           "+months[i]+"           ");
        i++;}
      System.out.println();
      for(int j =0;j<3;j++){
        System.out.print(weekDayNames);
      }
    }
    System.out.println();
    for(int l =0 ; l<6; l++){
      jan.printMonth();
      System.out.print("| ");
      feb.printMonth();
      System.out.print("| ");
      mar.printMonth();
    }
    System.out.println();
    
    //This one goes from April to June.
    for(int i = 3;i<6;i=i){
      for(int g =0;g<3;g++){
        System.out.print("           "+months[i]+"               ");
        i++;}
      System.out.println();
      for(int j =0;j<3;j++){
        System.out.print(weekDayNames);
      }
    }
    System.out.println();
    for(int p =0 ; p<6; p++){
      apr.printMonth();
      System.out.print("| ");
      may.printMonth();
      System.out.print("| ");
      jun.printMonth();
    }
    System.out.println();
    
    //This one goes from July to September.
    for(int i = 6;i<9;i=i){
      for(int g =0;g<3;g++){
        System.out.print("           "+months[i]+"             ");
        i++;}
      System.out.println();
      for(int j =0;j<3;j++){
        System.out.print(weekDayNames);
      }
    }
    System.out.println();
    for(int p =0 ; p<6; p++){
      jul.printMonth();
      System.out.print("| ");
      aug.printMonth();
      System.out.print("| ");
      sep.printMonth();
    }
    System.out.println();
    
    //This one goes from October to December.
    for(int i = 9;i<12;i=i){
      for(int g =0;g<3;g++){
        System.out.print("           "+months[i]+"           ");
        i++;}
      System.out.println();
      for(int j =0;j<3;j++){
        System.out.print(weekDayNames);
      }
    }
    System.out.println();
    for(int p =0 ; p<6; p++){
      oct.printMonth();
      System.out.print("| ");
      nov.printMonth();
      System.out.print("| ");
      dec.printMonth();
    }
    System.out.println();
    printCalendarDays();
  }

  //This function checks whether the year is a leap year or not and assigns true or false to the variable yearCheck.
  //The function does not return any value as the value is returned in the function displayCalendar()
  public void isLeap(){
    if(year%4==0){
      if(year%100>0){
        yearCheck=true;
      }else if(year%100==0 && year%400==0){
        yearCheck=true;
      }else{
        yearCheck=false;
      }
    }else{
      yearCheck=false;
    }
  }
  
  public void findDay(){
	//Here i am using a scanner to get the year that the user wants to input. I know you said no external libraries, but i thought that this wouldn't hurt since it is not altering in any form the calendar itself.
	//The idea is simply to make it more fluid for the user. If i didn't use this, it would require the user to change the value of year inside the code itself. I hope you understand my point.
	//If required, i can change the structure of the code to accomodate a different input method and do as you required. 
    Scanner scan = new Scanner(System.in);
    String givenCent;
    System.out.println("Please insert the year you want to create a calendar for.");
    try{
      year = scan.nextInt();
      if(year<=0){
        System.out.println("This is not a valid option.");
        findDay();
      }
    }catch(Exception InputMismatch){
      System.out.println("That's not a valid input.");
      findDay();
    }
	//Here i convert the year inserted by the user into a string so i can break it down in two pieces.
    String givenYear = String.valueOf(year);
    if(year<=0){
      System.out.println("This is not a valid option.");
      findDay();
    }
	// Here i am breaking down the string
    if(year>1000){
      givenCent = givenYear.substring(0,2);
    }else if(year>=100&&year<1000){
      givenCent = givenYear.substring(0,1);
    }else{
      givenCent = "0";
    }
    if(year>=1000){
      givenYear = givenYear.substring(2);
    }else if(year>=100&&year<1000){
      givenYear = givenYear.substring(1);
    }else{
      givenYear = givenYear.substring(0);
    }
    int realYear = Integer.parseInt(givenYear);
    int realCent = Integer.parseInt(givenCent);
    int check = realCent/2;
    //Divides the 2 first digits of the year (century) that was inserted by 2.
    //If else statements use the "check" variable to do some calculations and narrow down what was the exact century. The result of the calculations will be either 1, 2, 4 or 6.
    //1st IF checks if variable "check" divided by 2 is even and if "realCent" is even.
    //1st ELSE IF checks if "check" divided by two is odd,then it checks to see if "realCent" divided by two is even, and finally it checks if the first 2 digits are "10" because the year 1000 can cause problems.
    //2nd ELSE IF checks if "realCent" divide by 2 is odd and if "check" divided by 2 is even.
    //Here is an example of how it works: 19/2 = 9.5. 9 is stored in the "check variable".
    //Now it checks if the result of 9/2 is even, since we are using integers, the result will be 4 and return positive.
    //Any year that starts with 19 receives the value of 4.
    if(check%2==0&&realCent%2==0){
      realCent=1;
    }else if(check%2!=0&&realCent%2==0&&realCent!=10){
      realCent=4;
    }else if(realCent%2!=0&&check%2==0){
      realCent=6;
    }else{
      realCent=2;
    }
    dayTotal=(1+6+realYear+(realYear/4)+realCent);
	//Here we get the value of the day, 0 being sunday, 1 mondey, 2 tuesday and so on and so forth.
	//First we check if the year is not between 1000 and 1100 because this years started 2 days after
	//After that, we assign the value.
    if(year>=1100||year<=1000){
    dayTotal = dayTotal%7;
    }else{
      dayTotal = (dayTotal%7)+2;
      if(dayTotal>=7){
        dayTotal-=7;
      }
    }
	System.out.println(givenYear);
  }
}
