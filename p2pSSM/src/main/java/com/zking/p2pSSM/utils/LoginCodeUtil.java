package com.zking.p2pSSM.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证码状态 默认：0 扫码成功1  超时：-3
 * @author colorbin
 * 创建时间: 2018年5月6日 下午2:37:37
 */
public class LoginCodeUtil {
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static Map<String, Integer> getMap(){
		return map;
	}
	
	public static void set(String key, int value){
		map.put(key, value);
	}
	
	public static void remove(String key){
		map.remove(key);
	}
	
	public static int get(String key){
		Integer value = map.get(key);
		
		if(value == null){
			return -3;
		}
		
		return value;
	}
}
