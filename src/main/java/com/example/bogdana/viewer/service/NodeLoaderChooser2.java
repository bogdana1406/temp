package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.repository.NodeRepository;
import com.example.bogdana.viewer.repository.TreeRepository;

public class NodeLoaderChooser2 {

    public NodeLoaderChooser2() {
    }
//
    public NodeRepository choose(MyNode node) {
        NodeRepository nodeRepository = null;
        String typeNode = node.getType();
        System.out.println("Type node is    " + typeNode);
        switch (typeNode) {
            case ("schema"):
                nodeRepository = new LoadDatabasesToTree();
                break;

            case ("database"):
                nodeRepository = new LoadNodesToDatabase();
                break;
//
//            case ("tables"):
//                nodeRepository = new TreeServiceLoadTables();
//                break;
//
//            default:
//                nodeRepository = new TreeServiceLoaderDefault();
//                break;
        }
        return nodeRepository;
    }
}
