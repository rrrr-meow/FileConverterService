package service.structure;

import lombok.Data;
import java.util.List;

@Data
public class BooksJSON {
    private List<TitleJSON> books;
}
