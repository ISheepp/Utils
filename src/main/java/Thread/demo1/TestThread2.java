package Thread.demo1;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author lin
 * @create 2020-10-01 13:04
 */

//联系Thread，实现多线程同步下载图片
public class TestThread2 extends Thread {

    private String url; //网络图片地址
    private String name; //保存的文件名

    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }


    @SneakyThrows
    @Override
    public void run() {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为" + name);

    }

    public static void main(String[] args) {

        TestThread2 testThread2 = new TestThread2("https://img.codelin.xyz/blog/20191115/d27KWUfpmLDS.png?imageslim", "1.jpg");
        TestThread2 testThread3 = new TestThread2("https://img.codelin.xyz/blog/20191115/d27KWUfpmLDS.png?imageslim", "2.jpg");

        testThread2.start();
        testThread3.start();
    }

}



//下载器
class WebDownloader{

    //下载方法
    public void downloader(String url, String name) throws MalformedURLException {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }
}
