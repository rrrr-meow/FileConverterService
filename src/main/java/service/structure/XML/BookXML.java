package service.structure.XML;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@AllArgsConstructor // Добавьте эту аннотацию
@NoArgsConstructor
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookXML {
    @XmlElement
    private String author;
    @XmlElement
    private String title;
    @XmlElement
    private Integer year;



    public static BookXMLBuilder builder() {
        return new BookXMLBuilder();
    }
}
