package service.writers;

import service.structure.LibraryXML;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface Writer {
    void write(LibraryXML libraryXML, String out) throws JAXBException, FileNotFoundException;
}
