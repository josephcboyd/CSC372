import java.util.Comparator;

public class CompareRollNo implements Comparator<Student>{ //setting compare for roll no
    @Override
    public int compare(Student studentOne, Student studentTwo) {
        int rollOne = studentOne.getRollno();
        int rollTwo = studentTwo.getRollno();
        
        return Integer.compare(rollOne, rollTwo); //returns int to be used in sort
    }

}