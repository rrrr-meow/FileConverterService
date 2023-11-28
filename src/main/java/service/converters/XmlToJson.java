package service.converters;

import lombok.val;
import service.readers.ReadXML;
import service.writers.WriteJSON;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class XmlToJson implements Converter{
    @Override
    public void convert(String in, String out) throws JAXBException, FileNotFoundException {
        val readXML = new ReadXML();
        val writeJSON = new WriteJSON();
        val library = readXML.read(in);
        writeJSON.write(library, out);
    }
}
