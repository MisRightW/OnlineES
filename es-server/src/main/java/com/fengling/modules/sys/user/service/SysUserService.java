package com.fengling.modules.sys.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.core.api.dto.PagingReqDTO;
import com.fengling.modules.sys.user.dto.SysUserDTO;
import com.fengling.modules.sys.user.dto.request.SysUserSaveReqDTO;
import com.fengling.modules.sys.user.dto.response.SysUserLoginDTO;
import com.fengling.modules.sys.user.entity.SysUser;

/**
* 管理用户业务类
 * @author fengl
 */
public interface SysUserService extends IService<SysUser> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<SysUserDTO> paging(PagingReqDTO<SysUserDTO> reqDTO);

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    SysUserLoginDTO login(String userName, String password);

    /**
     * 获取管理会话
     * @param token
     * @return
     */
    SysUserLoginDTO token(String token);

    /**
     * 退出登录
     * @param token
     */
    void logout(String token);

    /**
     * 修改用户资料
     * @param reqDTO
     */
    void update(SysUserDTO reqDTO);

    /**
     * 保存添加系统用户
     * @param reqDTO
     */
    void save(SysUserSaveReqDTO reqDTO);

    /**
     * 用户注册
     * @param reqDTO
     */
    SysUserLoginDTO reg(SysUserDTO reqDTO);
}
