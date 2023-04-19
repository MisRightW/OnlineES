package com.fengling.modules.sys.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fengling.core.annon.AdminInject;
import com.fengling.core.annon.LogInject;
import com.fengling.core.api.ApiResult;
import com.fengling.core.api.controller.BaseController;
import com.fengling.core.api.dto.BaseStateReqDTO;
import com.fengling.core.api.dto.PagingReqDTO;
import com.fengling.modules.sys.user.dto.SysUserDTO;
import com.fengling.modules.sys.user.dto.request.SysUserLoginReqDTO;
import com.fengling.modules.sys.user.dto.request.SysUserSaveReqDTO;
import com.fengling.modules.sys.user.dto.response.SysUserLoginDTO;
import com.fengling.modules.sys.user.entity.SysUser;
import com.fengling.modules.sys.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 管理用户控制器
 * </p>
 *
 * @author 聪明笨狗
 * @since 2020-04-13 16:57
 */
@Api(tags = {"管理用户"})
@RestController
@RequestMapping("/exam/api/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService baseService;

    /**
     * 用户登录
     * @return
     */
    @LogInject(title = "登录系统")
    @CrossOrigin
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ApiResult<SysUserLoginDTO> login(@RequestBody SysUserLoginReqDTO reqDTO) {
        SysUserLoginDTO respDTO = baseService.login(reqDTO.getUsername(), reqDTO.getPassword());
        return super.success(respDTO);
    }

    /**
     * 用户登录
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public ApiResult logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println("+++++当前会话为："+token);
        baseService.logout(token);
        return super.success();
    }

    /**
     * 获取会话
     * @return
     */
    @AdminInject
    @ApiOperation(value = "获取会话")
    @RequestMapping(value = "/info", method = {RequestMethod.POST})
    public ApiResult info(@RequestParam("token") String token) {
        SysUserLoginDTO respDTO = baseService.token(token);
        return success(respDTO);
    }

    /**
     * 修改用户资料
     * @return
     */
    @AdminInject(ids = {"id"})
    @ApiOperation(value = "修改用户资料")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public ApiResult update(@RequestBody SysUserDTO reqDTO) {
        baseService.update(reqDTO);
        return success();
    }


    /**
     * 保存或修改系统用户
     * @return
     */
    @AdminInject(ids = {}, names = {})
    @ApiOperation(value = "保存或修改")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public ApiResult save(@RequestBody SysUserSaveReqDTO reqDTO) {
        baseService.save(reqDTO);
        return success();
    }

    /**
     * 分页查找
     * @param reqDTO
     * @return
     */
    @AdminInject
    @ApiOperation(value = "分页查找")
    @RequestMapping(value = "/paging", method = { RequestMethod.POST})
    public ApiResult<IPage<SysUserDTO>> paging(@RequestBody PagingReqDTO<SysUserDTO> reqDTO) {

        //分页查询并转换
        IPage<SysUserDTO> page = baseService.paging(reqDTO);
        return super.success(page);
    }

    /**
     * 修改状态
     * @param reqDTO
     * @return
     */
    @AdminInject
    @ApiOperation(value = "修改状态")
    @RequestMapping(value = "/state", method = { RequestMethod.POST})
    public ApiResult state(@RequestBody BaseStateReqDTO reqDTO) {

        // 条件
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .in(SysUser::getId, reqDTO.getIds())
                .ne(SysUser::getUserName, "admin");


        SysUser record = new SysUser();
        record.setState(reqDTO.getState());
        baseService.update(record, wrapper);

        return super.success();
    }


    /**
     * 保存或修改系统用户
     * @return
     */
    @ApiOperation(value = "学员注册")
    @RequestMapping(value = "/reg", method = {RequestMethod.POST})
    public ApiResult<SysUserLoginDTO> reg(@RequestBody SysUserDTO reqDTO) {
        SysUserLoginDTO respDTO = baseService.reg(reqDTO);
        return success(respDTO);
    }
}
