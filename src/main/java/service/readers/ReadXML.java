package service.readers;

import service.structure.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReadXML implements Reader{
    @Override
    public LibraryXML read(String in) throws JAXBException{
        return ReadXml(in);
    }
    private LibraryXML ReadXml(String in) throws JAXBException{
        File file = new File(in);
        JAXBContext context = JAXBContext.newInstance(LibraryXML.class);

        Unmarshaller unm = context.createUnmarshaller();
        return (LibraryXML) unm.unmarshal(file);
    }
}
