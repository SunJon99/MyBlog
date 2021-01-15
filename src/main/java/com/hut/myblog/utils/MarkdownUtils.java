package com.hut.myblog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

public class MarkdownUtils {
    public static String  markdownTOHtml(String markdown){

        //扩展功能：为每个标题设置一个id，用于跳转
        Set<Extension> headingAnchorExtension = Collections.singleton(HeadingAnchorExtension.create());
        //扩展功能：markdown表转换为html的表
        List<Extension> TableExtension = Arrays.asList(TablesExtension.create());

        Parser parser = Parser.builder()
                .extensions(TableExtension)
                .build();

        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(TableExtension)
                .extensions(headingAnchorExtension)
                .attributeProviderFactory(attributeProviderContext -> new CustomAttributeProvider())
                .build();

        Node document = parser.parse(markdown);
        return renderer.render(document);
    }

    static class CustomAttributeProvider implements AttributeProvider {

        @Override
        public void setAttributes(Node node, String s, Map<String, String> map) {
            if (node instanceof TableBlock) {
                map.put("class", "ui celled table");
            }
        }
    }
}
