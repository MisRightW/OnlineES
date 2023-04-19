package com.fengling.modules.sys.config.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.core.utils.BeanMapper;
import com.fengling.modules.sys.config.dto.SysConfigDTO;
import com.fengling.modules.sys.config.entity.SysConfig;
import com.fengling.modules.sys.config.mapper.SysConfigMapper;
import com.fengling.modules.sys.config.service.SysConfigService;
import org.springframework.stereotype.Service;

/**
* 语言设置 服务实现类
*/
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    @Override
    public SysConfigDTO find() {

        QueryWrapper<SysConfig> wrapper = new QueryWrapper<>();
        wrapper.last(" LIMIT 1");

        SysConfig entity = this.getOne(wrapper, false);
        SysConfigDTO dto = new SysConfigDTO();
        BeanMapper.copy(entity, dto);
        return dto;
    }
}
