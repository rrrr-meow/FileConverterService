package service.converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;
import lombok.val;
import service.structure.JSON.BookJSON;
import service.structure.JSON.BooksJSON;
import service.structure.JSON.TitleJSON;
import service.structure.XML.LibraryXML;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class Json {
    @SneakyThrows
    public BooksJSON read(final StringReader in) {
        val jsonMapper = new JsonMapper();
        return jsonMapper.readValue(in, new TypeReference<>() {});
    }
    public void write(final LibraryXML library, final File out) throws IOException {
        val books = writeToJson(library);
        val jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.writeValue(out, books);
    }

    private static BooksJSON writeToJson(final LibraryXML library) {
        return BooksJSON.builder()
                .books(library.getGenre().stream()
                        .flatMap(genresXML -> genresXML.getBooks().getBook().stream()
                                .map(bookXML -> TitleJSON.builder()
                                        .title(bookXML.getTitle())
                                        .book(BookJSON.builder()
                                                .genre(genresXML.getGenre())
                                                .author(bookXML.getAuthor())
                                                .year(bookXML.getYear())
                                                .build())
                                        .build()))
                        .toList())
                .build();
    }
}
