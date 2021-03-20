package com.testing.class7;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonTest {
    public static void main(String[] args) {
        String ipResult="jQuery1102029793080973590014_1607261163703({\"ResultCode\":\"0\",\"ResultNum\":\"1\",\"Result\":[{\"DisplayData\":{\"strategy\":{\"tempName\":\"ip\",\"precharge\":\"0\",\"ctplOrPhp\":\"1\"},\"resultData\":{\"tplData\":{\"srcid\":\"5809\",\"resourceid\":\"5809\",\"OriginQuery\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"query\":\"3.3.3.3\",\"origip\":\"3.3.3.3\",\"location\":\"\\u7f8e\\u56fd \\u4e9a\\u9a6c\\u900a\\u4e91\",\"userip\":\"\",\"showlamp\":\"1\",\"tplt\":\"ip\",\"titlecont\":\"IP\\u5730\\u5740\\u67e5\\u8be2\",\"realurl\":\"http:\\/\\/www.ip138.com\\/\",\"showLikeShare\":\"1\",\"shareImage\":\"1\",\"data_source\":\"AE\"},\"extData\":{\"tplt\":\"ip\",\"resourceid\":\"5809\",\"OriginQuery\":\"3.3.3.3\"}}},\"ResultURL\":\"http:\\/\\/www.ip138.com\\/\",\"Weight\":\"2\",\"Sort\":\"1\",\"SrcID\":\"5809\",\"ClickNeed\":\"0\",\"SubResult\":[],\"SubResNum\":\"0\",\"ar_passthrough\":[],\"RecoverCacheTime\":\"0\"}],\"QueryID\":\"172091755\",\"Srcid\":\"5809\",\"status\":\"0\",\"data\":[{\"srcid\":\"5809\",\"resourceid\":\"5809\",\"OriginQuery\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"query\":\"3.3.3.3\",\"origip\":\"3.3.3.3\",\"location\":\"\\u7f8e\\u56fd \\u4e9a\\u9a6c\\u900a\\u4e91\",\"userip\":\"\",\"showlamp\":\"1\",\"tplt\":\"ip\",\"titlecont\":\"IP\\u5730\\u5740\\u67e5\\u8be2\",\"realurl\":\"http:\\/\\/www.ip138.com\\/\",\"showLikeShare\":\"1\",\"shareImage\":\"1\"}]})";

        //以{为开头的字符，(.*?)表示是长度不定的任意字符组成的词组
        String regex="\\{(.*?)}]}";


        //基于正则表达式创建一个模板
        Pattern ipPattern =Pattern.compile(regex);
        //基于模板，为想要匹配的内容，创建一个匹配器
        Matcher ipMatch=ipPattern.matcher(ipResult);
        //匹配器进行查找，结果为布尔值
        System.out.println(ipMatch.find());
//        System.out.println(ipPattern);
//        System.out.println(ipMatch);
        //将查找结果分成2部分，因为正则表达式中包含两部分内容，group(0)是包含{ }]}里面的字符内容,
        String ipJson=ipMatch.group(0);
//        System.out.println(ipMatch.group(0));
//        //group(1)是包含(.*?)里面的字符内容
//        System.out.println(ipMatch.group(1));



        //解析json
        Map<String,String> ipMap=new HashMap<>();
        //将一个字符串，解析成为jsonObject对象
        JSONObject ipJsonObject = JSON.parseObject(ipJson);
        //遍历jsonObject中的json键值对
        for (String key : ipJsonObject.keySet()) {
            //System.out.println(key+":"+ipJsonObject.get(key));
            //由于get方法获取到的是object类型的对象，而Map指定的value类型是String,所以统一toString
            ipMap.put(key,ipJsonObject.get(key).toString());

        }
        //转换成Map格式
        System.out.println("转换成Map格式是"+ipMap);

//        //已知result存储的内容是一个数组，解析的时候，可以把result获取作为jsonArray的对象
//        //1、通过get获取到json字符串键对应的值为object，然后强转为JSONArray
        JSONArray resultArray=(JSONArray)ipJsonObject.get("Result");
//        //2、直接通过getJSONArray的方法，获取出来的就是个JSONArray类型的对象
//        //JSONArray resultArray1=ipJsonObject.getJSONArray("Result");

        System.out.println("Result数组的值是"+resultArray.toString());
        //将resultArray这个对象中的内容，按下标取值
        //JSONObject强转类型
        JSONObject resultJson=(JSONObject)resultArray.get(0);
        System.out.println("resultJson字符串中第一个字符串的值是"+resultJson);

        //对于resultJson的解析
        for (String json : resultJson.keySet()) {
            System.out.println(json+":"+resultJson.get(json));
        }
    }
}