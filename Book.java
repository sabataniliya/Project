package temp;

public class Book {
    int bookId;
    String tittle;
    String authorSurname; 
    String authorName; 
    String purchaseDate; 
    String status;

    public Book(int bookId, String tittle, String authorSurname, String authorName, String purchaseDate, String status) {
        this.bookId = bookId;
        this.tittle = tittle;
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public String getAuthorFirstName() {//getAuthorFirsName()
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public int getBookId() {
        return bookId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public String getTittle() {
        return tittle;
    }

    public void setAuthorFirstName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    
    
}
