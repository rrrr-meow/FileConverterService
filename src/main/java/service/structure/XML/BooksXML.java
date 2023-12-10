package service.structure.XML;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@Builder
@AllArgsConstructor // Добавьте эту аннотацию
@NoArgsConstructor
@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class BooksXML {
    @XmlElement(name="book")
    private List<BookXML> book;


    public static BooksXMLBuilder builder() {
        return new BooksXMLBuilder();
    }
}
