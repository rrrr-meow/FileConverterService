package service.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class LibraryXML {
    private List<GenresXML> genre;
    @XmlElement(name = "genre")
    public List<GenresXML> getGenre() {
        return this.genre;
    }
    public void setGenre(List<GenresXML> genre) {
        this.genre = genre;
    }
}
