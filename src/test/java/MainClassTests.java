import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class MainClassTests {
    private final String inputPath = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\test\\resources\\Xml.xml";
    private final String outputPath = "C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\FileConverterService\\src\\test\\resources\\Json.json";

    @Test
    void testCorectArgs() {
        val args = new String[]{inputPath, outputPath};
        Main.main(args);

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
            Main.main(args);

            assertEquals("Неверное количество аргументов! Для автоматического режима введите 2 аргумента, для ручного режима не указывайте аргументы.\r\n", errContent.toString());
        }
        catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
