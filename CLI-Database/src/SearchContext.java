import java.util.ArrayList;
import java.util.*;

interface Strategy{
    //void execute();
    void execute(ArrayList<Student> studentDB);
    
}

class SearchID implements Strategy{
Scanner input = new Scanner(System.in);
StudentView view = new StudentView();
    
    public void execute(ArrayList<Student> studentDB) {
        int temp = 0;
        
        System.out.println("");
        System.out.print("Please enter in the search ID: ");
        temp = input.nextInt();
        
        System.out.println(" ");
        System.out.println("STUDENT WITH ID " + temp + ":");
        System.out.println("==================");
        
        for(int i = 0; i< studentDB.size(); i++){
        Student testID = studentDB.get(i);
            if(temp == testID.getID()){
                view.printStudentDetails(testID);
            }
        }
        
       // System.out.println("This is the SearchID class");
    }

}
//tempName.equalsIgnoreCase(tempName) || testName.getName().contains(tempName
class SearchName implements Strategy{
Scanner input = new Scanner(System.in);
StudentView view = new StudentView();

    @Override
    public void execute(ArrayList<Student> studentDB) {
        String tempName = null;
        
        System.out.print("Please enter in the search name: ");
        tempName = input.next().toUpperCase();

        System.out.println(" ");
        System.out.println("STUDENTS WHO'S NAME MATCHS WITH " + tempName + " ARE:");
        System.out.println("===========================================");
        
        
        //loops throuth the elements of the student array
        for(int i = 0; i< studentDB.size(); i++){
        Student s = studentDB.get(i);
            if(s.getName().contains(tempName)){
                view.printStudentDetails(s);
                System.out.println(" ");
            }
        }
        //System.out.println("This is the SearchName class");
    }
}

class SearchCourse implements Strategy{
Scanner input = new Scanner(System.in);
StudentView view = new StudentView();

    @Override
    public void execute(ArrayList<Student> studentDB) {
    String[] temp = new String[1];
    
    
    System.out.println("Please enter in the course to be searched."); 
    System.out.print("<course dept> <course number> <section (optional)>: ");
    temp[0] = input.nextLine().toUpperCase();
        
    System.out.println(" ");
    System.out.println("STUDENTS WHO HAVE TAKEN " + temp[0] + " ARE: ");
    System.out.println("=============================================");
    
    for(int i = 0; i < studentDB.size(); i++){
      Student s = studentDB.get(i);
      
      //s.getCourse()[j].contains(temp[0])
      for(int j = 0; j <s.getCourse().size(); j++){
         if(s.getCourse().get(j).contains(temp[0])){
             view.printStudentDetails(s);
         }else{continue;}
        
      }
        
    }    
        //System.out.println("This is the SearchCourse class");
    }

}

class SearchAge implements Strategy{
Scanner input = new Scanner(System.in);
StudentView view = new StudentView();
    
    @Override
    public void execute(ArrayList<Student> studentDB) {
        int temp = 0;
        
        System.out.println("");
        System.out.print("Please enter in the search Age: ");
        temp = input.nextInt();
        
        System.out.println("STUDENTS WHO'S AGE IS "+ temp +" ARE:");
        System.out.println("=====================================");
        
        
        for(int i = 0; i< studentDB.size(); i++){
        Student testAge = studentDB.get(i);
            if((2020 - temp) == testAge.getAge()){
                view.printStudentDetails(testAge);
            }
        }
        
    }

}


abstract class SearchObj{
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(ArrayList<Student> studentDB){
        strategy.execute(studentDB);
    }

}


public class SearchContext extends SearchObj{
    
    public SearchContext(Strategy strategy){
        setStrategy(strategy);
    }
    public SearchContext(){}
    
//    private Strategy strategy;
//    
//    public SearchContext(Strategy strategy){
//        this.strategy = strategy;
//    }
//    
//    void executeStrategy(ArrayList<Student> studentsDB, int id){
//        
//    }

    
    
}
