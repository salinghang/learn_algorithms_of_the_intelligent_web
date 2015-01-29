package iweb2.ch2.webcrawler;


/**
 * Represents module that performs processing based on crawling results.
 * <p>Some module examples are:
 * <ul>
 * <li>Build Lucene index</li>
 * <li>Build matrix H for html pages</li>
 * <li>Build matrix H for documents</li>
 * </ul>
 * </p>
 */
/**
 * 
 * @ClassName: CrawlDataProcessor 
 * @Description: 数据处理的接口,抽象了统一的run方法来进行执行
 * @author anduo
 * @date 2015年1月29日 下午2:32:02 
 *
 */
public interface CrawlDataProcessor {
    public void run();
}
