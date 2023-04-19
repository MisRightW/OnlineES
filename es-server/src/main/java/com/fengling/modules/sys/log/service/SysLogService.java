package com.fengling.modules.sys.log.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.core.api.dto.PagingReqDTO;
import com.fengling.modules.sys.log.dto.SysLogDTO;
import com.fengling.modules.sys.log.entity.SysLog;

/**
* <p>
* 系统日志业务类
*/
public interface SysLogService extends IService<SysLog> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<SysLogDTO> paging(PagingReqDTO<SysLogDTO> reqDTO);
}
