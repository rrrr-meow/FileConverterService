package service.converters;

import service.readers.ReadXML;
import service.structure.LibraryXML;
import service.writers.WriteJSON;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class XmlToJson implements Converter{
    @Override
    public void Convert(String in, String out) throws JAXBException, FileNotFoundException {
        ReadXML readXML = new ReadXML();
        LibraryXML library = readXML.read(in);
        WriteJSON writeJSON = new WriteJSON();
        writeJSON.write(library, out);
    }
}
