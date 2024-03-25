package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class DinerIterator implements Iterator<MenuItem> {
    private MenuItem[] items;
    private int position = 0;

    public DinerIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}
