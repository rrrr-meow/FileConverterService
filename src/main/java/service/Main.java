package service;

import service.converters.XmlToJson;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        String fileName = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\main\\resources\\"
                + "Xml" + ".xml";
        String fileName2 = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\main\\resources\\"
                + "h" + ".json";
        XmlToJson s = new XmlToJson();
        s.Convert(fileName, fileName2);
    }
}