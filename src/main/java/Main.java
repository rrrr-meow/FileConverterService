import lombok.extern.slf4j.Slf4j;
import service.FileConverter;

@Slf4j
public class Main {
    public static void main(String[] args) {
        FileConverter.fileConvert(args);
    }
}