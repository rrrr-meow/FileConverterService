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
        JsonObject obj = Json.createObjectBuilder()
                .add("books", (JsonArrayBuilder) library.getGenre().stream()
                        .flatMap(genre -> genre.getBooks().getBook().stream()
                                .map(bookXML -> Json.createObjectBuilder()
                                        .add("title", bookXML.getTitle())
                                        .add("book", Json.createObjectBuilder()
                                                .add("genre", genre.getGenre())
                                                .add("author", bookXML.getAuthor())
                                                .add("year", bookXML.getYear()))
                                        .build()))
                        .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder:: add))
                .build();

        OutputStream outStream = new FileOutputStream(out);

        JsonWriter jsonWriter;

        Map< String, Boolean > config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(config);
        jsonWriter = factory.createWriter(outStream);

        jsonWriter.writeObject(obj);
        jsonWriter.close();
    }
}
