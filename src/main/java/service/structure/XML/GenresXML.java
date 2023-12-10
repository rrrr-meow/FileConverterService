package service.structure.XML;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@Builder
@AllArgsConstructor // Добавьте эту аннотацию
@NoArgsConstructor
@XmlRootElement(name = "genre")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenresXML {
    @XmlAttribute(name = "genre")
    private String genre;
    @XmlElement
    private BooksXML books;


    public static GenresXMLBuilder builder() {
        return new GenresXMLBuilder();
    }
}
