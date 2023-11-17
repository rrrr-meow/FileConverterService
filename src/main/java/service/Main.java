package service;

import service.converters.Converter;
import service.converters.JsonToXml;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import service.converters.XmlToJson;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        String fileName = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\main\\resources\\"
                + "Json" + ".json";
        String fileName2 = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\main\\resources\\"
                + "h1" + ".xml";
        JsonToXml s = new JsonToXml();
        s.Convert(fileName, fileName2);

        fileName = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\main\\resources\\"
                + "Xml" + ".xml";String fileName2 = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\main\\resources\\"
                + "h" + ".json";
        XmlToJson s = new XmlToJson();
        s.Convert(fileName, fileName2);
    }
}