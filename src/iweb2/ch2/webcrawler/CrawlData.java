package iweb2.ch2.webcrawler;

import iweb2.ch2.webcrawler.db.FetchedDocsDB;
import iweb2.ch2.webcrawler.db.KnownUrlDB;
import iweb2.ch2.webcrawler.db.PageLinkDB;
import iweb2.ch2.webcrawler.db.ProcessedDocsDB;

import java.io.File;

public class CrawlData {

  private File crawlRootDir;

  private FetchedDocsDB fetchedDocsDB;
  private ProcessedDocsDB processedDocsDB;
  private KnownUrlDB knownUrlsDB;
  private PageLinkDB pageLinkDB;

  public File getCrawlRootDir() {
    return crawlRootDir;
  }

  public KnownUrlDB getKnownUrlsDB() {
    return knownUrlsDB;
  }

  public PageLinkDB getPageLinkDB() {
    return pageLinkDB;
  }

  public FetchedDocsDB getFetchedDocsDB() {
    return fetchedDocsDB;
  }

  public ProcessedDocsDB getProcessedDocsDB() {
    return processedDocsDB;
  }

  // 初始化用来处理爬虫数据的文件夹，以及相应的子文件夹
  public CrawlData(String rootDir) {

    // 1、创建主目录
    this.crawlRootDir = new File(rootDir);
    if (crawlRootDir.exists()) {
      crawlRootDir.delete();
    }
    crawlRootDir.mkdirs();

    // 2、创建爬取后的数据文件夹
    File fetchedDocsDBRoot = new File(crawlRootDir, "fetched");
    this.fetchedDocsDB = new FetchedDocsDB(fetchedDocsDBRoot);

    // 3、创建处理的数据文件夹
    File processedDocsDBRoot = new File(crawlRootDir, "processed");
    this.processedDocsDB = new ProcessedDocsDB(processedDocsDBRoot);

    // 4、创建已知url的文件夹
    File knownUrlsDBRoot = new File(crawlRootDir, "knownurls");
    this.knownUrlsDB = new KnownUrlDB(knownUrlsDBRoot);


    // 5、创建网页链接文件夹
    File pageLinkDBRoot = new File(crawlRootDir, "pagelinks");
    this.pageLinkDB = new PageLinkDB(pageLinkDBRoot);
  }

  /**
   * 初始化相关文件夹
   */
  public void init() {
    this.fetchedDocsDB.init();
    this.processedDocsDB.init();
    this.knownUrlsDB.init();
    this.pageLinkDB.init();
  }

  /**
   * 
   * @Title: delete
   * @Description: 删除相关数据文件
   */
  public void delete() {
    this.fetchedDocsDB.delete();
    this.processedDocsDB.delete();
    this.knownUrlsDB.delete();
    this.pageLinkDB.delete();
  }
}
