package dev.tutorial.kmmargherita

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}