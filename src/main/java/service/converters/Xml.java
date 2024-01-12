package service.converters;

import lombok.SneakyThrows;
import lombok.val;
import service.structure.XML.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class Xml {
    private static final JAXBContext JAXB_CONTEXT = initJAXBContext();
    @SneakyThrows
    private static JAXBContext initJAXBContext(){
        return JAXBContext.newInstance(LibraryXML.class);
    }

    public LibraryXML read(final StringReader in) throws JAXBException {
        return (LibraryXML) JAXB_CONTEXT.createUnmarshaller().unmarshal(in);
    }
    @SneakyThrows
    public void write(final LibraryXML libraryXML, final FileOutputStream out) {
        val marshaller = JAXB_CONTEXT.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(libraryXML, out);
    }
}
