package Dijkstra;

import java.util.LinkedList;

public class CityHashTable {
    private LinkedList<Entry>[] table;
    private int mod;

    public CityHashTable(int mod) {
        this.mod = mod;
        this.table = new LinkedList[mod];
        for (int i = 0; i < mod; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 + name.charAt(i)) % mod;
        }
        return hash;
    }

    public City findCity(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.city;
            }
        }
        return null;
    }

    public void updateCity(String key, City value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.city = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    static class Entry {
        String key;
        City city;

        Entry(String key, City city) {
            this.key = key;
            this.city = city;
        }
    }
}