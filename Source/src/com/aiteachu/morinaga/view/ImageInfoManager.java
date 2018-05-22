package com.aiteachu.morinaga.view;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aiteachu.morinaga.component.DateUtil;

public class ImageInfoManager {
	private String imagePath;
	private String strDate;
	private String filePrefix;
	private Map<String, ImageInfo> imagesMap; 

	public ImageInfoManager(){
		this(DateUtil.getToday());
	}
	
	public ImageInfoManager(String date_){
		this.imagePath = IniFileReader.getConfigValue("path", "image_path");
		this.imagesMap = new LinkedHashMap<String, ImageInfo>();
		this.strDate = date_;
		this.filePrefix = IniFileReader.getConfigValue("img", "prefix");

		this.readAllImage();
		System.out.println(this.imagesMap);
	}

	private void readAllImage(){
		String fullPath_c1 = this.imagePath + IniFileReader.getConfigValue("path", "camera1_name");
		String fullPath_c2 = this.imagePath + IniFileReader.getConfigValue("path", "camera2_name");
		String fullPath_c3 = this.imagePath + IniFileReader.getConfigValue("path", "camera3_name");
		String fullPath_c4 = this.imagePath + IniFileReader.getConfigValue("path", "camera4_name");
		
		this.createImageMap(fullPath_c1, 1);
		this.createImageMap(fullPath_c2, 2);
		this.createImageMap(fullPath_c3, 3);
		this.createImageMap(fullPath_c4, 4);
	}

	private void createImageMap(String fullPath, int type) {
		File file = new File(fullPath);
		File[] fileList = file.listFiles();
		for(File f : fileList){
			String fileName = f.getName();
			String[] details = this.getFileNameDetail(fileName);
			
			String key = details[0];
			ImageInfo imageInfo = null;
			if(!this.imagesMap.containsKey(key)){
				imageInfo = new ImageInfo();
				imageInfo.setHour(details[3]);
				imageInfo.setMinute(details[4]);
				imageInfo.setSecond(details[5]);
			} else {
				imageInfo = this.imagesMap.get(key);
			}
			
			switch(type){
				case 1:
					imageInfo.addContentC1(fileName);
					break;
				case 2:
					imageInfo.addContentC2(fileName);
					break;
				case 3:
					imageInfo.addContentC3(fileName);
					break;
				case 4:
					imageInfo.addContentC4(fileName);
					break;
			}
			
			this.imagesMap.put(key, imageInfo);
		}
	}
	
	/**
	 * Get details by file name 
	 * @param fileName
	 * @return
	 * 		0 : yyyyMMddHHmmss
	 * 		1 : yyyy
	 * 		2 : MM
	 * 		3 : dd
	 * 		4 : HH
	 * 		5 : mm
	 * 		6 : ss
	 */
	private String[] getFileNameDetail(String fileName){
		String key = fileName.substring(filePrefix.length(), filePrefix.length()+14);

		String year = fileName.substring(filePrefix.length(), filePrefix.length()+4);
		String month = fileName.substring(filePrefix.length()+4, filePrefix.length()+6);
		String date = fileName.substring(filePrefix.length()+6, filePrefix.length()+8);
		String hour = fileName.substring(filePrefix.length()+8, filePrefix.length()+10);
		String minitue = fileName.substring(filePrefix.length()+10, filePrefix.length()+12);
		String second = fileName.substring(filePrefix.length()+12, filePrefix.length()+14);

		String[] resultArray = new String[7];
		resultArray[0] = key;
		resultArray[1] = year;
		resultArray[2] = month;
		resultArray[3] = date;
		resultArray[4] = hour;
		resultArray[5] = minitue;
		resultArray[6] = second;
		
		return resultArray;
	}

	public void setDate(String date_){
		this.strDate = date_;
	}

	public void clear(){
		this.imagesMap.clear();
	}
}
