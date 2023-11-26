package ai.message.codec;

import ai.message.Message;
import com.mongodb.MongoClientSettings;


import org.bson.*;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

public class MessageCodec implements CollectibleCodec<Message> {

    private final Codec<Document> documentCodec;

    private  final CodecRegistry codecRegistry;



    public MessageCodec(CodecRegistry codecRegistry) {

        // Create a new Document and populate it with RuleEntity fields
        this.codecRegistry = codecRegistry;

        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }



    @Override
    public Message decode(BsonReader reader, DecoderContext decoderContext) {

        // Create a new Document and populate it with RuleEntity fields
        return new Message();
    }

    @Override
    public void encode(BsonWriter writer, Message message, EncoderContext encoderContext) {

        // Create a new Document and populate it with RuleEntity fields
        Document doc = new Document();

        doc.put("conversationID", "Hello");


        // Encode the Document
        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<Message> getEncoderClass() {


        // Create a new Document and populate it with RuleEntity fields

        return Message.class;
    }

    @Override
    public Message generateIdIfAbsentFromDocument(Message document) {


        // Create a new Document and populate it with RuleEntity fields
        //TODO: the return null caused the error
        return document;
    }

    @Override
    public boolean documentHasId(Message document) {

        // Create a new Document and populate it with RuleEntity fields
        return

                !document.getConversationID().isEmpty();
    }

    @Override
    public BsonValue getDocumentId(Message document) {


        // Create a new Document and populate it with RuleEntity fields

        return null;
    }
}

