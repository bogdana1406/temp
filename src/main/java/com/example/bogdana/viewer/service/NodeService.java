package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class NodeService {

    @Autowired
    NodeLoaderChooser2 nodeLoaderChooser2;

    // принимаем входящий узел с фронта
    public MyNode parseNodeChildren(MyNode node) throws SQLException {

        // создаем объект chooseNodeLoader2,
        // вызываем у него метод choose
        System.out.println("Node service get node " + node.getType());
       NodeRepository chooseNodeLoader2 = nodeLoaderChooser2.choose(node);
        MyNode myNode = chooseNodeLoader2.parsChildrenToNode(node);
        return myNode;

    }
}
