package service.converters;

import lombok.val;

import javax.xml.bind.JAXBException;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XmlToJson implements Converter {
    @Override
    public void convert(final StringReader in, final File out) throws JAXBException, IOException {
        val readXML = new Xml();
        val writeJSON = new Json();
        val library = readXML.read(in);
        writeJSON.write(library, out);
    }
}
