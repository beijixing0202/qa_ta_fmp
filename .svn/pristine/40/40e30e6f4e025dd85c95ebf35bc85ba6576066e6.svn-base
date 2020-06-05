package com.bill99.fmp.common.utils;

import java.util.Iterator;
import java.util.Map;

public class StringUtil {

    public String dictToString(Map<String,String> map){
        StringBuffer buffer = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();){
            Map.Entry entry = (Map.Entry) iterator.next();
            buffer.append(entry.getValue()+";");
        }
        return String.valueOf(buffer.deleteCharAt(buffer.length()-1));
    }
}
