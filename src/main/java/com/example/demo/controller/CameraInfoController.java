package com.example.demo.controller;

import com.example.demo.entity.CameraInfo;
import com.example.demo.service.CameraInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class CameraInfoController {
	@Resource
	private CameraInfoService cameraInfoService;

	@RequestMapping("testFindAll")
	public String testFindAll(){
		List<CameraInfo> all = cameraInfoService.findAll();

		return Arrays.toString(all.toArray());
	}

}
