package data.repositories;

import data.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ItemsTest {
    Items items;
    Item item;
    Item itemTwo;


    @BeforeEach
    public void setUp() {
        items = new Items();
        item = new Item("Laptop","Work-Tool",2000);
        itemTwo = new Item("Food","Survival-Tool",500);

    }
    @Test
    void testThatNewItemsIsEmpty() {
        assertEquals(0, items.count());
    }

    @Test
    void testThatNewItemsCanSaveOneItem() {
        items.save(item);
        assertEquals(1, items.count());
    }

    @Test
    public void testThatNullItemsCannotBeSaved() {

        assertThrows(NullPointerException.class, () -> items.save(null));

    }

    @Test
    public void testThat_ItemsCanSaveMultipleItems(){
        items.saveAll(item, itemTwo);
        assertEquals(2, items.count());

    }

    @Test
    public void testThatNewItemsCanFindItemById() {

        items.save(item);
        Item foundItem = items.findById(item.getId());
        assertEquals(item, foundItem);
    }

    @Test
    public void testThatNewItemsCanDeleteAnyItem() {

        items.save(item);
        assertEquals(1, items.count());
        items.delete(item.getId());
        assertEquals(0, items.count());
    }

    @Test
    public void testThatNewItemsCanDeleteAllItems() {

        items.save(item);
        items.save(itemTwo);
        assertEquals(2, items.count());
        items.deleteAll();
        assertEquals(0, items.count());
    }

    @Test
    public void testThatNewItemsCanUpdateItem() {

        item.setName("Screen");
        items.save(item);
        assertEquals(1, items.count());
    }

    @Test
    public void testThatNewItemsCanDeleteMultipleItems() {

        items.save(item);
        items.save(itemTwo);
        assertEquals(2, items.count());
        items.deleteAll(item,itemTwo);
        assertEquals(0, items.count());
    }

    @Test
    public void testThatNewItemsCanDeleteMultipleItemsById() {

        items.save(item);
        items.save(itemTwo);
        assertEquals(2, items.count());
        items.deleteAllById(item.getId(),itemTwo.getId());
        assertEquals(0, items.count());
    }

    @Test
    public void testThatDeleteThrowsExceptionWithInvalidId() {

        items.save(item);
        assertThrows(IllegalArgumentException.class, () -> items.delete(-1));
    }

    @Test
    public void testThatNewItemsCanFindItemAllItemById() {

        items.save(item);
        items.save(itemTwo);
        ArrayList<Item> foundItems = items.findAllById(item.getId(),itemTwo.getId());
        assertEquals(2, foundItems.size());
    }


}