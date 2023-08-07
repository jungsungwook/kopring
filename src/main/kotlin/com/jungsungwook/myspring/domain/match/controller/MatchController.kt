package com.jungsungwook.myspring.domain.match.controller
import com.jungsungwook.myspring.domain.match.service.MatchService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class MatchController(
    private val matchService: MatchService
) {

    @GetMapping("/match")
    fun match(): String {
//        val matchList = matchRepository.findAll()
//        model.addAttribute("matchList", matchList)
        return "match"
    }
}