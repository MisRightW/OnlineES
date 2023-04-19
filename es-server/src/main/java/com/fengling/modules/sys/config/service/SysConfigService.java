package com.fengling.modules.sys.config.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.modules.sys.config.dto.SysConfigDTO;
import com.fengling.modules.sys.config.entity.SysConfig;


/**
* 通用配置业务类
 * @author fengl
 */
public interface SysConfigService extends IService<SysConfig> {

    /**
     * 查找配置信息
     * @return
     */
    SysConfigDTO find();
}
