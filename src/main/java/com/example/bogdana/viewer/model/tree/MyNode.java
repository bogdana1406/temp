package com.example.bogdana.viewer.model.tree;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyNode {


    private int id;
    static int counter = 0;
    private String type;
    private String name;
    private String text = "";
    private String parentName;
    private MyNode parent = null;
    private List<MyNode> children = new ArrayList<>();
    private Map<String, String> attributes = new HashMap<>();

    public MyNode() {
        id = counter++;
    }

    public List<MyNode> getChildren() {
        return children;
    }

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setChildren(List<MyNode> children) {
        this.children = children;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MyNode getParent() {
        return this.parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public void addChild(MyNode node) {
        children.add(node);
        node.setParentName(this.getName());
//        node.setParent(this);
    }

    public void addAttributes(String attrName, String attrValue) {
        attributes.put(attrName, attrValue);
    }

    public boolean hasChildren() {
        if (children.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAttributes() {
        if (attributes.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public MyNode getChild(String childName) {
        MyNode searchChild = null;
        for (MyNode child: children) {
            if (childName.equals(child.getName())) {
                searchChild = child;
            }
        }
        return searchChild;
    }

    public MyNode findNodeInTreeFirst(MyNode node, String searchNodeName) {
        MyNode searchNode = null;
        if (searchNodeName.equals(node.getName())) {
            return node;
        }
        List<MyNode> children = node.getChildren();
        for (MyNode eachNode: children) {
            MyNode nodeInTreeFirst = findNodeInTreeFirst(eachNode, searchNodeName);
            if (nodeInTreeFirst != null) {
                searchNode = nodeInTreeFirst;
            }
        }
        return searchNode;
    }

    public MyNode findNodeById(MyNode node, Long nodeId) {
        MyNode searchNode = null;
        if (nodeId == node.getId()) {
            return node;
        }
        List<MyNode> children = node.getChildren();
        for (MyNode eachNode: children) {
            MyNode nodeInTree = findNodeById(eachNode, nodeId);
            if (nodeInTree != null) {
                searchNode = nodeInTree;
            }
        }
        return searchNode;
    }

    public List<String> getChildrenNames() {
        List<String> childrenNames = new ArrayList<>();
        for (MyNode childNode: children) {
            childrenNames.add(childNode.getName());
        }
        return childrenNames;
    }


}
