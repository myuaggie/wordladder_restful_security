package com.example.wordladder_hwk2_1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordladderController {

    @RequestMapping("/wordladder")
    public String wordladder(@RequestParam(value="word1")String word1,
                             @RequestParam(value="word2")String word2,
                             @RequestParam(value="dict")String dict){
        App w=new App(dict,word1,word2);
        return w.getRes();
    }
}