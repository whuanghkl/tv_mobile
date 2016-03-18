package com.web.controller.comm;

import com.common.util.SystemHWUtil;
import com.io.hw.json.HWJacksonUtils;
import oa.service.DictionaryParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangweii on 2016/3/18.<br>
 * (1)推送服务器ip
 * (2)推送服务器端口
 * (3)移动端html的地址(包括ip)
 * (4)后台接口的地址
 */
@Controller
@RequestMapping("/tv_config")
public class ConfigController {
    /***
     * 推送服务器ip
     */
    public static final String PUSH_SERVER_IP = "pushserver_ip";
    /***
     * 推送服务器的端口号
     */
    public static final String PUSH_SERVER_PORT = "pushserver_port";
    /***
     * html5 静态资源的地址<br>例如:http://hbjltv.com/
     */
    public static final String MOBILE_HTML_RESOURCES_URL = "html_static_url";
    /***
     * 后台接口地址<br>例如:http://hbjltv.com/
     */
    public static final String RESTFUL_API_URL = "restful_api_url";
    /***
     * apk的下载地址
     */
    public static final String DOWNLOAD_APK_URL = "apk_download_url";

    public static String getConfig(String key) {
        return DictionaryParam.get("tv_config", key);
    }

    @ResponseBody
    @RequestMapping(value = "/config", produces = SystemHWUtil.RESPONSE_CONTENTTYPE_JSON_UTF)
    public String config(Model model, HttpServletRequest request) {
        Map<String, String> configMap = new HashMap<String, String>();
        configMap.put(PUSH_SERVER_IP, getConfig("pushserver_ip"));
        configMap.put(PUSH_SERVER_PORT, getConfig("pushserver_port"));
        configMap.put(MOBILE_HTML_RESOURCES_URL, getConfig("html_static_url"));
        configMap.put(RESTFUL_API_URL, getConfig("restful_api_url"));
        configMap.put(DOWNLOAD_APK_URL, getConfig("apk_download_url"));
        return HWJacksonUtils.getJsonP(configMap);
    }
}