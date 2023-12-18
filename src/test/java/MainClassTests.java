import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.FileConverter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class MainClassTests {
    private final String inputPath = "src\\test\\resources\\Xml.xml";

    @Test
    void testCorectArgs() {
        val outputPath = "src\\test\\resources\\Json.json";
        val args = new String[]{inputPath, outputPath};
        FileConverter.main(args);

        val outputFile = new File(outputPath);
        assertTrue(outputFile.exists());
        outputFile.delete();
    }

    @Test
    void testIncorrectArgs() {
        val errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        try {
            val args = new String[]{inputPath};
            FileConverter.main(args);

            assertEquals("Неверное количество аргументов! Для автоматического режима введите 2 аргумента, для ручного режима не указывайте аргументы.\r\n", errContent.toString());
        }
        catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
