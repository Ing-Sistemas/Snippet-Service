package app.controller

import app.model.Snippet
import app.service.SnippetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class SnippetController(private val snippetService: SnippetService) {

    @GetMapping("/ping")
    fun pingPermissionService(): Mono<String> {
        println("entering pingPermissionService")
        return snippetService.pingPermissionService()
    }

    @PostMapping("/add/snippet")
    fun addSnippet(@RequestParam snippet: Snippet): Mono<Snippet> {
        return snippetService.addSnippet(snippet)
    }
}