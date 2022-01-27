package com.lhr.vtl.util;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemUtils;

import java.util.Map;
import java.util.HashMap;

import com.google.gson.Gson;

public class DynamoDB {
    public static Object toDynamoDB(Object o) {
        Map datamap = new HashMap();
        datamap.put("data", o);

        Map dynamoDBMap = ItemUtils.fromSimpleMap(datamap);
        Object map = dynamoDBMap.get("data");
        return map;
    }

    public static String toDynamoDBJson(Object o) {
        Map map = new HashMap();
        map.put("data", o);

        Map dynamoDBMap = ItemUtils.fromSimpleMap(map);
        Gson gson = new Gson();
        String json = gson.toJson(dynamoDBMap.get("data"));
        return json;
    }

    public static String toMapValuesJson(Map o) {
        Map dynamoDBMap = ItemUtils.fromSimpleMap(o);
        Gson gson = new Gson();
        String json = gson.toJson(dynamoDBMap);
        return json;
    }
}
