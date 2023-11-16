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

public class WriteXML implements Writer{
    @Override
    public void write(LibraryXML library, String out) throws FileNotFoundException{
        ToJson(library, out);
    }

    private void ToJson(LibraryXML library, String out)throws FileNotFoundException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonArrayBuilder booksBuilder = Json.createArrayBuilder();

        for (GenresXML g:library.getGenre()){
            JsonObjectBuilder titleBuilder = Json.createObjectBuilder();
            JsonObjectBuilder bookBuilder = Json.createObjectBuilder();
            //JsonArrayBuilder booksBuilder = Json.createArrayBuilder();

            BooksXML books = g.getBooks();
            for (BookXML b : books.getBooks()) {
                bookBuilder.add("genre", g.getGenre());
                bookBuilder.add("author", b.getAuthor());
                titleBuilder.add("title", b.getTitle());
                bookBuilder.add("year", b.getYear());
                titleBuilder.add("book", bookBuilder);
                booksBuilder.add(titleBuilder);
            }
        }
        objectBuilder.add("books", booksBuilder);

        JsonObject obj = objectBuilder.build();

        System.out.println("Post JSON String -> " + obj);

        OutputStream os = new FileOutputStream(out);
        JsonWriter jsonWriter;

        Map< String, Boolean > config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(config);
        jsonWriter = factory.createWriter(os);

        jsonWriter.writeObject(obj);
        jsonWriter.close();
    }
}
