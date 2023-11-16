package service.converters;

import service.readers.ReadJSON;
import service.structure.BooksJSON;
import service.writers.WriteXML;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class JsonToXml implements Converter{
    @Override
    public void Convert(String in, String out) throws JAXBException, FileNotFoundException {
        ReadJSON read = new ReadJSON();
        BooksJSON books = read.read(in);
        WriteXML write = new WriteXML();
        write.write(books,out);
    }
}
