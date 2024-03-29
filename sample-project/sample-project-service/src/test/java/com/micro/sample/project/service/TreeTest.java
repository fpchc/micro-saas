package com.micro.sample.project.service;

import cn.hutool.json.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.micro.common.core.entity.NodeTree;
import java.util.List;
import org.junit.Test;

/**
 * @Author: pch
 * @Data: 2024/2/20 - 17:34
 * @Description:
 */
public class TreeTest {

    @Test
    public void testTree() throws JsonProcessingException {
        List<NodeTree> menuList = Lists.newArrayList(
                new NodeTree(1, null,"一级菜单"),
                new NodeTree(2, 1,"二级菜单1"),
                new NodeTree(3, 2,"二级菜单2"),
                new NodeTree(3, 2,"三级菜单1"),
                new NodeTree(4, 2,"三级菜单2")
        );

        List<NodeTree> nodeTrees = TreeUtil.generateDfsLrdTree(menuList);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(nodeTrees));
    }

}
