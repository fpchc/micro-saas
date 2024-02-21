package com.micro.common.core.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Data: 2024/2/20 - 17:26
 * @Description:
 */
@Getter
public class NodeTree implements ITree<NodeTree> {

    private Integer id;

    private Integer parentId;

    private String name;

    @Setter
    private NodeTree parent;

    public NodeTree getParent() {
        return parentId == null ? null : new NodeTree(parentId);
    }

    @Setter
    private List<NodeTree> children = new ArrayList<>();

    public NodeTree(Integer id) {
        this.id = id;
    }

    public NodeTree(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NodeTree && id.equals(((NodeTree) obj).id);
    }
//    private Integer depth;
//
//    private Boolean isRoot;
//
//    private Boolean isLeaf;
//
//    private Boolean hasChildren;
//
//    private String path;
}
