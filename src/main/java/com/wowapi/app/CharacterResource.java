package com.wowapi.app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
//@RequestMapping("/api")
public class CharacterResource {

    ConcurrentMap<String, Toon> toons = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Toon getToon(@PathVariable String id){
        return toons.get(id);
    }

    @GetMapping("/")
    public List<Toon> getAllToons(){
        return new ArrayList<Toon>(toons.values());
    }

    @PostMapping("/")
    public Toon addToon(@RequestBody Toon toon){
        toons.put(toon.getId(), toon);
        return toon;
    }
}
