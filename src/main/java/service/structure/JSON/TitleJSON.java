package service.structure.JSON;

import lombok.Builder;
import lombok.Data;
import service.structure.JSON.BookJSON;

import java.util.List;

@Data
@Builder
public class TitleJSON {
    private String title;
    private BookJSON book;
    public boolean isNull()
    {
        return title == null && book == null;
    }
}
