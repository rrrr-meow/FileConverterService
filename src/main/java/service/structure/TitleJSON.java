package service.structure;

import java.util.List;

public class TitleJSON {
    private String title;
    private List<BookJSON> book;

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<BookJSON> getBook() {
        return this.book;
    }
    public void setBook(List<BookJSON> book) {
        this.book = book;
    }
}
