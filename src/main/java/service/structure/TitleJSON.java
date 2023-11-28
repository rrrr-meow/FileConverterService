package service.structure;

import lombok.Data;

@Data
public class TitleJSON {
    private String title;
    private BookJSON book;
    public Boolean isNull()
    {
        return title == null && book == null;
    }
}
