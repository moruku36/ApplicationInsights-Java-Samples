// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    //脆弱性検知のテストのため適当なクレデンシャル情報を記入
    String secretKey = "mySecretKey12345fadfasdfad";
    String password = "myPassword12345dfadfweadds";

    @GetMapping("/")
    public String root() {
        return "OK";
    }
}
