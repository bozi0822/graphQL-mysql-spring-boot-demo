package com.example.demo.fetcher;

import com.example.demo.entity.CameraInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class CameraInfoDataFetcher {

	private List<CameraInfo> cameraInfos = new ArrayList<>();

	@DgsQuery
	public List<CameraInfo> cameraInfos(@InputArgument String deviceCodeFilter) {


		if(deviceCodeFilter == null) {
			return cameraInfos;
		}

		return cameraInfos.stream().filter(s -> s.getDeviceCode().contains(deviceCodeFilter)).collect(Collectors.toList());
	}
}
