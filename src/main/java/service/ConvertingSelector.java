package service;

import lombok.experimental.UtilityClass;
import org.apache.tika.Tika;
import service.converters.Converter;
import service.converters.JsonToXml;
import service.converters.XmlToJson;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@UtilityClass
public class ConvertingSelector {
    private static final Tika TIKA = new Tika();

    public static Converter choiseConverter(final String sourceFilePath, final String destinationFilePath) throws ConvertingExeption {
        try {
            Optional<String> sourceMimeType = getMimeType(new File(sourceFilePath));
            Optional<String> expectedDestinationMimeType = getExpectedMimeType(destinationFilePath);

            if (sourceMimeType.isPresent() && expectedDestinationMimeType.isPresent()) {
                return  ("application/xml".equals(sourceMimeType.get()) && "application/json".equals(expectedDestinationMimeType.get())) ? new XmlToJson() : new JsonToXml();
            } else {
                throw new ConvertingExeption("MIME-тип исходного или конечного файла не определен");
            }
        } catch (IOException exception) {
            throw new ConvertingExeption("Ошибка при определении MIME-типов", exception);
        }
    }

    private static Optional<String> getMimeType(final File file) throws IOException {
        return Optional.ofNullable(TIKA.detect(file));
    }

    private static Optional<String> getExpectedMimeType(final String filePath) {
        if (filePath.endsWith(".json")) {
            return Optional.of("application/json");
        }
        else if (filePath.endsWith(".xml")) {
            return Optional.of("application/xml");
        } else {
            return Optional.empty();
        }
    }
}
