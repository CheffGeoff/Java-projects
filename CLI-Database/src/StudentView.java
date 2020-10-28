
public class StudentView {
    
    public void printStudentDetails(Student s){
        System.out.println("Name: " + s.getName());
        System.out.println("ID: " + s.getID());
        System.out.println("Age: " + (2020 - s.getAge()));
        System.out.print("Courses: ");
            for(int i=0; i < s.getCourse().size(); i++){
                System.out.println("     " + s.getCourse().get(i));
            }
    }    
}
