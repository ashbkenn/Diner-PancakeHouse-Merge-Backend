package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems() {
        List<MenuItemRecord> vegetarianItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.description().toLowerCase().contains("vegetarian") || item.name().toLowerCase().contains("vegetarian"))
                .collect(Collectors.toList());
        return vegetarianItems;
    }


    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        List<MenuItemRecord> breakfastItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.description().toLowerCase().contains("breakfast"))
                .collect(Collectors.toList());
        return breakfastItems;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems() {
        List<MenuItemRecord> lunchItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.description().toLowerCase().contains("lunch"))
                .collect(Collectors.toList());
        return lunchItems;
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperItems() {
        List<MenuItemRecord> supperItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.description().toLowerCase().contains("supper") || item.description().toLowerCase().contains("dinner"))
                .collect(Collectors.toList());
        return supperItems;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<String> signUp(@RequestParam String username,
//                                         @RequestParam String password,
//                                         @RequestParam String email) {
//        String customerInfo = String.format("Username: %s, Password: %s, Email: %s", username, password, email);
//        try {
//            FileWriter writer = new FileWriter("data/customers.txt", true);
//            writer.write(customerInfo + "\n");
//            writer.close();
//            return ResponseEntity.ok("Signed up successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while signing up.");
//        }
//    }

}
