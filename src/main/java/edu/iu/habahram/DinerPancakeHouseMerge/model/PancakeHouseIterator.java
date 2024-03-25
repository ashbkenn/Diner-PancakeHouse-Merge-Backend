package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseIterator implements Iterator<MenuItem> {
    private List<MenuItem> menuItems;
    private int position = 0;

    public PancakeHouseIterator(List<MenuItem> items) {
        this.menuItems = items;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(position);
        position++;
        return menuItem;
    }
}
