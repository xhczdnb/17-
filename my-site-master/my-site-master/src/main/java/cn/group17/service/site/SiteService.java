package cn.group17.service.site;

import cn.group17.dto.ArchiveDto;
import cn.group17.dto.MetaDto;
import cn.group17.dto.StatisticsDto;
import cn.group17.dto.cond.ContentCond;
import cn.group17.model.CommentDomain;
import cn.group17.model.ContentDomain;

import java.util.List;

/**
 * 站点服务
 *   .
 */
public interface SiteService {

    /**
     * 获取评论列表
     * @param limit
     * @return
     */
    List<CommentDomain> getComments(int limit);

    /**
     * 获取最新的文章
     * @param limit
     * @return
     */
    List<ContentDomain> getNewArticles(int limit);

    /**
     * 获取单条评论
     * @param coid
     * @return
     */
    CommentDomain getComment(Integer coid);

    /**
     * 获取 后台统计数据
     * @return
     */
    StatisticsDto getStatistics();

    /**
     * 获取归档列表 - 只是获取日期和数量
     * @param contentCond
     * @return
     */
    List<ArchiveDto> getArchivesSimple(ContentCond contentCond);

    /**
     * 获取归档列表
     * @param contentCond 查询条件（只包含开始时间和结束时间）
     * @return
     */
    List<ArchiveDto> getArchives(ContentCond contentCond);



    /**
     * 获取分类/标签列表
     * @param type
     * @param orderBy
     * @param limit
     * @return
     */
    List<MetaDto> getMetas(String type, String orderBy, int limit);
}
