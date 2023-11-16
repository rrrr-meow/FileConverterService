package service.converters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface Converter {
    void Convert(String in, String out) throws JAXBException, FileNotFoundException;
}
