package service.writers;

import service.structure.XML.LibraryXML;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Writer {
    void write(LibraryXML libraryXML, String out) throws JAXBException, IOException;
}
