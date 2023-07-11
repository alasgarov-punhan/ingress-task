package com.alasgarov.ms.user.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-posts", url = "http://localhost:8080")
public interface PostClient {
}
