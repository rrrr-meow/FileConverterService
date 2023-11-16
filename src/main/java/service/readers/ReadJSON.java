package service.readers;

import service.structure.BookJSON;
import service.structure.BooksJSON;
import service.structure.TitleJSON;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON implements Reader{
    @Override
    public BooksJSON read(String in) throws FileNotFoundException {
        return ReadJSON(in);
    }
    private BooksJSON ReadJSON(String in) throws FileNotFoundException{
        FileInputStream inputStream = new FileInputStream(in);

        JsonParserFactory factory = Json.createParserFactory(null);
        JsonParser parser = factory.createParser(inputStream, StandardCharsets.UTF_8);
        String keyName = null;

        if (!parser.hasNext() && parser.next() != JsonParser.Event.START_ARRAY) return null;

        BooksJSON books = new BooksJSON();
        List<BooksJSON> booksList = new ArrayList<>();
        TitleJSON title = new TitleJSON();
        BookJSON book = new BookJSON();

        while (parser.hasNext()){
            JsonParser.Event event = parser.next();
            switch (event){
                case KEY_NAME -> {
                    keyName = parser.getString();
                    break;
                }
                case VALUE_STRING -> {
                    SetStringValue(title,book, keyName, parser.getString());
                    break;
                }
                case VALUE_NUMBER -> {
                    if (keyName.equals("year")){
                        book.setYear(parser.getInt());
                    }
                    break;
                }
                default -> {break;}
            }
        }
        return books;
    }
    private void SetStringValue(TitleJSON title, BookJSON book, String key, String value){
        switch (key){
            case "title" ->{
                title.setTitle(value);
                break;
            }
            case "genre" ->{
                book.setGenre(value);
                break;
            }
            case "author" -> {
                book.setAuthor(value);
                break;
            }
            default -> {break;}
        }
    }
}