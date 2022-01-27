package com.lhr.vtl;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.StringWriter;

import com.lhr.vtl.TemplateException;

public class ErrorException extends TemplateException {
    ErrorException(String s1) {
        super(s1);
    }
/*
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("s1", s1);
        StringWriter out = new StringWriter();
        jsonObj.writeJSONString(out);
        String jsonText = out.toString();
        //super(jsonText);
    }

    ErrorException(String s1, String s2) {
        super();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("s1", s1);
        jsonObj.put("s2", s2);
        StringWriter out = new StringWriter();
        jsonObj.writeJSONString(out);
        String jsonText = out.toString();
        //super(s1, s2);
    }

    ErrorException(String s1, String s2, Object o1) {
        super();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("s1", s1);
        jsonObj.put("s2", s2);
        jsonObj.put("o1", o1);
        StringWriter out = new StringWriter();
        jsonObj.writeJSONString(out);
        String jsonText = out.toString();
        //super(s1, s2, o1);
    }

    ErrorException(String s1, String s2, Object o1, Object o2) {
        super();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("s1", s1);
        jsonObj.put("s2", s2);
        jsonObj.put("o1", o1);
        jsonObj.put("o2", o2);
        StringWriter out = new StringWriter();
        jsonObj.writeJSONString(out);
        String jsonText = out.toString();
        //super(s1, s2, o1, o2);
    }
*/
}
