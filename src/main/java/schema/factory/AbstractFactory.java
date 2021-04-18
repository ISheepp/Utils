package schema.factory;


/**
 * @author linzy
 * @create 2021-02-27 10:46:54
 */
public interface AbstractFactory {

    // 创建Html文档
    HtmlDocument createHtml(String md);

    // 创建Word文档
    WordDocument createWord(String md);
}
