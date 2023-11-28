package service;

import lombok.experimental.UtilityClass;
import service.converters.Converter;
import service.converters.JsonToXml;
import service.converters.XmlToJson;


@UtilityClass
public class ConvertingSelector {
    public static Converter choiseConverter(final String sourceFilePath, final String destinationFilePath) {
        if (isFileRequried(sourceFilePath) && isFileRequried(destinationFilePath))
            return switch (Types.choiseType(sourceFilePath, destinationFilePath)) {
                case XML_TO_JSON -> new XmlToJson();
                case JSON_TO_XML -> new JsonToXml();
                case INCORRECT -> null;
            };
        return null;
    }

    private static boolean isFileRequried(String filePath) {
        return filePath != null && (filePath.endsWith(".xml") || filePath.endsWith(".json"));
    }
}
