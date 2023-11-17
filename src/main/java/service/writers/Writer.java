package service.writers;

import service.structure.BooksJSON;
import service.structure.LibraryXML;

import javax.xml.bind.JAXBException;

public interface Writer {
    void write(LibraryXML libraryXML, String out) throws JAXBException;
}
