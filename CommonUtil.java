package com.ctsi.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;
public class CommonUtil {

	
	/**
	 * 主机状态转换
	 * 
	 * @param status
	 * @return
	 */

	public static ZonedDateTime toZonedDateTime(Date utilDate) {
		if (utilDate == null) {
			return null;
		}
		final ZoneId systemDefault = ZoneId.systemDefault();
		return ZonedDateTime.ofInstant(utilDate.toInstant(), systemDefault);
	}

	/**
	 * 获取每个接口的customInfo信息
	 *
	 * @param customInfo_map
	 * @return
	 */
	public static JSONObject getCustomInfo(Map<String, Object> customInfo_map) {
		JSONObject customInfo = new JSONObject();
		JSONObject identity = new JSONObject();
		if (null != customInfo_map && !customInfo_map.isEmpty()) {
			String customInfoname = customInfo_map.get("name").toString();
			if ("1".equals(customInfo_map.get("type"))) {
				customInfo.put("name", customInfoname);
				customInfo.put("email", customInfo_map.get("email"));
				customInfo.put("phone", customInfo_map.get("phone"));
				customInfo.accumulate("type", customInfo_map.get("type"));
				identity.accumulate("crmBizId", customInfo_map.get("crmBizId"));
				customInfo.accumulate("identity", identity);
			} else if ("2".equals(customInfo_map.get("type"))) {
				customInfo.put("name", customInfoname);
				customInfo.put("email", customInfo_map.get("email"));
				customInfo.put("phone", customInfo_map.get("phone"));
				customInfo.accumulate("type", customInfo_map.get("type"));
				identity.accumulate("accountId", customInfo_map.get("accountId"));
				customInfo.accumulate("identity", identity);
			} else {
				customInfo.put("name", customInfoname);
				customInfo.put("email", customInfo_map.get("email"));
				customInfo.put("phone", customInfo_map.get("phone"));
				customInfo.accumulate("type", customInfo_map.get("type"));
			}
			return customInfo;
		}
		return new JSONObject();
	}
}
