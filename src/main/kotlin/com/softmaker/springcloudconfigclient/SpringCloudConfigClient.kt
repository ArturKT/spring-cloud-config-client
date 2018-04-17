package com.softmaker.springcloudconfigclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class SpringCloudConfigClient


fun main(args: Array<String>) {
    runApplication<SpringCloudConfigClient>(*args)
}

@RefreshScope
@RestController
class GiveMeRefreshedProperty(@Value("\${refresh.me}") private val testProperty: String,
                              @Value("\${refresh.another}") private val anotherTestProperty: String) {

    @GetMapping("/testProperty")
    fun getTestProperty() = testProperty


    @GetMapping("/anotherTestProperty")
    fun getAnotherTestProperty() = anotherTestProperty
}