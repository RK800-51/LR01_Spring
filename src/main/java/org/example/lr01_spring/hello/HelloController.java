package org.example.lr01_spring.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {
    private List<String> array = new ArrayList<>();
    private HashMap<Integer, String> map = new HashMap<>();
    private Integer counter = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("update-array")
    public void updateArray(String s) {
        array.add(s);
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return array;
    }
    @GetMapping("/update-map")
    public void updateHashMap(String s) {
        map.put(counter, s);
        counter++;
    }
    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {
        return map;
    }
    @GetMapping("/show-all-length")
    public String showAllLength() {
        return "All length: " + "Array " + array.size() + " Map " + map.size();
    }
}
