package service.writers;

import lombok.val;
import service.structure.XML.LibraryXML;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class WriteJSON implements Writer{
    @Override
    public void write(LibraryXML library, String out) throws IOException {
        writeToJson(library, out);
    }

    private void writeToJson(LibraryXML library, String out) throws IOException {
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

        try(OutputStream outStream = new FileOutputStream(out);
        val jsonWriter = Json.createWriterFactory(createConfig()).createWriter(outStream)){
            jsonWriter.writeObject(obj);
        }

    }
    private Map<String, Boolean> createConfig(){
        Map< String, Boolean > config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        return config;
    }
}
