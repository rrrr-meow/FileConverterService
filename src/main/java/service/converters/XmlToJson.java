package service.converters;

import service.readers.ReadXML;
import service.structure.LibraryXML;
import service.writers.WriteXML;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class XmlToJson implements Converter{
    @Override
    public void Convert(String in, String out) throws JAXBException, FileNotFoundException {
        ReadXML readXML = new ReadXML();
        LibraryXML library = readXML.read(in);
        WriteXML writeXML = new WriteXML();
        writeXML.write(library, out);
    }
}
