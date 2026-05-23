public class Student {
    int rollno;
    String name;
    String address;

    public void student(int rollno, String name, String address) { //constructor
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() { //getters and setters
        return this.rollno;
    }

    public void setRollno(int value) {
        this.rollno = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String value) {
        this.address = value;
    }


}