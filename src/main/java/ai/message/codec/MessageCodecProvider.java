package ai.message.codec;


import ai.message.Message;
import com.mongodb.MongoClientSettings;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

public class MessageCodecProvider implements CodecProvider {
    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {

        CodecRegistry codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        MessageCodecProvider messageCodecProvider = new MessageCodecProvider();

        CodecRegistry codecRegistry1 = CodecRegistries.fromRegistries(
                codecRegistry,
                CodecRegistries.fromProviders(messageCodecProvider));
        if (clazz.equals(Message.class)) {
            return (Codec<T>) new MessageCodec(codecRegistry1);
        }
        return null;
    }
}
