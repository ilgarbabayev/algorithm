package com.company.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortPlayers {
    public static void main(String[] args) {
        Player[] list = {new Player("Smith", 20), new Player("Jones", 15), new Player("Jones", 20)};
        Arrays.sort(list, new Checker());
        System.out.println(Arrays.toString(list));
    }
}

class Player{
    String name;
    int score;

    public Player(String name, Integer score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        int c = b.score - a.score;
        if (c==0) {
            return a.name.compareTo(b.name);
        }
        return c;
    }
}
