package com.testing.class7;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonMap {
    public static void main(String[] args) {
        String ipResult="jQuery1102029793080973590014_1607261163703({\"ResultCode\":\"0\",\"ResultNum\":\"1\",\"Result\":[{\"DisplayData\":{\"strategy\":{\"tempName\":\"ip\",\"precharge\":\"0\",\"ctplOrPhp\":\"1\"},\"resultData\":{\"tplData\":{\"srcid\":\"5809\",\"resourceid\":\"5809\",\"OriginQuery\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"query\":\"3.3.3.3\",\"origip\":\"3.3.3.3\",\"location\":\"\\u7f8e\\u56fd \\u4e9a\\u9a6c\\u900a\\u4e91\",\"userip\":\"\",\"showlamp\":\"1\",\"tplt\":\"ip\",\"titlecont\":\"IP\\u5730\\u5740\\u67e5\\u8be2\",\"realurl\":\"http:\\/\\/www.ip138.com\\/\",\"showLikeShare\":\"1\",\"shareImage\":\"1\",\"data_source\":\"AE\"},\"extData\":{\"tplt\":\"ip\",\"resourceid\":\"5809\",\"OriginQuery\":\"3.3.3.3\"}}},\"ResultURL\":\"http:\\/\\/www.ip138.com\\/\",\"Weight\":\"2\",\"Sort\":\"1\",\"SrcID\":\"5809\",\"ClickNeed\":\"0\",\"SubResult\":[],\"SubResNum\":\"0\",\"ar_passthrough\":[],\"RecoverCacheTime\":\"0\"}],\"QueryID\":\"172091755\",\"Srcid\":\"5809\",\"status\":\"0\",\"data\":[{\"srcid\":\"5809\",\"resourceid\":\"5809\",\"OriginQuery\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"query\":\"3.3.3.3\",\"origip\":\"3.3.3.3\",\"location\":\"\\u7f8e\\u56fd \\u4e9a\\u9a6c\\u900a\\u4e91\",\"userip\":\"\",\"showlamp\":1,\"tplt\":\"ip\",\"titlecont\":\"IP\\u5730\\u5740\\u67e5\\u8be2\",\"realurl\":\"http:\\/\\/www.ip138.com\\/\",\"showLikeShare\":\"1\",\"shareImage\":\"1\"}]})";
        Map<String,String> ipMap=new HashMap<>();

        //正则表达式
        String regex="\\{(.*?)}]}";
        //基于正则表达式创建模板
        Pattern ipPattern=Pattern.compile(regex);
        //基于模板，创建匹配器
        Matcher ipMatch=ipPattern.matcher(ipResult);
        //根据匹配器进行查找
        ipMatch.find();
        //根据匹配器得到json内容
        String ipJson=ipMatch.group(0);


        //解析json，存为json对象
        JSONObject ipJsonObject= JSON.parseObject(ipJson);
        //遍历json对象
        for (String key : ipJsonObject.keySet()) {
                ipMap.put(key,ipJsonObject.get(key).toString());
        }
        System.out.println("转换成Map格式是"+ipMap);

        //截取data的值
        String ipMapString=ipMap.get("data").toString() ;
        System.out.println(ipMapString);
        //去掉{}，获取data中的json字符串
        String dataJsonStr=ipMapString.substring(1,ipMapString.length()-1);
        
        JSONObject dataJson=JSONObject.parseObject(dataJsonStr);
        System.out.println("dataJson的值是"+dataJson);
        //解析dataJson的内容，存到Map中
        Map<String,Object> dataMap=new HashMap<>();
        for (String key : dataJson.keySet()) {
            dataMap.put(key,dataJson.get(key));
        }
        System.out.println("data中的内容转换成Map后的结果是"+dataMap);

        //将map中的内容，重新拼接成字符串
        //遍历map中的值
        String resultJson="{";
        for (Map.Entry<String, Object> dataMapvalue : dataMap.entrySet()) {
            // 判断map中value的值，第一种，值是字符串形式，需要加""
            if(dataMapvalue.getValue() instanceof String){
                resultJson=resultJson+"\""+dataMapvalue.getKey()+"\""+":"+"\""+dataMapvalue.getValue()+"\""+",";
            }
            //第二种，值不是字符串形式，不需要加""
            else{
                resultJson=resultJson+"\""+dataMapvalue.getKey()+"\""+":"+dataMapvalue.getValue()+",";
            }
        }
        resultJson=resultJson.substring(0,resultJson.length()-1);
        resultJson=resultJson+"}";
        System.out.println("由map转换成json字符串的结果是"+resultJson);
    }
}
