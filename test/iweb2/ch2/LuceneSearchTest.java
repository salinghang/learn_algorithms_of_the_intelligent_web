package iweb2.ch2;

import iweb2.ch2.shell.FetchAndProcessCrawler;
import iweb2.ch2.shell.LuceneIndexer;
import iweb2.ch2.shell.MySearcher;

import org.junit.Test;

public class LuceneSearchTest {

  @Test
  public void test() {
    FetchAndProcessCrawler crawler =
        new FetchAndProcessCrawler("D:/Java/workspaces_MyEclipse/iWeb2/data/ch02", 5, 200);
    crawler.setDefaultUrls();
    crawler.run();
    LuceneIndexer luceneIndexer = new LuceneIndexer(crawler.getRootDir());
    luceneIndexer.run();

    MySearcher searcher = new MySearcher(luceneIndexer.getLuceneDir());

    searcher.search("armstrong", 5);
  }

}
