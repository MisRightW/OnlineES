package com.generator.db.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.util.Date;

/**
 * 基础Do<br>
 * 创建时间、创建人、修改时间、修改人、是否删除是必须字段<br>
 * <br>
 * <b>仅！仅！仅！</b><br>
 * <b>仅</b>用于Bo与数据库打交道，请勿用于作为接口参数和返回值，这不是用来传来传去的<br>
 * 因为，默认字段并不想让别人看到，也不能让别人修改<br>
 * <br>
 * 请用Dto作为参数和返回值<br>
 * 2个o之间可以非常方便的自由转换，调用trans方法即可，比如：<br>
 * UserDo userDo = userDto.trans(UserDo.class);<br>
 * UserDto userDto = userVo.trans(UserDto.class);<br>
 * 如果业务有其他需要，如增加Vo等，也可以通过继承LavaBaseModel来获得trans功能
 *
 * @author jiyu.gjy
 */
public abstract class LavaDo extends LavaBaseModel {

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create" , fill = FieldFill.INSERT)
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified" , fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
    /**
     * 创建人
     */
    @TableField(value = "creator" , fill = FieldFill.INSERT)
    private String creator;
    /**
     * 修改人
     */
    @TableField(value = "modifier", fill = FieldFill.INSERT_UPDATE)
    private String modifier;
    /**
     * 删除标记
     */
    @TableField("is_deleted")
    @TableLogic
    private String isDeleted;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[").append(getClass().getName()).append("]").append("ID:").append(getId() == null ? "Null" : getId());
        return sb.toString();
    }

}
