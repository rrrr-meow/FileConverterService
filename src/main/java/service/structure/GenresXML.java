package service.structure;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "genre")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenresXML {
    @XmlAttribute(name = "genre")
    private String genre;
    @XmlElement
    private BooksXML books;
}
