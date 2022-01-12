package zkTest;

import org.apache.commons.lang3.StringUtils;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计算我2021年的todo 完成了多少，未完成多少
 *
 */
public class TodoList {

    private static final String TOKEN = "";

    public static void main(String[] args) throws IOException {
        GitHub github = new GitHubBuilder().withAppInstallationToken(TOKEN).build();
        List<GHIssueComment> comments = github.getRepository("linziyang1106/2021").getIssue(3).getComments();
        AtomicInteger doneCount = new AtomicInteger();
        AtomicInteger unDoneCount = new AtomicInteger();
        comments.forEach(comment -> {
            String body = comment.getBody();
            String[] todo = StringUtils.split(body, "\r\n");
            for (String item : todo) {
                if (item.startsWith("- [ ] ")) {
                    unDoneCount.getAndIncrement();
                } else if (item.startsWith("- [x] ")) {
                    doneCount.getAndIncrement();
                }
            }
        });
        int total = doneCount.intValue() + unDoneCount.intValue();

        double doneRate = ((double) doneCount.intValue() / (double) total) * 100;
        NumberFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(2);
        System.out.println("all todo count: " + total);
        System.out.println("done: " + doneCount);
        System.out.println("undone: " + unDoneCount);
        System.out.println("done rate: " + nf.format(doneRate) + "%");
        // System.out.println(comments.get(0).getBody());
        // String[] split = StringUtils.split(comments.get(0).getBody(), "\r\n");
        // System.out.println(comments.get(0).getBody().startsWith("- [ ] "));
        // System.out.println(comments.get(0).getBody().startsWith("- [x] "));
    }

}
