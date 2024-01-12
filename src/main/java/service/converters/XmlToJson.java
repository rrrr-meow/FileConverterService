package service.converters;

import lombok.val;

import javax.xml.bind.JAXBException;

import java.io.*;

public class XmlToJson implements Converter {
    @Override
    public void convert(final StringReader in, final FileOutputStream out) throws JAXBException, IOException {
        val readXML = new Xml();
        val writeJSON = new Json();
        val library = readXML.read(in);
        writeJSON.write(library, out);
    }
}
