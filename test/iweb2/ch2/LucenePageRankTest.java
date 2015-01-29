package iweb2.ch2;

import iweb2.ch2.shell.FetchAndProcessCrawler;
import iweb2.ch2.shell.LuceneIndexer;
import iweb2.ch2.shell.MySearcher;
import iweb2.ch2.shell.PageRank;

import org.junit.Test;

public class LucenePageRankTest {

  @Test
  public void test() throws Exception {
    //
    // -- Data (Business news URLs and 3 spam pages)
    //
    FetchAndProcessCrawler crawler =
        new FetchAndProcessCrawler("D:/Java/workspaces_MyEclipse/iWeb2/data/ch02", 5, 200);
    crawler.setUrls("biz");
    crawler.addUrl("file:///D:/Java/workspaces_MyEclipse/iWeb2/data/ch02/spam-biz-01.html");
    crawler.addUrl("file:///D:/Java/workspaces_MyEclipse/iWeb2/data/ch02/spam-biz-02.html");
    crawler.addUrl("file:///D:/Java/workspaces_MyEclipse/iWeb2/data/ch02/spam-biz-03.html");
    crawler.run();

    //
    // -- Lucene
    //
    LuceneIndexer luceneIndexer = new LuceneIndexer(crawler.getRootDir());
    luceneIndexer.run();
    MySearcher oracle = new MySearcher(luceneIndexer.getLuceneDir());

    //
    // -- Lucene Index ranking only
    //
    oracle.search("nvidia", 5);
    oracle.search("economy news", 5);

    //
    // -- PageRank
    //
    PageRank pageRank = new PageRank(crawler.getCrawlData());
    pageRank.setAlpha(0.99);
    pageRank.setEpsilon(0.00000001);
    pageRank.build();

    //
    // -- Combined ranking
    //
    oracle.search("nvidia", 5, pageRank);
    oracle.search("economy news", 5, pageRank);
  }

}
