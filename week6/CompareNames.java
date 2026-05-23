import java.util.Comparator;

public class CompareNames implements Comparator<Student>{ //setting compare for names
    @Override
    public int compare(Student studentOne, Student studentTwo) {
        String nameOne = studentOne.getName();
        String nameTwo = studentTwo.getName();
        
        return nameOne.compareToIgnoreCase(nameTwo); //returns int to be used in sort
    }

}