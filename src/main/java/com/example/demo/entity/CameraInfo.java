package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备信息表
 *
 * @author cbx
 * @date 2019/10/22
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CameraInfo implements Serializable {

    private static final long serialVersionUID = -4649470858248295921L;
    
    protected Long id;

    /**
     * 设备码
     */
    protected String deviceCode;

    /**
     * ctei码
     */
    protected String ctei;

    /**
     * 设备昵称
     */
    protected String cameraNickname;

    /**
     * 云存id
     */
    protected String cloudId;

    /**
     * 套餐id
     */
    protected Long packageId;

    /**
     * 摄像头厂商
     */
    protected Integer factoryId;

    /**
     * 天翼账号user_id
     */
    protected Long userId;

    /**
     * 用户绑定状态（0:未绑定1：已绑定）
     */
    protected Boolean userBindStatus;

    /**
     * 绑定失败状态： 0或null-成功 1-赛达开通云存失败 2-赛达更新云存失败 3-赛达云存注销失败
     */
    protected Integer failStatus = 0;

    /**
     * 设备绑定的渠道，对应t_channel_info表主键
     */
    protected Integer channelId;


    protected Date createTime;


    protected Date updateTime;

    public CameraInfo(String deviceCode, String ctei, String cameraNickname, Integer factoryId,
                      Long userId, Boolean userBindStatus, Integer failStatus, Integer channelId) {
        this.deviceCode = deviceCode;
        this.ctei = ctei;
        this.cameraNickname = cameraNickname;
        this.factoryId = factoryId;
        this.userId = userId;
        this.userBindStatus = userBindStatus;
        this.failStatus = failStatus;
        this.channelId = channelId;
        Date now = new Date();
        this.createTime = now;
        this.updateTime = now;
    }

}
