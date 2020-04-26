package com.example.nvmtech.utils;

import android.text.TextUtils;

import com.example.nvmtech.constants.RssTagConstant;
import com.example.nvmtech.models.apis.RssImageModel;
import com.example.nvmtech.models.apis.RssItemModel;
import com.example.nvmtech.models.apis.RssModel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RssParserUtil {
    private static RssParserUtil instance = null;

    public static RssParserUtil getInstance(){
        if (instance == null){
            instance = new RssParserUtil();
        }

        return instance;
    }

    private String getValueByTagName(Element item, String str) {
        if (item == null || TextUtils.isEmpty(str)){
            return "";
        }

        final NodeList nodes = item.getElementsByTagName(str);
        if (nodes == null || nodes.getLength() == 0){
            return "";
        }

        final Node currentNode = nodes.item(0);
        if (currentNode == null || !currentNode.hasChildNodes()){
            return "";
        }

        for (Node child = currentNode.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == Node.TEXT_NODE || (child.getNodeType() == Node.CDATA_SECTION_NODE)) {
                return child.getNodeValue();
            }
        }

        return "";
    }

    private void getInfoChannel(RssModel rssModel, Element elementChannel) throws ParseException {
        if (rssModel == null || elementChannel == null){
            return;
        }

        final String titleValue = getValueByTagName(elementChannel, RssTagConstant.TAG_TITLE);
        rssModel.setTitle(titleValue);

        final String descriptionValue = getValueByTagName(elementChannel, RssTagConstant.TAG_DESRIPTION);
        rssModel.setDescription(descriptionValue);

        final String pubDateValue = getValueByTagName(elementChannel, RssTagConstant.TAG_PUB_DATE);
        final long pubDateTimeStamp = XmlParserUtil.getInstance().parsePubDateToTimeStamp(pubDateValue);
        rssModel.setPubDate(pubDateTimeStamp);

        final String linkValue = getValueByTagName(elementChannel, RssTagConstant.TAG_LINK);
        rssModel.setLink(linkValue);

        final String generatorValue = getValueByTagName(elementChannel, RssTagConstant.TAG_GENERATOR);
        rssModel.setGenerator(generatorValue);

        // TODO: Should be update info element image from RSS
        rssModel.setImage(new RssImageModel());
    }

    private RssItemModel getItem(Element elementItem) throws ParseException {
        if (elementItem == null){
            return new RssItemModel();
        }

        final RssItemModel rssItemModel = new RssItemModel();

        final String title = getValueByTagName(elementItem, RssTagConstant.TAG_TITLE);
        rssItemModel.setTitle(title);

        final String description = getValueByTagName(elementItem, RssTagConstant.TAG_DESRIPTION);
        rssItemModel.setDescription(description);

        final String pubDate = getValueByTagName(elementItem, RssTagConstant.TAG_PUB_DATE);
        final long pubDateTimeStamp = XmlParserUtil.getInstance().parsePubDateToTimeStamp(pubDate);
        rssItemModel.setPubDate(pubDateTimeStamp);

        final String link = getValueByTagName(elementItem, RssTagConstant.TAG_LINK);
        rssItemModel.setLink(link);

        final String guid = getValueByTagName(elementItem, RssTagConstant.TAG_GUID);
        rssItemModel.setGuid(guid);

        final String comments = getValueByTagName(elementItem, RssTagConstant.TAG_COMMENT);
        final int totalComment =  Integer.parseInt(comments);
        rssItemModel.setComments(totalComment);

        return rssItemModel;
    }

    private void getItemsChannel(RssModel rssModel, Element elementChannel) throws ParseException {
        if (rssModel == null || elementChannel == null){
            return;
        }

        final NodeList items = elementChannel.getElementsByTagName(RssTagConstant.TAG_ITEM);
        if (items == null || items.getLength() == 0){
            return;
        }

        List<RssItemModel> rssItems = new ArrayList<RssItemModel>();

        int length = items.getLength();
        for (int i = 0; i < length; ++i ){
            final Element elementItem = (Element)items.item(i);

            final RssItemModel item = getItem(elementItem);
            rssItems.add(item);
        }

        rssModel.setItems(rssItems);
    }

    public  RssModel parseXmlToRssModel(String rssXml) throws ParseException {
        if (TextUtils.isEmpty(rssXml)) {
            return null;
        }

        final Document currentDocument = XmlParserUtil.getInstance().getDomElement(rssXml);
        if (currentDocument == null){
            return null;
        }


        final NodeList nodeList = currentDocument.getElementsByTagName(RssTagConstant.TAG_CHANNEL);
        final Element firstestChannel = (Element) nodeList.item(0);
        if (firstestChannel == null){
            return null;
        }

        final NodeList childsChannel = firstestChannel.getChildNodes();
        if (childsChannel == null || childsChannel.getLength() == 0){
            return null;
        }

        final RssModel rssModel = new RssModel();
        getInfoChannel(rssModel, firstestChannel);
        getItemsChannel(rssModel, firstestChannel);

        return rssModel;
    }
}
