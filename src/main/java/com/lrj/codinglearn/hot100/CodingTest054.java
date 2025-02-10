package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第54题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest054 {
    /**
     * 208.实现Trie(前缀树)
     * @author: luorenjie
     * @date: 2025/2/8 16:45
     */
    public class Trie {

        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                //判断字符是否创建
                if (curNode.children[index] == null){
                    curNode.children[index] = new TrieNode();
                    //中间的字符不是完整的单词
                    curNode.children[index].isWord = false;
                }

                curNode = curNode.children[index];
            }
            //最后一个字符才是完整的单词
            curNode.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curNode = find(word);
            return curNode != null && curNode.isWord;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        private TrieNode find(String word){
            TrieNode curNode = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int index = word.charAt(i) - 'a';
                curNode = curNode.children[index];
                if (curNode == null){
                    return null;
                }
            }
            return curNode;
        }
    }

    //构建TrieNode类
    class TrieNode{
        //是否是单词
        boolean isWord;
        //26个小写字母
        TrieNode[] children;
        public TrieNode(){
            isWord =true;
            children = new TrieNode[26];
        }
    }


    public static void main(String[] args) {
        CodingTest054 test = new CodingTest054();
        Trie trie = test.new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.startsWith("app"));
    }

}
