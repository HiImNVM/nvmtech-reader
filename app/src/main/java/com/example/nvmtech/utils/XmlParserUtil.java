package com.example.nvmtech.utils;

import android.text.TextUtils;

import com.example.nvmtech.constants.RssTagConstant;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParserUtil  {
    private static XmlParserUtil instance = null;

    public static XmlParserUtil getInstance(){
        if (instance == null){
            instance = new XmlParserUtil();
        }

        return instance;
    }

    public long parsePubDateToTimeStamp(String pubDate) throws ParseException {
        if (TextUtils.isEmpty(pubDate)){
            return 0;
        }

        return new SimpleDateFormat(RssTagConstant.PATTERN_PUB_DATE, Locale.ENGLISH).parse(pubDate).getTime();
    }

    public Document getDomElement(String xml) {
        if (TextUtils.isEmpty(xml)){
            return null;
        }

        Document doc = null;

        try {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            final DocumentBuilder db = dbf.newDocumentBuilder();
            final InputSource inputSource = new InputSource();

            inputSource.setCharacterStream(new StringReader(xml));
            doc = db.parse(inputSource);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            LoggerUtil.e("getDomElement", e.getMessage(), e);
        }

        return doc;
    }
}
