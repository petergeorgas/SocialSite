package com.goons.socialsite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteController {
    @GetMapping("/")
    public String index(){
        return "Hello, world! I am the default endpoint.";
    }
}
