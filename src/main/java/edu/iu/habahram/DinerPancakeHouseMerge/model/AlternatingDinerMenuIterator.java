package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        Calendar date = Calendar.getInstance();
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        // Adjust day of the week to start from 0 (Sunday) to 6 (Saturday)
        dayOfWeek = (dayOfWeek + 5) % 7;
        // Calculate the starting position based on the day of the week
        position = dayOfWeek % 2 == 0 ? 0 : 1;
    }

    public MenuItem next() {
        MenuItem menuItem = items[position];
        // Move to the next alternate item
        position += 2;
        return menuItem;
    }

    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }
}
