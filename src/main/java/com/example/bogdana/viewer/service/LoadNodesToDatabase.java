package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.config.MyConnection;
import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class LoadNodesToDatabase implements NodeRepository {

    @Override
    public MyNode parsChildrenToNode(MyNode parentNode) throws SQLException {
        MyNode tableNode = new MyNode();
        tableNode.setName("TableNodes");
        tableNode.setType("tables");
        // узел Views
        MyNode viewNode = new MyNode();
        viewNode.setName("ViewsNodes");
        viewNode.setType("views");
        // узел Stored_Procedures
        MyNode procedureNode = new MyNode();
        procedureNode.setName("Stored_Procedures_Nodes");
        procedureNode.setType("storedProcedures");
        // узел Functions
        MyNode functionNode = new MyNode();
        functionNode.setName("FunctionsNodes");
        functionNode.setType("functions");
        parentNode.addChild(tableNode);
        parentNode.addChild(viewNode);
        parentNode.addChild(procedureNode);
        parentNode.addChild(functionNode);

        return parentNode;
    }
}
