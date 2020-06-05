package com.bill99.fmp.common.utils;

import org.testng.Reporter;
import org.testng.log4testng.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class XMLParser {
    private static Logger logger = Logger.getLogger(XMLParser.class);
    private String xmlPath;

    public XMLParser(){

    }

    public XMLParser(String _xmlPath) {
        this.xmlPath = _xmlPath;
    }

    public Map<String, List<String>> parser(String expression) {
//        logger.debug("parser expression : " + expression);
        new ConcurrentHashMap();
        String[] exprArray = expression.split("/|\\$|\\.|#");
        Map<String, List<String>> finalMap = this.loadXMLElement(exprArray[0]);
//        logger.debug("parser exprArray : " + exprArray);

        for(int i = 1; i < exprArray.length; ++i) {
            int indexArr = expression.indexOf(exprArray[i]);
            String symbol = expression.substring(indexArr - 1, indexArr);
//            logger.debug("symbol : " + symbol);
            byte var8 = -1;
            switch(symbol.hashCode()) {
                case 35:
                    if (symbol.equals("#")) {
                        var8 = 2;
                    }
                    break;
                case 36:
                    if (symbol.equals("$")) {
                        var8 = 1;
                    }
                    break;
                case 47:
                    if (symbol.equals("/")) {
                        var8 = 0;
                    }
            }

            switch(var8) {
                case 0:
                    finalMap = this.loadChildElement(finalMap, exprArray[i]);
                    break;
                case 1:
                    finalMap = this.loadElementIncludeAttri(finalMap, exprArray[i]);
                    break;
                case 2:
                    finalMap = this.loadElementExcludeAttri(finalMap, exprArray[i]);
                    break;
                default:
//                    logger.debug("not support anlyze symbol , please add !");
            }
        }

        return finalMap;
    }

    private Map<String, List<String>> loadChildElement(Map<String, List<String>> map, String element) {
//        logger.debug("loadChildElement : ");
        Map<String, List<String>> exitMap = new ConcurrentHashMap();
        Set<String> set = map.keySet();
        Iterator var5 = set.iterator();

        while(true) {
            while(var5.hasNext()) {
                String key = (String)var5.next();
                List<String> attriList = (List)map.get(key);
                if (key.contains(element)) {
                    exitMap.put(key, attriList);
                } else {
                    Iterator var8 = attriList.iterator();

                    while(var8.hasNext()) {
                        String attri = (String)var8.next();
                        if (attri.contains(element)) {
                            exitMap.put(key, attriList);
                            break;
                        }
                    }
                }
            }

            return exitMap;
        }
    }

    private Map<String, List<String>> loadElementIncludeAttri(Map<String, List<String>> map, String attriNameVal) {
        Map<String, List<String>> exitMap = new ConcurrentHashMap();
        Set<String> set = map.keySet();
        Iterator var5 = set.iterator();

        while(true) {
            while(var5.hasNext()) {
                String key = (String)var5.next();
                List<String> attriList = (List)map.get(key);
                Iterator var8 = attriList.iterator();

                while(var8.hasNext()) {
                    String attri = (String)var8.next();
                    if (attri.contains(attriNameVal)) {
                        exitMap.put(key, attriList);
                        break;
                    }
                }
            }

            return exitMap;
        }
    }

    private Map<String, List<String>> loadElementExcludeAttri(Map<String, List<String>> map, String attriNameVal) {
        Set<String> set = map.keySet();
        Iterator var4 = set.iterator();

        while(true) {
            while(var4.hasNext()) {
                String key = (String)var4.next();
                List<String> attriList = (List)map.get(key);
                Iterator var7 = attriList.iterator();

                while(var7.hasNext()) {
                    String attri = (String)var7.next();
                    if (attri.contains(attriNameVal)) {
                        map.remove(key);
                        break;
                    }
                }
            }

            return map;
        }
    }

    public Map<String, List<String>> loopXMLFile() {
        Object pageMap = new HashMap();

        try {
            File file = new File(this.xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            if (doc.hasChildNodes()) {
                pageMap = this.printNote((Map)pageMap, doc.getChildNodes(), "");
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return (Map)pageMap;
    }

    private Map<String, List<String>> loadXMLElement(String nodeName) {
        HashMap pageMap = new HashMap();

        try {
            File file = new File(this.xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            if (doc.hasChildNodes()) {
                return this.printNote(pageMap, doc.getChildNodes(), nodeName);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return pageMap;
    }

    private Map<String, List<String>> printNote(Map<String, List<String>> pageMap, NodeList nodeList, String nodeName) {
        List<String> attriList = null;

        for(int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            String key = node.getNodeName();
            if (node.getNodeType() == 1 && (node.getNodeName().equals(nodeName) || nodeName.equals(""))) {
                if (node.hasAttributes()) {
                    NamedNodeMap nodeMap = node.getAttributes();
                    attriList = new ArrayList();
                    key = key + "." + node.getAttributes().item(0).getNodeValue();

                    for(int j = 0; j < nodeMap.getLength(); ++j) {
                        Node nd = nodeMap.item(j);
                        attriList.add(nd.getNodeName() + "=" + nd.getNodeValue());
                    }
                }

                pageMap.put(key, attriList);
                if (node.hasChildNodes()) {
                    this.printNote(pageMap, node.getChildNodes(), "");
                }
            }
        }

        return pageMap;
    }

    public static Map<String, Map<String, String>> parserXML(String xmlPath) {
        HashMap finalMap = new HashMap();

        try {
            File file = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node baseNode = doc.getChildNodes().item(0);
            if (baseNode.hasChildNodes()) {
                return printAttribute(finalMap, baseNode.getChildNodes());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return finalMap;
    }

    private static Map<String, Map<String, String>> printAttribute(Map<String, Map<String, String>> map, NodeList nodeList) {
        Map<String, String> attriList = null;

        for(int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            String key = node.getParentNode().getNodeName();
            if (node.getParentNode().getAttributes().getNamedItem("eleName") == null) {
                key = key + "." + node.getParentNode().getAttributes().item(0).getNodeValue();
            } else {
                key = key + "." + node.getParentNode().getAttributes().getNamedItem("eleName").getNodeValue();
            }

            if (node.getNodeType() == 1) {
                if (node.hasAttributes()) {
                    NamedNodeMap nodeMap = node.getAttributes();
                    key = key + "." + nodeMap.getNamedItem("eleName").getNodeValue();
                    attriList = new HashMap();

                    for(int j = 0; j < nodeMap.getLength(); ++j) {
                        Node nd = nodeMap.item(j);
                        attriList.put(nd.getNodeName(), nd.getNodeValue());
                    }

//                    logger.debug("key : " + key + "  attriList : " + attriList);
                    map.put(key, attriList);
                }

                if (node.hasChildNodes()) {
                    printAttribute(map, node.getChildNodes());
                }
            }
        }

        return map;
    }

    public static void main(String[] args){
        Map<String, Map<String, String>> map = XMLParser.parserXML("src\\main\\resources\\pages\\login.xml");
        System.out.println(map);

       /* Set<String> set = map.keySet();
        Iterator var3 = set.iterator();
        while(var3.hasNext()) {
            String key = (String)var3.next();
            System.out.println("key:" + key);
            Map<String, String> attriList = (Map)map.get(key);
            Set<String> setValue = attriList.keySet();
            Iterator var7 = setValue.iterator();

            while(var7.hasNext()) {
                String key2 = (String)var7.next();
                System.out.println(key2 + ":value:" + (String)attriList.get(key2));
            }
        }*/
        findElement(map,"pages.首页.汇款");

    }

    public static String findElement(Map<String, Map<String, String>> map,String locationVa){
        Set<String> set = map.keySet();
        Iterator var3 = set.iterator();
        while (var3.hasNext()){
            String key = (String)var3.next();
            if (key.equals(locationVa)){
                Map<String, String> childMap = (Map)map.get(key);
                System.out.print(childMap.get("locat"));
                return childMap.get("locat");
            }
        }
        return null;
    }
}


