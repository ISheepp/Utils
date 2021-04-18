package schema.factory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author linzy
 * @create 2021-02-27 10:52:42
 */
public class Main {

    public static void main(String[] args) throws IOException {
        AbstractFactory factory = new FastFactory();
        HtmlDocument html = factory.createHtml("md");
        html.save(Paths.get(".", "fast.html"));
    }

}
