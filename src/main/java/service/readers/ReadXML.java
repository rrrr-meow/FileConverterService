package service.readers;

import lombok.val;
import service.structure.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class ReadXML implements Reader {
    @Override
    public LibraryXML read(String in) throws JAXBException {
        return readXml(in);
    }

    private LibraryXML readXml(String in) throws JAXBException {
        val file = new File(in);
        return (LibraryXML) JAXBContext.newInstance(LibraryXML.class)
                .createUnmarshaller().unmarshal(file);
    }
}
