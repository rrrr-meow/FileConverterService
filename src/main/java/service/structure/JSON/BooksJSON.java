package service.structure.JSON;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BooksJSON {
    private List<TitleJSON> books;
}
