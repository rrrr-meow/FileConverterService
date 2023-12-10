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
@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryXML {
    @XmlElement(name = "genre")
    private List<GenresXML> genre;

    public static LibraryXMLBuilder builder() {
        return new LibraryXMLBuilder();
    }
}
