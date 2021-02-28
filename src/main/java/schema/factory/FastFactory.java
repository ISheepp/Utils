package schema.factory;

/**
 * @author linzy
 * @create 2021-02-27 10:51:36
 */
public class FastFactory implements AbstractFactory {

    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument();
    }
}
