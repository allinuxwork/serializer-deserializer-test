package serializer;

import java.util.Collection;
import serializer.deserializer.test.user.User;

public interface UserSerializer {
    void serialize(Collection<User> userCollection, String outputFile);
}