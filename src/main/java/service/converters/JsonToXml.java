package service.converters;

import lombok.val;
import service.readers.ReadJSON;
import service.structure.JSON.BooksJSON;
import service.structure.JSON.TitleJSON;
import service.structure.XML.BookXML;
import service.structure.XML.BooksXML;
import service.structure.XML.GenresXML;
import service.structure.XML.LibraryXML;
import service.writers.WriteXML;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonToXml implements Converter{
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
                        .toList())
                .build();

        /*val titles = books.getBooks();
        Set<String> genres = new HashSet<>();
        List<GenresXML> genresXMLS = new ArrayList<>();
        GenresXML genre;

        for (TitleJSON titleJSON : titles) {
            val book = titleJSON.getBook();
            genres.add(book.getGenre());
        }

        for (String g : genres) {
            genre = GenresXML.builder().build();
            val booksXML = BooksXML.builder().build();
            List<BookXML> bookXMLList = new ArrayList<>();

            genre.setGenre(g);
            List<TitleJSON> title = books.getBooks().stream().filter(x -> x.getBook().getGenre().equals(g)).toList();

            for (TitleJSON t : title) {
                val bookXML = BookXML.builder().build();
                bookXML.setAuthor(t.getBook().getAuthor());
                bookXML.setYear(t.getBook().getYear());
                bookXML.setTitle(t.getTitle());
                bookXMLList.add(bookXML);
            }

            booksXML.setBook(bookXMLList);
            genre.setBooks(booksXML);
            genresXMLS.add(genre);
        }

        val libraryXML = LibraryXML.builder().build();
        libraryXML.setGenre(genresXMLS);

        return libraryXML;*/
    }
}
