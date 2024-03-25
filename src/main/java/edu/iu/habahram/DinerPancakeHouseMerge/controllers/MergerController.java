package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> mergeMenus() {
        List<MenuItem> mergedMenu = new ArrayList<>();

        // Get Diner menu items
        MenuItem[] dinerMenuItems = dinerRepository.getTheMenu();

        // Get Pancake House menu items using iterator
        PancakeHouseMenu pancakeHouseMenu = pancakeHouseRepository.getTheMenu();
        Iterator<MenuItem> pancakeHouseIterator = pancakeHouseMenu.iterator();

        // Add Diner menu items to the merged menu
        Collections.addAll(mergedMenu, dinerMenuItems);

        // Add Pancake House menu items to the merged menu
        while (pancakeHouseIterator.hasNext()) {
            mergedMenu.add(pancakeHouseIterator.next());
        }

        // Sort the merged menu by name
        Collections.sort(mergedMenu, (item1, item2) -> item1.getName().compareToIgnoreCase(item2.getName()));

        return mergedMenu;
    }
}
