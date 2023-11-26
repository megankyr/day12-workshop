package com.ssf.day12workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NumberController {

    @GetMapping("/")
    public String showForm() {
        return "numberForm";
    }

    @GetMapping("/numbergenerator")
    public String generateNumbers(@RequestParam int quantity, Model model) {
        List<Integer> numbers = generateRandomNumbers(quantity);
        List<String> imageUrls = getImageUrls(numbers);

        model.addAttribute("numbers", numbers);
        model.addAttribute("imageUrls", imageUrls);

        return "numberResult";
    }

    private List<Integer> generateRandomNumbers(int quantity) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantity; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(31);
            } while (numbers.contains(randomNumber));

            numbers.add(randomNumber);
        }

        return numbers;
    }

    private List<String> getImageUrls(List<Integer> numbers) {
        List<String> imageUrls = new ArrayList<>();
        for (Integer number : numbers) {
            String imageUrl = String.format("/images/number%d.jpg", number);
            imageUrls.add(imageUrl);
        }
        return imageUrls;
    }
}