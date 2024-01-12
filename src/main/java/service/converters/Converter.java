package service.converters;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Converter {
    void convert(InputStream in, OutputStream out) throws JAXBException, IOException;
}
