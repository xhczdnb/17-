package cn.group17.service.attach.impl;

import cn.group17.constant.ErrorConstant;
import cn.group17.dao.AttAchDao;
import cn.group17.dto.AttAchDto;
import cn.group17.exception.BusinessException;
import cn.group17.model.AttAchDomain;
import cn.group17.service.attach.AttAchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 附件服务实现层
 *    .
 */
@Service
public class AttAchServiceImpl implements AttAchService {

    @Autowired
    private AttAchDao attAchDao;

    @Override
    @CacheEvict(value={"attCaches","attCache"},allEntries=true,beforeInvocation=true)
    public void addAttAch(AttAchDomain attAchDomain) {
        if (null == attAchDomain)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.addAttAch(attAchDomain);

    }

    @Override
    @CacheEvict(value={"attCaches","attCache"},allEntries=true,beforeInvocation=true)
    public void batchAddAttAch(List<AttAchDomain> list) {
        if (null == list || list.size() == 0)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.batchAddAttAch(list);

    }

    @Override
    @CacheEvict(value={"attCaches","attCache"},allEntries=true,beforeInvocation=true)
    public void deleteAttAch(Integer id) {
        if (null == id)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.deleteAttAch(id);

    }

    @Override
    @CacheEvict(value={"attCaches","attCache"},allEntries=true,beforeInvocation=true)
    public void updateAttAch(AttAchDomain attAchDomain) {
        if (null == attAchDomain || null == attAchDomain.getId())
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.updateAttAch(attAchDomain);

    }

    @Override
    @Cacheable(value = "attCache", key = "'attAchById' + #p0")
    public AttAchDto getAttAchById(Integer id) {
        if (null == id)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return attAchDao.getAttAchById(id);
    }

    @Override
    @Cacheable(value = "attCaches", key = "'atts' + #p0")
    public PageInfo<AttAchDto> getAtts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AttAchDto> atts = attAchDao.getAtts();
        PageInfo<AttAchDto> pageInfo = new PageInfo<>(atts);
        return pageInfo;
    }


}
