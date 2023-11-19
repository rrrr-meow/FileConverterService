package service;

import service.converters.JsonToXml;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import service.converters.XmlToJson;


public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        if (args.length == 2){
            String in = args[0];
            String out = args[1];
            if (in.endsWith(".xml") && out.endsWith(".json")){
                XmlToJson conv = new XmlToJson();
                conv.Convert(in, out);
                System.out.println("Преобразование выполнено успешно!");
            }
            else if (in.endsWith(".json") && out.endsWith(".xml")){
                JsonToXml conv = new JsonToXml();
                conv.Convert(in, out);
                System.out.println("Преобразование выполнено успешно!");
            }
            else{
                System.out.println("Возможны только преобразования из xml в json и из json в xml.");
            }

        }
        else{
            System.out.println("Необходимо ввести 2 аргумента: <исходный файл> <конвертированный файл>");
        }
    }
}