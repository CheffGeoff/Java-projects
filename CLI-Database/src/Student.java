
import java.util.ArrayList;

public class Student {
    
    private int id;
    private String name;
    private int age;
    //private String[] course;
    
    private ArrayList<String> course = new ArrayList<String>();
    
//    public Student(int id, String name, String dob, String[] course){
//            this.id = id;
//            this.name = name;
//            this.dob = dob;
//            this.course = course;
//    }
    
    
    public int getID(){
        return id;   
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public ArrayList<String> getCourse(){
        return course;
    }
    
    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public void setCourse(ArrayList<String> course){
        this.course = course;
    }

    
    
    public void toString(Student s){
    
        
//        System.out.println("Name: " + s.getName());
//        System.out.println("ID: " + s.getID());
//        System.out.println("Age: " + s.getAge());
//        System.out.println("Courses: ");
//            for(int i=0; i < s.getCourse().size(); i++){
//                String temp1 = s.getCourse().get(i);
//                System.out.println(temp1);
//            }
    }
    
}
