package service.converters;

import service.readers.ReadJSON;
import service.structure.*;
import service.writers.WriteXML;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonToXml implements Converter{
    @Override
    public void convert(String in, String out) throws FileNotFoundException {
        ReadJSON readJson = new ReadJSON();
        BooksJSON books = readJson.read(in);
        WriteXML writeXml = new WriteXML();
        writeXml.write(getGenres(books), out);
    }

    public LibraryXML getGenres(BooksJSON books) {
        var titles = books.getBooks();
        Set<String> genres = new HashSet<>();
        List<GenresXML> genresXMLS = new ArrayList<>();
        GenresXML genre;

        for (int i = 0; i < titles.size(); i++) {
            BookJSON book = titles.get(i).getBook();
            genres.add(book.getGenre());
        }

        for (String g : genres) {
            genre = new GenresXML();
            BooksXML booksXML = new BooksXML();
            List<BookXML> bookXMLList = new ArrayList<>();

            genre.setGenre(g);
            List<TitleJSON> title = books.getBooks().stream().filter(x -> x.getBook().getGenre().equals(g)).toList();

            for (TitleJSON t : title) {
                BookXML bookXML = new BookXML();
                bookXML.setAuthor(t.getBook().getAuthor());
                bookXML.setYear(t.getBook().getYear());
                bookXML.setTitle(t.getTitle());
                bookXMLList.add(bookXML);
            }

            booksXML.setBooks(bookXMLList);
            genre.setBooks(booksXML);
            genresXMLS.add(genre);
        }

        LibraryXML libraryXML = new LibraryXML();
        libraryXML.setGenre(genresXMLS);

        return libraryXML;
    }
}
