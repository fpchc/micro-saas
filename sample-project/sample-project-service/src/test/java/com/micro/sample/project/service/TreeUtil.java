package com.micro.sample.project.service;

import com.micro.common.core.entity.ITree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
        List<T> roots = list.stream().filter(t -> t.getParent() == null).toList();
        Queue<T> queue = new LinkedList<>(roots);
        while (!queue.isEmpty()) {
            T poll = queue.poll();
            List<T> children = list.stream().filter(t -> poll.equals(t.getParent()))
                    .toList();
            poll.setChildren(children);
            children.forEach(queue::offer);
        }
        return roots;
    }

}
