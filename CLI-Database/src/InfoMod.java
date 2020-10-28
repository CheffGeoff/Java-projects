import java.util.*;

interface iMod{
    void execute(ArrayList<Student> studentDB, int id);
}

class ModName implements iMod{
    Scanner input = new Scanner(System.in);
    
    @Override
    public void execute(ArrayList<Student> studentDB, int id) {
       String name = null;
       
        for(int i = 0; i< studentDB.size(); i++){
        Student s = studentDB.get(i);
            if(id == s.getID()){
                System.out.print("Enter a new name: ");
                name = input.nextLine().toUpperCase();
                s.setName(name);
            }
        }
       System.out.println("Record updated.");
    }
}

class ModBirthYear implements iMod{
    Scanner input = new Scanner(System.in);
    @Override
    public void execute(ArrayList<Student> studentDB, int id) {
        int dob;
        for(int i = 0; i< studentDB.size(); i++){
        Student s = studentDB.get(i);
            if(id == s.getID()){
                System.out.print("Enter a new year of birth: ");
                dob = input.nextInt();
                s.setAge(dob);
            }
        }
        System.out.println("Record updated.");
    }
}

class ModAddCourse implements iMod{
    Scanner input = new Scanner(System.in);
    
    @Override
    public void execute(ArrayList<Student> studentDB, int id) {
        ArrayList<String> copy = new ArrayList<String>();
        String copy1;
        int counter=0;
        
        for(int i = 0; i < studentDB.size(); i++){
         Student s = studentDB.get(i);
            if(id == s.getID()){
                //Copies contents in order to add course then sets it for studnts ID
                for(int j = 0; j < s.getCourse().size(); j++){
                    copy = (ArrayList<String>) s.getCourse().clone();
                }
                
                System.out.println("Enter the details of the course to be added.");
                System.out.print("<Course department> <course number> <section> <credits>: ");
                copy1 = input.nextLine().toUpperCase();
                
                for(int k =0; k < copy.size();k++){
                    if(copy.get(k).contains(copy1)){
                        System.out.println("Student is already in that class");
                    }
                    else{counter++;}
                }
                if(counter == copy.size()){
                    copy.add(copy1);
                    s.setCourse(copy);
                }
            }
        }
        System.out.println("Record updated.");
        
    }
}

class ModDeleteCourse implements iMod{
Scanner input = new Scanner(System.in);
    @Override
    public void execute(ArrayList<Student> studentDB, int id) {
        String[] temp = new String[1];
        ArrayList<String> copy = new ArrayList<String>();
        int counter = 0;
        
        
        for(int i = 0; i < studentDB.size(); i++){
        Student s = studentDB.get(i);
            if(id == s.getID()){
                //Copy array to modifie
                for(int j = 0; j < s.getCourse().size(); j++){
                    copy = (ArrayList<String>) s.getCourse().clone();
                }
                System.out.println("Enter the details of the course to be removed.");
                System.out.print("<Course department> <course number> <section> <credits>: ");
                temp[0] = input.nextLine().toUpperCase();
                
                //loops thought the courses of the given student ID 
                //and checks to see if the course that is to be deleted
                //is in the list of courses
                for(int k = 0; k < copy.size(); k++){
                    if(copy.get(k).contains(temp[0])){
                        copy.remove(temp[0]);
                        s.setCourse(copy);
                        System.out.println("Course removed.");
                    }else{
                        counter++;
                    }
                }
                if(counter == copy.size()){
                    System.out.println("The student is not taking that class.");
                }

            }
        }    
    }
}


abstract class ModificationObj{

    private iMod mod;
    
    public void setMod(iMod mod){
            this.mod = mod;
    }
    
    public void executeMod(ArrayList<Student> studentDB, int id){
        mod.execute(studentDB, id);
    }
}

public class InfoMod extends ModificationObj {
    
    public InfoMod(iMod mod){
        setMod(mod);
    }
    
    public InfoMod(){}
}
