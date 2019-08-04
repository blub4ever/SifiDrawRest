package eu.glatz.sifidraw

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController {
    private val counter = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(),
                String.format(template, name))
    }

    companion object {

        private val template = "Hello, %s!"
    }
}
