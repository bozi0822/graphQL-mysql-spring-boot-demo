package com.example.demo.service.impl;

import com.example.demo.entity.CameraInfo;
import com.example.demo.mapper.CameraInfoMapper;
import com.example.demo.service.CameraInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CameraInfoServiceImpl implements CameraInfoService {

	@Resource
	private CameraInfoMapper cameraInfoMapper;

	public List<CameraInfo> findAll(){
		return cameraInfoMapper.findAll();
	}

}
