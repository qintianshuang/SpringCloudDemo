package com.example.cloud.common.util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description:
 * @Company: 税友软件集团股份有限公司
 * @author: cjg
 * @date: 2017/5/3 9:30
 */
@SuppressWarnings("deprecation")
public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);
	
	/**
	 *
	 * @Title doPost 对参数进行URLEncoder
	 * @Description post请求
	 * @param requestUrl url
	 * @param paramMap 请求参数
	 * @param headerMap head参数
	 * @return String
	 */
	public static String doPost(String requestUrl, Map<String, String> paramMap, Map<String, String> headerMap) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try {
			url = new URL(requestUrl);
			// 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			// 设置超时时间
			httpurlconnection.setConnectTimeout(600000);
			httpurlconnection.setReadTimeout(600000);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
			// 添加头部参数
			if (headerMap != null && !headerMap.isEmpty()) {
				for (Entry<String, String> header : headerMap.entrySet()) {
					httpurlconnection.addRequestProperty(header.getKey(), header.getValue());
				}
			}
			// 添加请求参数
			if (paramMap != null && !paramMap.isEmpty()) {
				StringBuilder sb = new StringBuilder("");
				for (Entry<String, String> param : paramMap.entrySet()) {
					sb.append("&").append(param.getKey()).append("=")
							.append(URLEncoder.encode(param.getValue(), "UTF-8"));
				}
				OutputStream outPutStream = httpurlconnection.getOutputStream();
				outPutStream.write(sb.toString().getBytes("UTF-8"));
				outPutStream.flush();
				outPutStream.close();
			}

			// 接口调用后获得输入流
			InputStream ins = httpurlconnection.getInputStream();

			byte[] responseData = IOUtil.readFromStream(ins);
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
			log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return "";
	}
	public static String doGet(String requestUrl) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try {
			url = new URL(requestUrl);
			// 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestMethod("GET");
			httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 设置超时时间
			httpurlconnection.setConnectTimeout(30000);
			httpurlconnection.setReadTimeout(30000);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			// 接口调用后获得输入流
			InputStream ins = httpurlconnection.getInputStream();
			byte[] responseData = IOUtil.readFromStream(ins);
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
			log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return "";
	}

//	public Map<String, Object> weixinUrl(String requestUrl) {
//		URL url = null;
//		HttpURLConnection httpurlconnection = null;
//		Map map = new HashMap();
//		try {
//			url = new URL(requestUrl);
//			// 获取一个HttpURLConnection链接对象
//			httpurlconnection = (HttpURLConnection) url.openConnection();
//			httpurlconnection.setRequestMethod("POST");
//			// 设置超时时间
//			httpurlconnection.setConnectTimeout(30000);
//			httpurlconnection.setReadTimeout(30000);
//
//			httpurlconnection.setDoInput(true);
//			// 接口调用后获得输入流
//			InputStream ins = httpurlconnection.getInputStream();
//			byte[] dzzlData = SysUtil.readFromStream(ins);
//			log.info("获取的输出流为：" + dzzlData.length);
//			log.info("获取的输出流类型为：" + httpurlconnection.getHeaderField("Content-Type"));
//			log.info("获取的输出流类型为：" + httpurlconnection.getContentType());
//			log.info("获取的返回值为：" + httpurlconnection.getResponseCode());
//			Map<String, byte[]> byteMap = new HashMap<String, byte[]>();
//			byteMap.put("dzzlData", dzzlData);
//			map.put("dzzl", byteMap);
//			map.put("contentType", httpurlconnection.getContentType());
//			map.put("fileType", httpurlconnection.getHeaderField("Content-Type"));
//			map.put("responseCode", httpurlconnection.getResponseCode());
//			return map;
//		} catch (Exception e) {
//			System.out.println("接口调用异常！");
//		} finally {
//			if (httpurlconnection != null) {
//				httpurlconnection.disconnect();
//			}
//		}
//		return map;
//	}
//
//	// 微信用的，，太恶心，，下次别用了，，
//	public Map<String, Object> invokeWxUrl(String requestUrl) {
//		Map map = null;
//		for (int i = 0; i < 10; i++) {
//			map = this.weixinUrl(requestUrl);
//			log.info("Map：" + map);
//			log.info("Map中contentType：" + map.get("contentType"));
//			if ("image/jpeg".equals(map.get("contentType"))) {
//				return map;
//			}
//		}
//		return null;
//	}

//	/**
//	 *
//	 * @Title doPost 对参数进行URLEncoder
//	 * @Description post请求
//	 * @param requestUrl url
//	 * @param json 请求参数
//	 * @return String
//	 */
//	public static byte[] weixinPost(String requestUrl,  String json) {
//		URL url = null;
//		HttpURLConnection httpurlconnection = null;
//		try {
//			url = new URL(requestUrl);
//			// 获取一个HttpURLConnection链接对象
//			httpurlconnection = (HttpURLConnection) url.openConnection();
//			httpurlconnection.setRequestMethod("POST");
//			httpurlconnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//			// 设置超时时间
//			httpurlconnection.setConnectTimeout(600000);
//			httpurlconnection.setReadTimeout(600000);
//
//			httpurlconnection.setUseCaches(false);
//			httpurlconnection.setDoInput(true);
//			httpurlconnection.setDoOutput(true);
//			// 添加请求参数
//			if (!StringUtils.isEmpty(json)) {
//				OutputStream outPutStream = httpurlconnection.getOutputStream();
//				outPutStream.write(json.getBytes("UTF-8"));
//				outPutStream.flush();
//				outPutStream.close();
//			}
//
//			// 接口调用后获得输入流
//			InputStream ins = httpurlconnection.getInputStream();
//			byte[] responseData = SysUtil.readFromStream(ins);
//			log.info("获取的输出流为：" + responseData.length);
//			log.info("获取的输出流类型为：" + httpurlconnection.getHeaderField("Content-Type"));
//			log.info("获取的输出流类型为：" + httpurlconnection.getContentType());
//			log.info("获取的返回值为：" + httpurlconnection.getResponseCode());
//			log.info("获取的数据为：" + new String(responseData,"UTF-8"));
//			return responseData;
//		} catch (Exception e) {
//			log.error("http请求发送失败", e);
//		} finally {
//			if (httpurlconnection != null) {
//				httpurlconnection.disconnect();
//			}
//		}
//		return null;
//	}

	/**
	 * 
	 * @Title doPost
	 * @Description post请求
	 * @param requestUrl
	 *            url
	 * @param json
	 *            请求参数josn串
	 * @return String
	 */
	public static String doPost(String requestUrl, String json) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		log.info("requestUrl===" + requestUrl);
		try {
			url = new URL(requestUrl);
			// 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			// 设置超时时间
			httpurlconnection.setConnectTimeout(600000);
			httpurlconnection.setReadTimeout(600000);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.addRequestProperty("Content-Type", "application/json");
			// 添加头部参数
			/*
			 * if (headerMap != null && !headerMap.isEmpty()) { for
			 * (Entry<String, String> header : headerMap.entrySet()) {
			 * httpurlconnection.addRequestProperty(header.getKey(),
			 * header.getValue()); } }
			 */
			// 添加请求参数
			if (!StringUtils.isEmpty(json)) {
				OutputStream outPutStream = httpurlconnection.getOutputStream();
				outPutStream.write(json.getBytes("UTF-8"));
				outPutStream.flush();
				outPutStream.close();
			}

			// 接口调用后获得输入流
			InputStream ins = httpurlconnection.getInputStream();

			byte[] responseData = IOUtil.readFromStream(ins);
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
			log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return "";
	}
}