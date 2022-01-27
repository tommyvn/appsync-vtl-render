package com.lhr.vtl.cli;

import java.io.StringWriter;
// import java.io.File;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.exception.MethodInvocationException;

import com.lhr.vtl.Util;
import com.lhr.vtl.util.DynamoDB;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class Main {
    public static void main(String[] args) throws java.io.IOException, java.lang.NoSuchMethodException {
        Velocity.init();

        VelocityContext context = new VelocityContext();
        context.put("util", new Util());
        context.put("utils", context.get("util"));

        JSONArray jsonTemplatesArr = new JSONArray();

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("results", jsonTemplatesArr);

        for (String templateFileName : args) {
            Template template = null;

            // String canonicalTemplateFileName = new File(templateFileName).getCanonicalPath();
            // template = Velocity.getTemplate(canonicalTemplateFileName);
            template = Velocity.getTemplate(templateFileName);

            StringWriter out = new StringWriter();

            JSONObject renderJsonObj = new JSONObject();
            renderJsonObj.put("file", templateFileName);

            try {
                template.merge(context, out);
                renderJsonObj.put("render", out.toString());
                jsonTemplatesArr.add(renderJsonObj);
                // jsonTemplatesArr.add(out.toString());
            } catch (MethodInvocationException e) {
                renderJsonObj.put("error", e.getWrappedThrowable().getMessage());
                jsonTemplatesArr.add(renderJsonObj);
                //jsonObj.put("error", e.getWrappedThrowable().getMessage());
                break;
            }
        }

        StringWriter out = new StringWriter();

        jsonObj.writeJSONString(out);

        String jsonText = out.toString();
        System.out.print(jsonText);
    }
}
