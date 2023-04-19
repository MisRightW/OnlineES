package com.fengling.modules.sys.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.core.api.dto.PagingReqDTO;
import com.fengling.modules.sys.user.dto.SysRoleDTO;
import com.fengling.modules.sys.user.entity.SysRole;

/**
* 角色业务类
 * @author fengl
 */
public interface SysRoleService extends IService<SysRole> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<SysRoleDTO> paging(PagingReqDTO<SysRoleDTO> reqDTO);
}
