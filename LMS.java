package temp;
import java.util.ArrayList;
import java.util.Scanner;
public class LMS {

    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public static ArrayList<Book> bookList = new ArrayList<Book>();
    public static ArrayList<Book> borrowList = new ArrayList<Book>();
 
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat) {
            System.out.println("------------------------------------------------------");
            System.out.println("-------WELCOME TO OUR LIBRARY MANAGEMENT SYSTEM-------");
            System.out.println("------------------------------------------------------");
            System.out.println("----------Please choose one of below Options----------");
            System.out.println("1. Add Student");
 
            System.out.println("2. Add Book");
            System.out.println("3. Display All Students");
 
            System.out.println("4. Display All Books");
            System.out.println("5. Search Student");
 
            System.out.println("6. Search Book");
            System.out.println("7. Borow Book");
            System.out.println("8. Display All Borow Book");
            System.out.println("9. Return Book");
            System.out.println("10. Exit");
            System.out.print("your choice: ");
            int option = br.nextInt();
            System.out.println("------------------------------------------------------");
            switch (option) {
                case 1:
                    System.out.println("Enter Student Id");
                    int id = br.nextInt();
                    boolean chekId = checkStudentId(id);
                    if (chekId) {
                        System.out.println("StudentId Already Exist");
                        break;
                    }
                    br.nextLine();
                    System.out.println("Enter Student FirstName");
                    String surname = br.nextLine();
                    System.out.println("Enter Student lastName");
                    String lastName = br.nextLine();
                    System.out.println("Enter Student Age");
                    int age = br.nextInt();
                    Student s1 = new Student(id, surname, lastName, age);
                    studentList.add(s1);
                    break;
 
                case 2:
                    System.out.println("Enter Book Id :");
                    int bookId = br.nextInt();
                    boolean chekBookId = checkBookId(bookId);
                    if (chekBookId) {
                        System.out.println("Book Id Already Exist");
                        break;
                    }
                    br.nextLine();
                    System.out.println("Enter Book tittle");
                    String tittle = br.nextLine();
                    System.out.println("Enter author FirstName");
                    String authorSurname = br.nextLine();
                    System.out.println("Enter author lastName");
                    String authorName = br.nextLine();
                    System.out.println("Enter Book Purchase Date");
                    String purchaseDate = br.nextLine();
                    System.out.println("Enter Book Availability :");
                    String status = br.nextLine();
                    Book b = new Book(bookId, tittle, authorSurname, authorName, purchaseDate, status) {
                    }; 
                    bookList.add(b);
                    break;
                case 3:
                    displayAllStudent();
                    break;
 
                case 4:
                    displayAllBook();
                    break;
                case 5:
                    System.out.println("Please Enter student Id, you want to Search");
                    int searchStudentId = br.nextInt();
                    searchStudent(searchStudentId);
                    break;
 
                case 6:
                    System.out.println("Please Enter Book Id, you want to Search");
                    int searchBookId = br.nextInt();
                    searchBook(searchBookId);
                    break;
                case 7:
                    borrowBook();
                    break;
                case 8:
                    DisplayborrowBook();
                    break;
                case 9:
                    returnBook();
                    break;
                case 10:
                     repeat =false;
                    break;
            }
        }
    }
  //////////////////case 9////////////////
    public static void returnBook() {
        Scanner br = new Scanner(System.in);
        try {
            System.out.println("---------------------");
            System.out.println("Please enter Student Id:");
            int id = br.nextInt();
            System.out.println("Please enter Book Id:");
            int bookId = br.nextInt();
            for (int i = 0; i < borrowList.size(); i++) {
                if (borrowList.get(i).getBookId() == bookId) {
 
                    borrowList.get(i).setStatus("AVAILABLE");
                    borrowList.remove(i);
                    break;
                }
            }
 
        } catch (NumberFormatException e) {
            System.err.println("error. " + e);
        }
    }
  //////////////////case 8////////////////
    public static void DisplayborrowBook() {
        for (Book book : borrowList) {
            System.out.println("Book Id:  " + book.getBookId() + " Tittle: " + book.getTittle() + " Auhtor Surname: " + book.getAuthorSurname()
                    + " Author FirstName: " + book.getAuthorFirstName() + " Purchase Date: " + book.getPurchaseDate() + " staus: " + book.getStatus());
        }
    }
  //////////////////case 7////////////////
    public static void borrowBook() {
        Scanner br = new Scanner(System.in);
        System.out.println("----List of all Available book as Below----");
        for (Book book : bookList) {
            if (book.getStatus().equalsIgnoreCase("AVAILABLE")) {
                System.out.println("Book Id: " + book.getBookId() + " Tittle: " + book.getTittle() + " Auhtor Surname: " + book.getAuthorSurname()
                        + " Author FirstName: " + book.getAuthorFirstName() + " Purchase Date: " + book.getPurchaseDate() + " staus: " + book.getStatus());
            }
        }
        System.out.println("---------------------");
        System.out.println("Please enter Student Id:");
        int id = br.nextInt();
        System.out.println("Please enter Book Id:");
        int bookId = br.nextInt();
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                borrowList.add(book);
                book.setStatus("Not AVAILABLE");
            }
        }
    }
  //////////////////case 6////////////////
    public static void searchBook(int searchBookId) {
        boolean search = true;
        for (Book book : bookList) {   // for (int i = 0; i < bookList.size(); i++) 
            if (book.getBookId() == searchBookId) {
                System.out.println("Book Id: " + book.getBookId() + " Tittle : " + book.getTittle() + " Auhtor Surname: " + book.getAuthorSurname()
                        + " Author FirstName: " + book.getAuthorFirstName() + " Purchase Date: " + book.getPurchaseDate() + " staus: " + book.getStatus());
                search = false;
            }
        }
        if (search) {
            System.out.println(searchBookId + " Not exist");
        }
    }
  //////////////////case 5////////////////
    public static void searchStudent(int searchStudentId) {
        boolean search = true;
        for (Student st : studentList) {
            if (st.getStudentId() == searchStudentId) {
                System.out.println("Student Id: " + st.getStudentId() + " FirstName: " + st.getSurname() + " lastName: " + st.getLastName()
                        + " Age: " + st.getAge());
                search = false;
            }
        }
        if (search) {
            System.out.println(searchStudentId + " Not exist");
        }
    }
  //////////////////case 4////////////////
    public static void displayAllBook() {  // for (int i = 0; i < bookList.size(); i++) 
        for (Book book : bookList) {
            System.out.println("Book Id: " + book.getBookId() + " Tittle: " + book.getTittle() + " Auhtor Surname: " + book.getAuthorSurname()
                    + " Author FirstName: " + book.getAuthorFirstName() + " Purchase Date: " + book.getPurchaseDate() + " staus: " + book.getStatus());
        }
    }
  //////////////////case 3////////////////
    public static void displayAllStudent() {
        for (Student st : studentList) {
            System.out.println("Student Id: " + st.getStudentId() + " FirstName: " + st.getSurname() + " lastName: " + st.getLastName()
                    + " Age: " + st.getAge());
        }
    }
  //////////////////case 2////////////////
    public static boolean checkBookId(int bookId) {
        for (Book book : bookList) {  // for (int i = 0; i < bookList.size(); i++) 
            if (book.getBookId() == bookId) {
                return true;
            }
        }
        return false;
    }
 //////////////////case 1////////////////
    public static boolean checkStudentId(int id) {
        for (Student st : studentList) {
            if (st.getStudentId() == id) {
                return true;
            }
        }
        return false;
    }
}
  
