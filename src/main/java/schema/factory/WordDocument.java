package schema.factory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author linzy
 * @create 2021-02-27 10:49:24
 */
public interface WordDocument {

    void save(Path path) throws IOException;

}
