package com.example.bogdana.viewer.repository;

import com.example.bogdana.viewer.model.tree.MyNode;

import java.sql.SQLException;


public interface NodeRepository {
    MyNode parsChildrenToNode(MyNode parentNode) throws SQLException;
}
