package com.micro.sample.project.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.sample.project.service.QuesDO.QuesDOBuilder;
import com.micro.sample.project.service.QuesOption.QuesOptionBuilder;
import com.micro.sample.project.service.QuesPoiDto.QuesOptionPoiDto;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
    public void test() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // 获取子列表
        List<Integer> subList = numbers.subList(0, 1);

        // 输出子列表的内容
        for (Integer number : subList) {
            System.out.println(number);
        }
    }

    @Test
    public void testImportWord() {
        String filePath = "C:\\Users\\admin\\Desktop\\题库导入模板.docx";
        try (FileInputStream fis = new FileInputStream(filePath)){
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            List<QuesPoiDto> quesPoiDtos = new ArrayList<>();
            QuesPoiDto quesPoiDto = null;
            for (XWPFParagraph para : paragraphs) {
                String text = para.getText();
                if (Pattern.matches("^【(单选题|多选题|判断题)】(.*)", text)) {
                    quesPoiDto = new QuesPoiDto();
                    if (text.startsWith("【单选题】")) {
                        quesPoiDto.setType(Short.parseShort("0"));
                    } else if (text.startsWith("【多选题】")) {
                        quesPoiDto.setType(Short.parseShort("1"));
                    } else if (text.startsWith("【判断题】")) {
                        quesPoiDto.setType(Short.parseShort("2"));
                    }
                    quesPoiDto.setTitle(text.substring(5));
                } else if (Pattern.matches("^难度[：:]\\s*(.*)", text)) {
                    if (quesPoiDto == null) continue;
                    String diff = text.substring(3);
                    if (StringUtils.equals("初级", diff)) {
                        quesPoiDto.setDiff(Short.parseShort("0"));
                    } else if (StringUtils.equals("中级", diff)) {
                        quesPoiDto.setDiff(Short.parseShort("1"));
                    } else if (StringUtils.equals("高级", diff)) {
                        quesPoiDto.setDiff(Short.parseShort("2"));
                    }
                } else if (Pattern.matches("^[A-Z][.、].*$", text)) {
                    if (quesPoiDto == null) continue;
                    QuesOptionPoiDto quesOptionPoiDto = new QuesOptionPoiDto();
                    quesOptionPoiDto.setPrefix(text.substring(0, 2));
                    quesOptionPoiDto.setTitle(text.substring(2));
                    quesPoiDto.getOptions().add(quesOptionPoiDto);
                } else if (Pattern.matches("^答案[：:]\\s*(.*)", text)) {
                    if (quesPoiDto == null) continue;
                    String defaultIfBlank = StringUtils.defaultIfBlank(text.substring(3), "");
                    quesPoiDto.setAnswers(Arrays.stream(defaultIfBlank.split("")).collect(Collectors.toList()));
                } else if (Pattern.matches("^解析[：:]\\s*(.*)", text)) {
                    if (quesPoiDto == null) continue;
                    quesPoiDto.setResolve(text.substring(3));
                    quesPoiDtos.add(quesPoiDto);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("解析word结果为：{}", objectMapper.writeValueAsString(quesPoiDtos));
        } catch (IOException e) {
            log.error("");
        }
    }

}
