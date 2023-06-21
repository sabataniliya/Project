package temp;

public class Student {
   int  id;
   String  surname;
   String  lastName;
   int age;

    public Student(int id, String surname, String lastName, int age) {
        this.id = id;
        this.surname = surname;
        this.lastName = lastName;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }
    
    
}
