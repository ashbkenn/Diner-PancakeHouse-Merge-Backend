package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class DinerRepository {

    public Menu getTheMenu() {
        return new DinerMenu();
    }
}
