
import java.util.ArrayList;


public class StudentController {

    private Student model;
    private StudentView view;
    
    public StudentController(Student model){
        this.model = model;
        //this.view = view;
    }
    
    public void setStudentID(int id){
        model.setID(id);
    }
    
    public void setStudentName(String name){
        model.setName(name);
    }
    
    public void setStudentAge(int age){
        model.setAge(age);
    }
    
    public void setStudentCourses(ArrayList<String> course){
        model.setCourse(course);
    }
    
    public int getStudentID(){
        return model.getID();
    }
    
    public String getStudentName(){
        return model.getName();
    }
    
    public int getStudentAge(){
        return model.getAge();
    }
    
    public ArrayList<String> getStudentCourses(){
        return model.getCourse();
    }
    
    public void updateView(){
        view.printStudentDetails(model);
    }
    
}
