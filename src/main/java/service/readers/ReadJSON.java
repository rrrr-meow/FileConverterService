package service.readers;

import lombok.SneakyThrows;
import lombok.val;
import service.structure.JSON.BookJSON;
import service.structure.JSON.BooksJSON;
import service.structure.JSON.TitleJSON;

import javax.json.stream.JsonParser;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.json.Json.createParserFactory;


public class ReadJSON implements Reader {
    @Override
    public BooksJSON read(String in){
        return readJson(in);
    }

    @SneakyThrows
    private BooksJSON readJson(String in) {
        try(val inputStream = new FileInputStream(in);
            val parser = createParserFactory(null).createParser(inputStream, StandardCharsets.UTF_8)){

            String keyName = null;

            if (!parser.hasNext() && parser.next() != JsonParser.Event.START_ARRAY) {
                return null;
            }

            val books = BooksJSON.builder().build();
            List<TitleJSON> booksList = new ArrayList<>();
            TitleJSON title = TitleJSON.builder().build();
            BookJSON book = BookJSON.builder().build();

            while (parser.hasNext()) {
                switch (parser.next()) {
                    case KEY_NAME -> keyName = parser.getString();
                    case VALUE_STRING -> setStringValue(title, book, Objects.requireNonNull(keyName), parser.getString());
                    case VALUE_NUMBER -> {
                        if (Objects.equals(keyName, "year")) {
                            book.setYear(parser.getInt());
                        }
                    }
                    case END_OBJECT -> {
                        if (Boolean.FALSE.equals(title.isNull())) {
                            title.setBook(book);
                            booksList.add(title);
                            title = TitleJSON.builder().build();
                            book = BookJSON.builder().build();
                        }
                    }
                }
            }
            books.setBooks(booksList);
            inputStream.close();

            return books;
        }
    }


    private void setStringValue(TitleJSON title, BookJSON book, String key, String value) {
        switch (key) {
            case "title" -> title.setTitle(value);
            case "genre" -> book.setGenre(value);
            case "author" -> book.setAuthor(value);
        }
    }
}
