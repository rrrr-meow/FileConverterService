package service.writers;

import service.structure.BookXML;
import service.structure.BooksXML;
import service.structure.GenresXML;
import service.structure.LibraryXML;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class WriteJSON implements Writer{
    @Override
    public void write(LibraryXML library, String out) throws FileNotFoundException{
        writeToJson(library, out);
    }

    private void writeToJson(LibraryXML library, String out)throws FileNotFoundException{
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonArrayBuilder booksBuilder = Json.createArrayBuilder();

        for (GenresXML genre : library.getGenre()){
            JsonObjectBuilder titleBuilder = Json.createObjectBuilder();
            JsonObjectBuilder bookBuilder = Json.createObjectBuilder();

            BooksXML books = genre.getBooks();
            for (BookXML book : books.getBooks()) {
                bookBuilder.add("genre", genre.getGenre());
                bookBuilder.add("author", book.getAuthor());
                titleBuilder.add("title", book.getTitle());
                bookBuilder.add("year", book.getYear());
                titleBuilder.add("book", bookBuilder);
                booksBuilder.add(titleBuilder);
            }
        }
        objectBuilder.add("books", booksBuilder);

        JsonObject object = objectBuilder.build();

        OutputStream outStream = new FileOutputStream(out);

        JsonWriter jsonWriter;

        Map< String, Boolean > config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(config);
        jsonWriter = factory.createWriter(outStream);

        jsonWriter.writeObject(object);
        jsonWriter.close();
    }
}
