package service.writers;

import service.structure.LibraryXML;

import java.io.FileNotFoundException;
import java.util.List;

public interface Writer {
    void write(LibraryXML library, String out) throws FileNotFoundException;
}
