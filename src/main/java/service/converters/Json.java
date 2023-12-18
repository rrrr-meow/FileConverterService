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
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Json {
    @SneakyThrows
    public BooksJSON read(File in){
        val jsonMapper = new JsonMapper();
        return jsonMapper.readValue(in, new TypeReference<>() {
        });
    }
    public void write(LibraryXML library, File out) throws IOException {
        val books = writeToJson(library);
        val jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.writeValue(out, books);
    }

    private static BooksJSON writeToJson(LibraryXML library) {
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
