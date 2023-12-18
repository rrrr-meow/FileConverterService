package service.converters;

import lombok.SneakyThrows;
import lombok.val;
import service.structure.XML.LibraryXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Xml {
    private static final JAXBContext JAXB_CONTEXT = initJAXBContext();

    private static JAXBContext initJAXBContext() {
        try{
            return JAXBContext.newInstance(LibraryXML.class);
        }
        catch (JAXBException e){
            throw new RuntimeException("Ошибка при создании JAXBContext");
        }
    }

    public LibraryXML read(File in) throws JAXBException {
        return (LibraryXML) JAXB_CONTEXT.createUnmarshaller().unmarshal(in);
    }
    @SneakyThrows
    public void write(LibraryXML libraryXML, File out) {
        val marshaller = JAXB_CONTEXT.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(libraryXML, out);
    }
}
