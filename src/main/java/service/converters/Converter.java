package service.converters;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public interface Converter {
    void convert(File in, File out) throws JAXBException, IOException;
}
