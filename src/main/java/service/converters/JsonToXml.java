package service.converters;

import lombok.val;
import service.readers.ReadJSON;
import service.structure.JSON.BooksJSON;
import service.structure.XML.BookXML;
import service.structure.XML.BooksXML;
import service.structure.XML.GenresXML;
import service.structure.XML.LibraryXML;
import service.writers.WriteXML;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonToXml implements Converter {
    @Override
    public void convert(String in, String out) throws FileNotFoundException {
        val readJson = new ReadJSON();
        val books = readJson.read(in);
        val writeXml = new WriteXML();
        writeXml.write(getGenres(books), out);
    }

    public LibraryXML getGenres(final BooksJSON books) {
        return LibraryXML.builder()
                .genre(books.getBooks().stream()
                        .map(titleJSON -> GenresXML.builder()
                                .genre(titleJSON.getBook().getGenre())
                                .books(BooksXML.builder()
                                        .book(Collections.singletonList(BookXML.builder()
                                                .author(titleJSON.getBook().getAuthor())
                                                .title(titleJSON.getTitle())
                                                .year(titleJSON.getBook().getYear())
                                                .build()))
                                        .build())
                                .build())
                        .collect(Collectors.groupingBy(GenresXML::getGenre, Collectors.toSet()))
                        .entrySet()
                        .stream()
                        .map(entry -> GenresXML.builder()
                                .genre(entry.getKey())
                                .books(BooksXML.builder()
                                        .book(entry.getValue().stream()
                                                .map(GenresXML::getBooks)
                                                .flatMap(booksXML -> booksXML.getBook().stream())
                                                .toList())
                                        .build())
                                .build())
                        .toList())
                .build();
    }
}
