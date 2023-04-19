package com.fengling.modules.sys.config.controller;

import com.fengling.core.annon.AdminInject;
import com.fengling.core.api.ApiResult;
import com.fengling.core.api.controller.BaseController;
import com.fengling.core.api.dto.BaseIdRespDTO;
import com.fengling.core.utils.BeanMapper;
import com.fengling.modules.sys.config.dto.SysConfigDTO;
import com.fengling.modules.sys.config.entity.SysConfig;
import com.fengling.modules.sys.config.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* 通用配置控制器
*/
@Api(tags={"通用配置"})
@RestController
@RequestMapping("/exam/api/sys/config")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigService baseService;

    /**
    * 添加或修改
    * @param reqDTO
    * @return
    */
    @AdminInject
    @ApiOperation(value = "添加或修改")
    @RequestMapping(value = "/save", method = { RequestMethod.POST})
    public ApiResult<BaseIdRespDTO> save(@RequestBody SysConfigDTO reqDTO) {
        //复制参数
        SysConfig entity = new SysConfig();
        BeanMapper.copy(reqDTO, entity);
        baseService.saveOrUpdate(entity);
        return super.success(new BaseIdRespDTO(entity.getId()));
    }

    /**
    * 查找详情
    * @return
    */
    @AdminInject
    @ApiOperation(value = "查找详情")
    @RequestMapping(value = "/detail", method = { RequestMethod.POST})
    public ApiResult<SysConfigDTO> find() {
        SysConfigDTO dto = baseService.find();
        return super.success(dto);
    }
}
