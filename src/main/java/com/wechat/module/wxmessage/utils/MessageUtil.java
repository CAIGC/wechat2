package com.wechat.module.wxmessage.utils;


import com.wechat.module.wxmessage.bean.response.Article;
import com.wechat.module.wxmessage.bean.response.NewsMessage;
import com.wechat.module.wxmessage.bean.response.RespTextMessage;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by CAI_GC on 2016/12/2.
 */
public class MessageUtil {

	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
  
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";  
  
    
    /** 
     * 解析微信发来的请求（XML） 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    @SuppressWarnings("unchecked")  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
  
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    }  
  
    /** 
     * 文本消息对象转换成xml 
     *  
     * @param textMessage 文本消息对象 
     * @return xml 
     */  
   /* public static String textMessageToXml(RespTextMessage textMessage) {  
        xstream.alias("xml", textMessage.getClass());  
        return xstream.toXML(textMessage);  
    }  */
  
//    <xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>12345678</CreateTime>
//    <MsgType><![CDATA[text]]></MsgType>
//    <Content><![CDATA[你好]]></Content>
//    </xml>
    
    public static String textMessageToXml(RespTextMessage textMessage){
    	
    	StringBuffer buffer= new StringBuffer();
    	
    	buffer.append("<xml>");
    	
    	String ToUserName = textMessage.getToUserName();
    	
    	String FromUserName = textMessage.getFromUserName();
    	
    	long CreateTime = textMessage.getCreateTime();
    	
    	String MsgType = textMessage.getMsgType();
    	
    	String Content = textMessage.getContent();
    	
    	buffer.append("<ToUserName><![CDATA["+ToUserName+"]]></ToUserName>");
    	
    	buffer.append("<FromUserName><![CDATA["+FromUserName+"]]></FromUserName>");
    	
    	buffer.append("<CreateTime>"+CreateTime+"</CreateTime>");
    	
    	buffer.append("<MsgType><![CDATA["+MsgType+"]]></MsgType>");
    	
    	buffer.append("<Content><![CDATA["+Content+"]]></Content>");
    	
    	buffer.append("</xml>");
    	
		return buffer.toString();
    	    	
    }
    
    
    /** 
     * 音乐消息对象转换成xml 
     *  
     * @param musicMessage 音乐消息对象 
     * @return xml 
     */  
    /*public static String musicMessageToXml(RespMusicMessage musicMessage) {  
        xstream.alias("xml", musicMessage.getClass());  
        return xstream.toXML(musicMessage);  
    } */ 
  
    /** 
     * 图文消息对象转换成xml 
     *  
     * @param newsMessage 图文消息对象 
     * @return xml 
     */  
    /*public static String newsMessageToXml(NewsMessage newsMessage) {  
        xstream.alias("xml", newsMessage.getClass());  
        xstream.alias("item", new Article().getClass());  
        return xstream.toXML(newsMessage);  
    } */ 
  
//    <xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>12345678</CreateTime>
//    <MsgType><![CDATA[news]]></MsgType>
//    <ArticleCount>2</ArticleCount>
//    <Articles>
//    <item>
//    <Title><![CDATA[title1]]></Title> 
//    <Description><![CDATA[description1]]></Description>
//    <PicUrl><![CDATA[picurl]]></PicUrl>
//    <Url><![CDATA[url]]></Url>
//    </item>
//    <item>
//    <Title><![CDATA[title]]></Title>
//    <Description><![CDATA[description]]></Description>
//    <PicUrl><![CDATA[picurl]]></PicUrl>
//    <Url><![CDATA[url]]></Url>
//    </item>
//    </Articles>
//    </xml> 
    public static String newsMessageToXml(NewsMessage newsMessage){

        StringBuffer buffer= new StringBuffer();
        buffer.append("<xml>");
        String ToUserName = newsMessage.getToUserName();
        String FromUserName = newsMessage.getFromUserName();
        long CreateTime = newsMessage.getCreateTime();
        String MsgType = newsMessage.getMsgType();
        List<Article> Articles = newsMessage.getArticles();
        buffer.append("<ToUserName><![CDATA["+ToUserName+"]]></ToUserName>");
        buffer.append("<FromUserName><![CDATA["+FromUserName+"]]></FromUserName>");
        buffer.append("<CreateTime>"+CreateTime+"</CreateTime>");
        buffer.append("<MsgType><![CDATA["+MsgType+"]]></MsgType>");
        buffer.append("<ArticleCount>"+Articles.size()+"</ArticleCount>");
        buffer.append("<Articles>");
        for(Article Article: Articles){
            buffer.append("<item>");

            buffer.append("<Title><![CDATA["+Article.getTitle()+"]]></Title>");
            buffer.append("<Description><![CDATA["+Article.getDescription()+"]]></Description>");
            buffer.append("<PicUrl><![CDATA["+Article.getPicUrl()+"]]></PicUrl>");
            buffer.append("<Url><![CDATA["+Article.getUrl()+"]]></Url>");

            buffer.append("</item>");
        }
        buffer.append("</Articles>");
        buffer.append("</xml>");
        return buffer.toString();
    	
    }
    
    
    
    
    
    
    
    
    /** 
     * 扩展xstream，使其支持CDATA块 
     *  
     * @date 2013-05-19 
     */  
    /*private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;  
  
                @SuppressWarnings("unchecked")  
                public void startNode(String name, Class clazz) {  
                    super.startNode(name, clazz);  
                }  
  
                protected void writeText(QuickWriter writer, String text) {  
                    if (cdata) {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    });*/
    
    
    
}
