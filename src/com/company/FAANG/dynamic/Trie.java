package com.company.FAANG.dynamic;

import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if(children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if(i == word.length() - 1) {
                node.setLeaf(true);
            }
        }
    }

    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }

        if(node != null && node.isLeaf()) {
            return true;
        } else {
            return false;
        }
    }
}

class TrieNode {
    private char c;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
