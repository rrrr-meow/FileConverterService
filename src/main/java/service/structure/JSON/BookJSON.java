package service.structure.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookJSON {
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("author")
    private String author;
    @JsonProperty("year")
    private Integer year;
}
