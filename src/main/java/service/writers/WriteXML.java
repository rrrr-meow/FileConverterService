package service.writers;

import lombok.SneakyThrows;
import lombok.val;
import service.structure.XML.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriteXML implements Writer{
    @SneakyThrows
    @Override
    public void write(LibraryXML libraryXML, String out) {
        val context = JAXBContext.newInstance(LibraryXML.class);
        val marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(libraryXML, new File(out));
    }
}
