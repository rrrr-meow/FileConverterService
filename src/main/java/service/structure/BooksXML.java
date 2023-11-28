package service.structure;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class BooksXML {
    @XmlElement(name="book")
    private List<BookXML> books;
}
