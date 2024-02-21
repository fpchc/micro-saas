package com.micro.sample.project.service;

import com.micro.common.core.entity.ITree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: pch
 * @Data: 2024/2/20 - 17:33
 * @Description:
 */
public class TreeUtil {

    public static<T extends ITree<T>> List<T> generateDfsDlrTree(List<T> list) {

        List<T> roots = list.stream().filter(t -> t.getParent() == null).toList();
        Stack<T> stack = roots.stream().collect(Collectors.toCollection(Stack::new));

        while (!stack.isEmpty()) {
            T pop = stack.pop();

            List<T> children = list.stream()
                    .filter(t -> t.getParent() != null)
                    .filter(t -> pop.equals(t.getParent()))
                    .toList();
            pop.setChildren(children);
            children.forEach(stack::push);
        }
        return roots;
    }

    public static <T extends ITree<T>> List<T> generateDfsLrdTree(List<T> list) {
        Map<T, List<T>> relations = new HashMap<>();
        for (T node : list) {
            List<T> ts = relations.computeIfAbsent(node.getParent(), (T) -> new LinkedList<>());
            ts.add(node);
        }

        return null;
    }

}
