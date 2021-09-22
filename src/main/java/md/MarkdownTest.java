package md;

import com.youbenzi.mdtool.tool.MDTool;

/**
 * @author 林子洋
 * @create 2021-09-17 10:10:55
 */
public class MarkdownTest {

    public static void main(String[] args) {
        // MDTool.markdown2Html()
        System.out.println(MDTool.markdown2Html("1. 123\n2. 123123\n\t[ ] 12312\n\t[x] 123123\n\t[ ] 12312\n1. 13123"));
    }

}
