package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    private int bookId;

    private String[] booksName;

    private List<Game> listOfGames;

    public Book() {
    }

    public Book(int bookId, String[] booksName, ArrayList<Game> listOfGames) {
        this.bookId = bookId;
        this.booksName = booksName;
        this.listOfGames = listOfGames;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String[] getBooksName() {
        return booksName;
    }

    public void setBooksName(String[] booksName) {
        this.booksName = booksName;
    }

    public List<Game> getListOfGames() {
        return listOfGames;
    }

    public void setListOfGames(ArrayList<Game> listOfGames) {
        this.listOfGames = listOfGames;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", booksName=" + Arrays.toString(booksName) +
                ", listOfGames=" + listOfGames +
                '}';
    }
}