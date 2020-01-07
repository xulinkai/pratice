package com.xulk.mashibing.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-09-05 23:42
 **/
abstract class Node {
    public abstract void p();
}

//叶子节点，没有子节点
class LeafNode extends Node {

    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public void p() {
        System.out.println(name);
    }
}

class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c22 = new LeafNode("c22");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.addNode(chapter1);
        root.addNode(chapter2);
        chapter1.addNode(c11);
        chapter1.addNode(c22);
        chapter2.addNode(b21);
        b21.addNode(c211);
        b21.addNode(c212);
        tree(root, 0);
    }

    static void tree(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.p();
        if (node instanceof BranchNode) {
            for (Node node1 : ((BranchNode) node).nodes) {
                tree(node1, depth + 1);
            }
        }
    }
}
