package service.converters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface Converter {
    void convert(String in, String out) throws JAXBException, FileNotFoundException;
}
