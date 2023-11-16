package service.writers;

import service.structure.BooksJSON;

import javax.xml.bind.JAXBException;

public interface Writer {
    void write(BooksJSON books, String out) throws JAXBException;
}
