package service.readers;

import service.structure.LibraryXML;

import javax.xml.bind.JAXBException;

public interface Reader {
    LibraryXML read(String in) throws JAXBException;
}
