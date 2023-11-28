package service.writers;

import lombok.SneakyThrows;
import service.structure.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriteXML implements Writer{
    @SneakyThrows
    @Override
    public void write(LibraryXML libraryXML, String out) {
        JAXBContext context = JAXBContext.newInstance(LibraryXML.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(libraryXML, new File(out));
    }
}
