package algorithm.dp;


/**
 * 通配符匹配<br>
 * https://juejin.cn/post/7033331336907587620
 *
 * @author 林子洋
 * @create 2021-11-23 9:39:18
 */
public class PatternString {

    /**
     *
     * @param s 字符串
     * @param p 匹配项
     * @return boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                //直接往右下角移动
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {

    }

}
