package oop;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrincessRepository {
    private Map<Integer, Princess> map = new TreeMap<>();

    public boolean add(Princess princess) {
        if (contains(princess.getNumber())) {
            return false;
        }
        map.put(princess.getNumber(), princess);
        return true;
    }

    public List<Princess> read() {
        return List.of(map.values().toArray(new Princess[0]));
    }

    public String update(Princess princess) {
        int number = princess.getNumber();
        if (map.replace(number, princess) != null) {
            return princess.getName();
        }
        return null;
    }

    public Princess get(int number) {
        if (contains(number)) {
            return map.get(number);
        }
        return null;
    }

    public String delete(int number) {
        Princess removedPrincess = map.remove(number);
        if (removedPrincess != null) {
            return removedPrincess.getName();
        }
        return null;
    }

    public boolean contains(int number) {
        return map.containsKey(number);
    }
}
