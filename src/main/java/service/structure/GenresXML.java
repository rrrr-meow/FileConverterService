package service.structure;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "genre")
public class GenresXML {
    private String genre;
    private BooksXML books;
    @XmlAttribute(name = "genre")
    public String getGenre() {
        return this.genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @XmlElement
    public BooksXML getBooks() {
        return this.books;
    }
    public void setBooks(BooksXML books) {
        this.books = books;
    }
    public Boolean isNull()
    {
        if (genre == null && books == null) return true;
        else return false;
    }
}
