package service.structure;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookXML {
    @XmlElement
    private String author;
    @XmlElement
    private String title;
    @XmlElement
    private Integer year;
}
