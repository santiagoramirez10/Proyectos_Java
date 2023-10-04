package com.sura.signalmaking.controllers;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final ChatgptService chatgptService;

    @GetMapping("/send")
    public String send(@RequestParam String message){
        String responseMessage = chatgptService.sendMessage(message);
        return responseMessage;
    }
}
