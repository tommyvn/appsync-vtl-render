package com.lhr.vtl;

import com.lhr.vtl.UnauthorizedException;
import com.lhr.vtl.ErrorException;
import com.lhr.vtl.util.DynamoDB;
import com.google.gson.Gson;

import java.util.Map;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class Util {
    public static String unauthorized() throws UnauthorizedException {
        throw new UnauthorizedException();
    }

    public static String error(String s) throws ErrorException {
        throw new ErrorException(s);
    }

    public static String error(String sMsg, String sType) throws ErrorException {
        throw new ErrorException(sType + ": " + sMsg);
    }

    public static String error(String s1, String s2, Object o1, Object o2) throws ErrorException {
        throw new ErrorException(s1);
    }

    private static DynamoDB dynamodb = new DynamoDB();

    public static DynamoDB getdynamodb() {
        return dynamodb;
    }

    public static boolean isBoolean(Boolean x) {
        return true;
    }

    public static boolean isBoolean(Object x) {
        return false;
    }

    public static boolean isNull(Object x) {
        return (x == null);
    }

    public static boolean isNullOrEmpty(String x) {
        return (isNull(x) || x.isEmpty());
    }

    public static boolean isNullOrEmpty(Object x) {
        return isNull(x);
    }

    public static Object defaultIfNull(Object x, Object y) {
        return isNull(x) ? y : x;
    }

    public static Object defaultIfNullOrEmpty(Object x, Object y) {
        return isNullOrEmpty(x) ? y : x;
    }

    public static Object defaultIfNullOrEmpty(String x, Object y) {
        return isNullOrEmpty(x) ? y : x;
    }

    public static Object defaultIfNullOrBlank(String x, Object y) {
        return (x == null || x.isBlank()) ? y : x;
    }

    public static Object defaultIfNullOrBlank(Object x, Object y) {
        return (x == null) ? y : x;
    }

    public static String toJson(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }

    public static Object parseJson(String o) {
        Gson gson = new Gson();
        return gson.fromJson(o, Object.class);
    }

    public static String quiet(Object m) {
        return "";
    }

    public static boolean isMap(Map m) {
        return true;
    }

    public static boolean isMap(Object m) {
        return false;
    }

    public static boolean isList(List m) {
        return true;
    }

    public static boolean isList(Object m) {
        return false;
    }

    public static boolean isString(String x) {
        return true;
    }

    public static boolean isString(Object x) {
        return false;
    }

    public static boolean isNumber(Integer x) {
        return true;
    }

    public static boolean isNumber(Float x) {
        return true;
    }

    public static boolean isNumber(Object x) {
        return false;
    }

    private char[] autoid = "99999999999999999999999999999999".toCharArray();

    public String autoId() {
        for (int i = autoid.length - 1; i >= 0; --i) {
            if (autoid[i] == '9') {
                autoid[i] = 'a';
            } else if (autoid[i] == 'f') {
                autoid[i] = '0';
                break;
            } else {
                autoid[i] += 1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(autoid, 0, 8);
        sb.append("-");
        sb.append(autoid, 8, 4);
        sb.append("-");
        sb.append(autoid, 12, 4);
        sb.append("-");
        sb.append(autoid, 16, 4);
        sb.append("-");
        sb.append(autoid, 20, 12);
        return sb.toString();
    }

    public static String base64Encode(byte[] bs) {
        byte[] encodedBytes = Base64.encodeBase64(bs);
        return new String(encodedBytes);
    }

}
