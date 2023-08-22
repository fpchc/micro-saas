package com.micro.sample.project.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.sample.project.service.QuesDO.QuesDOBuilder;
import com.micro.sample.project.service.QuesOption.QuesOptionBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.assertj.core.util.Lists;
import org.junit.Test;

@Slf4j
public class PoiTest {

    @Test
    public void testImportWord() {

        List<String> characters = Lists.newArrayList("A.", "B.", "C.", "D.", "E.", "F.", "G.", "H.", "J.");
        String filePath = "C:\\Users\\admin\\Desktop\\题库导入模板.docx";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            List<QuesDO> quesDOS = new ArrayList<>();
            QuesDO quesDO = null;
            for (XWPFParagraph para : paragraphs) {
                String text = para.getText();
                if (text.startsWith("【单选题】") || text.startsWith("【多选题】") || text.startsWith("【判断题】")) {
                    quesDO = new QuesDO();
                    quesDO.setId(IdUtil.getSnowflake().nextId());
                    if (StringUtils.equals(text.substring(1, 4), "单选题")) {
                        quesDO.setType(Short.parseShort("0"));
                    }
                    if (StringUtils.equals(text.substring(1, 4), "多选题")) {
                        quesDO.setType(Short.parseShort("1"));
                    }
                    if (StringUtils.equals(text.substring(1, 4), "判断题")) {
                        quesDO.setType(Short.parseShort("2"));
                    }
                    quesDO.setTitle(text.substring(5));
                    log.info(text.substring(5));
                }

                if (text.startsWith("难度：")) {
                    quesDO.setDiff(text.substring(3));
                    log.info(text.substring(3));
                }
                if (text.startsWith("解析：")) {
                    quesDO.setResolve(text.substring(3));
                    log.info(text.substring(3));
                    quesDOS.add(quesDO);
                }
                if (text.startsWith("A.") || text.startsWith("B.") || text.startsWith("C.") || text.startsWith("D.")) {
                    QuesOption quesOption = new QuesOption();
                    quesOption.setId(IdUtil.getSnowflake().nextId());
                    quesOption.setTitle(text.substring(2));
                    quesDO.getQuesOptions().add(quesOption);
                    log.info(text.substring(2));
                }
                if (text.startsWith("答案：")) {
                    log.info(text.substring(3));
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("返回结果集：{}", objectMapper.writeValueAsString(quesDOS));
            fis.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
