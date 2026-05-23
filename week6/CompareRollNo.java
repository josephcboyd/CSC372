import java.util.Comparator;

public class CompareRollNo implements Comparator<Student>{
    @Override
    public int compare(Student studentOne, Student studentTwo) {
        int rollOne = studentOne.getRollno();
        int rollTwo = studentTwo.getRollno();
        
        return Integer.compare(rollOne, rollTwo);
    }

}