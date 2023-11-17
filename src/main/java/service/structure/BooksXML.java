package service.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "books")
public class BooksXML {
    private List<BookXML> books;
    @XmlElement(name="book")
    public List<BookXML> getBooks() {
        return books;
    }
    public void setBooks(List<BookXML> books) {
        this.books = books;
    }
}
