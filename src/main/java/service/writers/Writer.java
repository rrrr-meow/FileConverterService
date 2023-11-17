package service.writers;

import service.structure.BooksJSON;
import service.structure.LibraryXML;

import javax.xml.bind.JAXBException;

import service.structure.LibraryXML;

import java.io.FileNotFoundException;
import java.util.List;

public interface Writer {
    void write(LibraryXML libraryXML, String out) throws JAXBException, FileNotFoundException;
}
