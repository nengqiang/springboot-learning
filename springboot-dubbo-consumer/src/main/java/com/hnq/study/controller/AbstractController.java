package com.hnq.study.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
public class AbstractController {

    public HashMap<String, String> parseRequestParameter(HttpServletRequest request) {
        HashMap<String, String> ret = new HashMap<String, String>();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            ret.put(name, request.getParameter(name));
        }
        return ret;
    }

    public Integer getInt(HttpServletRequest request, String key, Integer defaultValue) {

        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            try {
                return Integer.parseInt(parameter);
            } catch (NumberFormatException e) {
            }
        }

        return defaultValue;
    }

    public Long getLong(HttpServletRequest request, String key, Long defaultValue) {
        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            try {
                return Long.parseLong(parameter);
            } catch (NumberFormatException e) {
            }
        }

        return defaultValue;
    }

    public Byte getByte(HttpServletRequest request, String key, Byte defaultValue) {
        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            try {
                return Byte.parseByte(parameter);
            } catch (NumberFormatException e) {
            }
        }

        return defaultValue;
    }

    public String getString(HttpServletRequest request, String key, String defaultValue) {

        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            return parameter;
        }

        return defaultValue;
    }

    public Boolean getBoolean(HttpServletRequest request, String key, Boolean defaultValue) {

        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            return Boolean.valueOf(parameter);
        }

        return defaultValue;
    }

    public BigDecimal getBigDecimal(HttpServletRequest request, String key, BigDecimal defaultValue) {

        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            return BigDecimal.valueOf(Double.parseDouble(parameter));
        }

        return defaultValue;
    }

    public Integer[] getInts(HttpServletRequest request, String key, Integer[] defaultValue) {

        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            String[] split = parameter.split(",");
            Integer[] res = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                res[i] = Integer.parseInt(split[i]);
            }
            return res;
        }

        return defaultValue;
    }

    public Long[] getLongs(HttpServletRequest request, String key, Long[] defaultValue) {

        String parameter = request.getParameter(key);

        if (StringUtils.isNoneBlank(parameter)) {
            String[] split = parameter.split(",");
            Long[] res = new Long[split.length];
            for (int i = 0; i < split.length; i++) {
                res[i] = Long.parseLong(split[i]);
            }
            return res;
        }

        return defaultValue;
    }

    public HttpSession getSession() {
        return getRequest().getSession();
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }

    public <T> T getSessionAttribute(String attrName, Class<T> clazz) {
        Object o = getSession().getAttribute(attrName);
        if (null != o) {
            return (T) o;
        }
        return null;
    }

}
