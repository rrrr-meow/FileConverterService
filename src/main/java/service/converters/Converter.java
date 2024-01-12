package service.converters;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public interface Converter {
    void convert(StringReader in, File out) throws JAXBException, IOException;
}
