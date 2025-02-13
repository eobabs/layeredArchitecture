package data.repositories;

import data.models.Item;

import java.util.ArrayList;

public class Items {
    private static int count;
    private ArrayList<Item> items = new ArrayList<>();

    public long count(){
        return items.size();
    }

    public Item save(Item item) {

        if(existsById(item.getId())){
            update(item);
        }
        else {
            generateId(item);
            items.add(item);
        }
        return item;
    }

    public Item[] saveAll(Item ... items) {
        for(Item item : items){
            save(item);
        }
        return items;
    }


    public boolean existsById(int id) {
        Item checker = findById(id);
        return checker != null;
    }


    public void delete(int id) {
        Item itemToDelete = findById(id);
        if(itemToDelete == null){
            throw new IllegalArgumentException("Item not found");
        }
        items.remove(itemToDelete);
    }

    public void deleteAll(Item ... items) {

        for(Item item : items){
            if(existsById(item.getId())){
                delete(item.getId());
            }
            else {
                throw new IllegalArgumentException("Item not found");
            }
        }
    }

    public void deleteAll(){
        items.clear();
    }

    public void deleteAllById(int ... ids) {
        for(int id : ids){
            if(existsById(id)){
                delete(id);
            }
            else {
                throw new IllegalArgumentException("Item not found");
            }
        }
    }

    private void update(Item item) {
        Item original = findById(item.getId());
        original = item;
    }

    private void generateId(Item item) {
        count++;
        item.setId(count);
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> findAllById(int ... ids) {
        ArrayList<Item> foundItem = new ArrayList<>();
        for (int id : ids) {
            foundItem.add(findById(id));
        }
        return foundItem;

    }

}


