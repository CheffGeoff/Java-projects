import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
    Peter Kalis
    CSC-285 
    05/08/2020
*/

public class Database {

    private static Student createStudent(int id){
        Scanner input = new Scanner(System.in);
        Student s = new Student();
        
        String name;
        int birthYear;
        int numCourses;
        String addCourse;
                            
                    
        System.out.print("Enter the student's name: ");
        name = input.nextLine().toUpperCase();
        System.out.print("Enter the students year of birth: ");
        birthYear = input.nextInt();
        System.out.print("Enter the number of courses: ");
        numCourses = input.nextInt() + 1;
                  
        //String courses[] = new String[numCourses + 1];
        ArrayList<String> courses = new ArrayList<String>();
        for(int i=0; i < numCourses; i++){
            //int j = i + 1;
              System.out.println("");
              System.out.println("Enter in the details of course " + i + " in the below format.");
              System.out.print("<Course department> <course number> <section> <credits>: ");
              //courses[i] = input.next().toUpperCase();
              addCourse = input.nextLine().toUpperCase();
              courses.add(addCourse);
        }
        
        s.setID(id);
        s.setName(name);
        s.setAge(birthYear);
        s.setCourse(courses);
        return s;
    }
    
    public static void main(String[] args) throws IOException{
    
        Scanner input = new Scanner(System.in);
        
        ArrayList<Student> studentDB = new ArrayList<Student>();
        int lineNum = 0;
        String nextVal = "";
          
        //------------Accepts CMD args and 
        File inputFile = new File(args[0]);
        Scanner read = new Scanner(inputFile).useDelimiter(",");
        //System.out.println("Loading file");
        
        //checks to see if the input file exists
        //if it does, it loads the contents into the students arraylist
        //creates text file if doesn't exist
        try {
            if (inputFile.createNewFile()) {
                //System.out.println(inputFile.getName() + " File is created! ");
            } else {
                while(read.hasNextLine()){
                Student readS = new Student();
                String line = read.nextLine();
                    if(line.contains("%,,%")){
                        line.replace(",,", ",");
                    }
                String[] data = line.split(",");    
                String readID = data[0];
                String readName = data[1];
                String readAge = data[2];
                
                int dataCounter = 3;
                ArrayList<String> readCourse = new ArrayList<String>();
                    while(dataCounter < data.length){
                        nextVal = data[dataCounter];
                        readCourse.add(nextVal);
                        dataCounter++;
                    }
                
                readS.setID(Integer.valueOf(readID));
                readS.setName(readName);
                readS.setAge(Integer.valueOf(readAge));
                readS.setCourse(readCourse);
                studentDB.add(readS);
                //read.nextLine();
                }   
                //System.out.println(inputFile.getName() + " File already exists! ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println("File Loaded.");

        int option = 0;
        
        while(option != 7){
        
            
            System.out.println("");
            System.out.println("DATABASE OF STUDENTS!");
            System.out.println("=====================");
            System.out.println("Choose from the menu of options below:");
            System.out.println("1. Print all student details.");
            System.out.println("2. Add a student record.");
            System.out.println("3. Search for a student.");
            System.out.println("4. Delete a student record.");
            System.out.println("5. Update a student record");
            System.out.println("6. Save to a file.");
            System.out.println("7. Exit the database.");
            System.out.println("");
            
            System.out.print("Please enter in your choice: ");
            option = input.nextInt();
            
            switch(option){
                case 1:

                    StudentView view = new StudentView();
                    Student temp;
                    
                    System.out.println(" ");
                    System.out.println("ALL STUDENTS RECORDS:");
                    System.out.println("=====================");
                    System.out.println(" ");
                    
                    if(studentDB.isEmpty()){
                        System.out.println("No records found in database");
                    }
                    for(int i=0; i < studentDB.size(); i++){
                    temp = studentDB.get(i);
                        view.printStudentDetails(temp);
                        System.out.println(" ");
                     
                    }
                    
                    //System.out.println("Option 1");
                    break;
                case 2:
                    
                    int id = 1;
                    int[] idList = new int[studentDB.size()];
                    //Fills an array of all the id's in the database
                        for(int i=0; i < studentDB.size(); i++){
                        Student temp2 = studentDB.get(i);
                            idList[i] = temp2.getID();
                            //System.out.println(idList[i]);
                        }
                        //sorts the array of id's in ascending order
                        Arrays.sort(idList);
                        //searches for available id that is not taken
                        for(int i = 0; i < idList.length; i++){
                            if(id != idList[i]){
                                break;
                            }else{
                                id++;
                            }
                        }
                        
//                        for(int i =0; i < idList.length; i++){
//                            System.out.print(i+", ");
//                        }
                        
                        
                        
                    Student s = createStudent(id);
                    studentDB.add(s);
                    System.out.println(" ");
                    System.out.println("Student added");
                    
                    
                    //System.out.println("Option 2");
                    break;
                case 3:
                    SearchContext context = new SearchContext();
                    SearchID searchID = new SearchID();
                    SearchName searchName = new SearchName();
                    SearchAge searchAge = new SearchAge();
                    SearchCourse searchCourse = new SearchCourse();
                    int searchOption = 0;
                    
                    if(searchOption != 9){
                        System.out.print("Search based on ID(1), name(2), age(3), course(4): ");
                        searchOption = input.nextInt();
                        
                        switch(searchOption){
                    
                            case 1:
                                context = new SearchContext(searchID);
                                context.executeStrategy(studentDB);
                                searchOption = 9;
                                break;
                            case 2:
                                context = new SearchContext(searchName);
                                context.executeStrategy(studentDB);
                                searchOption = 9;
                                break;
                            case 3:
                                context = new SearchContext(searchAge);
                                context.executeStrategy(studentDB);
                                searchOption = 9;
                                break;
                            case 4:
                                context = new SearchContext(searchCourse);
                                context.executeStrategy(studentDB);
                                searchOption = 9;
                                break;
                        }
                    }
                    
                    //System.out.println("Option 3");
                    break;
                case 4:
                    int deleteID;
                    int idCounter = 0;
                    System.out.print("Enter in the ID of the student to be removed: ");
                    deleteID = input.nextInt();
                    
                    
                        for(int i = 0; i < studentDB.size(); i++){
                        Student ds = studentDB.get(i);
                            if(deleteID == ds.getID()){
                                studentDB.remove(ds);
                                System.out.println("Student has been removed.");
                            }else{
                                idCounter++;
                            }  
                        }
                        if(idCounter == studentDB.size()){
                            System.out.println(" ");
                            System.out.println("Student is not in the Database.");
                        }                    
                    //System.out.println("Option 4");
                    break;    
                case 5:
                    int guideID;
                    int choice;
                    InfoMod modContext = new InfoMod();
                    ModName modName = new ModName();
                    ModBirthYear modBY = new ModBirthYear();
                    ModAddCourse addCourse = new ModAddCourse();
                    ModDeleteCourse delCourse = new ModDeleteCourse();
                    
                    System.out.print("Enter the ID of the student to be updated: ");
                    guideID = input.nextInt();
                    System.out.print("Update name(1), year of birth(2), courses(3): ");
                    choice = input.nextInt();
                    
                    if(choice == 1){
                        modContext = new InfoMod(modName);
                        modContext.executeMod(studentDB, guideID);
                    }
                    if(choice == 2){
                        modContext = new InfoMod(modBY);
                        modContext.executeMod(studentDB, guideID);
                    }
                    if(choice == 3){
                        int addDel;
                        System.out.print("Add(1) or Remove(2) a course: ");
                        addDel = input.nextInt();
                            if(addDel == 1){
                                modContext = new InfoMod(addCourse);
                                modContext.executeMod(studentDB, guideID);
                            }
                            if(addDel == 2){
                                modContext = new InfoMod(delCourse);
                                modContext.executeMod(studentDB, guideID);
                            }
                    }
                    
                    
                    //System.out.println("Option 5");
                    break;
                case 6:
                            try {
                            FileWriter writer = new FileWriter(inputFile, false);
                            BufferedWriter bWriter = new BufferedWriter(writer);
                            
                            
                            for(int i = 0; i < studentDB.size(); i++){
                                Student tempS = studentDB.get(i);
                            
                             bWriter.write(Integer.toString(tempS.getID()));
                             bWriter.write(",");
                             bWriter.write(tempS.getName());
                             bWriter.write(",");
                             bWriter.write(Integer.toString(tempS.getAge()));
                             //bWriter.write(",");
                                for(int j = 0; j<tempS.getCourse().size(); j++){
                                    bWriter.write(",");
                                    bWriter.write(tempS.getCourse().get(j));
                                }
                                bWriter.write("\n");
                                
                             } 
                            bWriter.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                        }

                    System.out.println("Database saved to " + inputFile.getName());
                    break;
                case 7:
                    
                    System.out.println("Goodbye");
                    break;
            }
        }
        
        
    }
}
