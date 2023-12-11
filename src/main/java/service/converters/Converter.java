package service.converters;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Converter {
    void convert(String in, String out) throws JAXBException, IOException;
}
