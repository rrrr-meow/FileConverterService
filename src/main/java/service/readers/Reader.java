package service.readers;

import service.structure.BooksJSON;
import java.io.FileNotFoundException;

public interface Reader {
    Object read(String in) throws FileNotFoundException;
}
