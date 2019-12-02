package com.example.bogdana.viewer.controllers;

import com.example.bogdana.viewer.config.MyConnection;
import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.model.tree.MyTree;
import com.example.bogdana.viewer.repository.DbRepository;
import com.example.bogdana.viewer.service.NodeService;
import com.example.bogdana.viewer.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.Tree;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/db")
@CrossOrigin
public class DbController {

//    @Autowired
//    DbRepository dbRepository;

//    @Autowired
//    MyConnection myConnection;

    @Autowired
    TreeService treeService;

    @Autowired
    NodeService nodeService;

    @Autowired
    MyNode startNode;

    @Autowired
    MyTree tree;

    @GetMapping(path = "/ex")
    public String check() {
        return "welcome";
    }

//    @GetMapping(path = "/tree")
//    public List<String> getTree() throws SQLException {
//        startNode.setName("TableNodes");
//        startNode.setType("tables");
//        String dbName = "sakila";
//        String tableName = "";
//        Connection conn = myConnection.getConnection();
//        DatabaseMetaData meta = conn.getMetaData();
//        MyNode myNode = treeService.parseNode(meta, startNode, dbName, tableName);
////        List<String> childrenNameArray = new ArrayList<>();
////        for (MyNode childNode: myNode.getChildren()) {
////            childrenNameArray.add(childNode.getName());
////        }
//        return myNode.getChildrenNames();
//    }

    @GetMapping(path = "/node")
    public MyNode getInitialNode() {
        startNode.setName("SCHEMA");
        startNode.setType("schema");
        return startNode;
    }

//    @GetMapping(path = "")
//    public MyTree getTree() {
//        tree.setRoot(startNode);
//        return tree;
//    }

    @PostMapping("")
    public ResponseEntity<?> createNewNode(@RequestBody MyNode node) throws SQLException {
        System.out.println(node.getName() + "   " + node.getType());



//        Connection conn = myConnection.getConnection();
//        DatabaseMetaData meta = conn.getMetaData();

//        String dbName = "";
//        String tableName = "";
//        MyNode myNode = treeService.parseNode(meta, node, dbName, tableName);

        MyNode myNode1 = nodeService.parseNodeChildren(node);

//        startNode = myNode1;
//        startNode.addChild(myNode1);
//        System.out.println(startNode.getChildrenNames());
        List<MyNode> children = myNode1.getChildren();
        startNode.setChildren(children);
        for (MyNode child: children) {
            System.out.println(child.getName() + " " + child.getId());
        }

//        return new ResponseEntity<MyNode>(myNode, HttpStatus.CREATED);
        return new ResponseEntity<MyNode>(startNode, HttpStatus.CREATED);
//        return new ResponseEntity<String>(node.getName(), HttpStatus.OK);
    }
}
