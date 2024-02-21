package com.micro.common.core.entity;

import java.util.List;

/**
 * @Author: pch
 * @Data: 2024/2/20 - 17:17
 * @Description:
 */
public interface ITree<T> {

    /**
     * 父节点
     */
    T getParent();

    void setParent(T parent);

    /**
     * 子节点集合
     */
    List<T> getChildren();

    void setChildren(List<T> children);

//    /**
//     * 节点深度，根的深度为0
//     */
//    Integer getDepth();
//
//    /**
//     * 是否是根节点
//     */
//    Boolean getIsRoot();
//
//    /**
//     * 是否是叶节点
//     */
//    Boolean getIsLeaf();
//
//    /**
//     * 是否有子节点
//     */
//    Boolean getHasChildren();
//
//    /**
//     * 节点路径（UNIX路径格式，以“/”分隔）
//     */
//    String getPath();

}
