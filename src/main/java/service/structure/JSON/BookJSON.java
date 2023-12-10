package service.structure.JSON;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookJSON {
    private String genre;
    private String author;
    private Integer year;
}
