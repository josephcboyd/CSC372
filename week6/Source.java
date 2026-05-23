import java.util.ArrayList;
import java.util.Comparator;

public class Source{
    public static void selectionSort(ArrayList<Student> studentList, Comparator<Student> compareType) {
        int n = studentList.size();
        for (int i = 0; i < n - 1; i++){ //loops once for each object in arraylist
            int minIdx = i;
            for (int j = i + 1; j < n; j++) { //compares each object against all others
                if (compareType.compare(studentList.get(j),studentList.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            Student temp = studentList.get(minIdx);
            studentList.set(minIdx, studentList.get(i));
            studentList.set(i, temp);  
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Student s1 = new Student();  //example students for the array
        s1.setName("Charlie");
        s1.setRollno(3);
        s1.setAddress("123 Main St");
        studentList.add(s1);

        Student s2 = new Student();
        s2.setName("Alice");
        s2.setRollno(5);
        s2.setAddress("456 Oak Ave");
        studentList.add(s2);

        Student s3 = new Student();
        s3.setName("Eve");
        s3.setRollno(1);
        s3.setAddress("789 Pine Rd");
        studentList.add(s3);

        Student s4 = new Student();
        s4.setName("Bob");
        s4.setRollno(4);
        s4.setAddress("321 Elm St");
        studentList.add(s4);

        Student s5 = new Student();
        s5.setName("Diana");
        s5.setRollno(2);
        s5.setAddress("654 Maple Dr");
        studentList.add(s5);

        System.out.println("\ncurrent order");
        for (Student student : studentList){ //prints out current array order
                System.out.println(student.name);
            }
        
        selectionSort(studentList, new CompareNames());
        System.out.println("\nafter name sort");
        for (Student student : studentList){  //prints out new array order after name sort
                System.out.println(student.name);
            }

        selectionSort(studentList, new CompareRollNo());
        System.out.println("\nafter roll no sort");
        for (Student student : studentList){  //prints out new array order after roll sort
                System.out.println(student.name);
                System.out.println(student.rollno);
            }
        }
}