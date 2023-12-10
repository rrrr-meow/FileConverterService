package service.readers;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

public interface Reader {
    Object read(String in) throws JAXBException, FileNotFoundException;
}
