package com.example.demo.mapper;

import com.example.demo.entity.CameraInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CameraInfoMapper {

    /**
     * 查询手机号下的所有绑定设备
     * @param phoneId 手机号
     * @return list
     */
    List<CameraInfo> getBindDeviceByPhoneId(String phoneId);

    /**
     * 校验设备绑定关系
     * @param deviceCode 设备码
     * @return cameraInfo
     */
    CameraInfo selectBindInfoByDevId(String deviceCode);

    /**
     * 查询手机号与设备码是否为绑定关系
     * @param phoneId 手机号
     * @param deviceCode 设备码
     * @return 绑定个数
     */
    Integer isBound(@Param("phoneId")String phoneId, @Param("deviceCode")String deviceCode);

    CameraInfo selectCameraInfoByUserIdAndDeviceCode(Long userId,String deviceCode);

    int insertSelective(CameraInfo cameraInfo);

    int updateByPrimaryKeySelective(CameraInfo cameraInfo);

    List<CameraInfo> selectCameraInfoByMap(Map<String, Object> map);

    String getCloudIdByDeviceCodeAndPhone(String deviceCode,String phoneId);

    List<CameraInfo> findAll();
}
