package ai.note.serde;

import ai.message.Message;
import ai.note.Note;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class NoteCodec implements CollectibleCodec<Note> {
    @Override
    public Note generateIdIfAbsentFromDocument(Note document) {
        return null;
    }

    @Override
    public boolean documentHasId(Note document) {
        return false;
    }

    @Override
    public BsonValue getDocumentId(Note document) {
        return null;
    }

    @Override
    public Note decode(BsonReader reader, DecoderContext decoderContext) {
        return null;
    }

    @Override
    public void encode(BsonWriter writer, Note value, EncoderContext encoderContext) {

    }

    @Override
    public Class<Note> getEncoderClass() {
        return null;
    }
}
