package service.converters;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Converter {
    void convert(StringReader in, FileOutputStream out) throws JAXBException, IOException;
}
