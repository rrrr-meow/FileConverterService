package service.writers;

import lombok.val;
import service.structure.XML.BookXML;
import service.structure.XML.GenresXML;
import service.structure.XML.LibraryXML;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
//@Builder
public class WriteJSON implements Writer{
    @Override
    public void write(LibraryXML library, String out) throws FileNotFoundException{
        writeToJson(library, out);
    }

    private void writeToJson(LibraryXML library, String out)throws FileNotFoundException{

        val objectBuilder = Json.createObjectBuilder();
        val booksBuilder = Json.createArrayBuilder();

        for (GenresXML genre : library.getGenre()){
            val titleBuilder = Json.createObjectBuilder();
            val bookBuilder = Json.createObjectBuilder();

            val books = genre.getBooks();
            for (BookXML book : books.getBook()) {
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
