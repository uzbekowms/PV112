package com.example.cacheexample.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pageable")
@RequiredArgsConstructor
public class PageableExampleController {


    @GetMapping
    public Pageable pageable(@PageableDefault(size = 20) Pageable pageable) {
        return pageable;
    }
}
