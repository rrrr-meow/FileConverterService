package service.writers;

import service.structure.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriteXML implements Writer{
    @Override
    public void write(LibraryXML libraryXML, String out) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(LibraryXML.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(libraryXML, new File(out));
    }
}
