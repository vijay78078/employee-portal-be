package com.example.employeeportal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:4200")
public class GeminiController {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GeminiController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/rephrase")
    public ResponseEntity<Map<String, String>> rephraseFeedback(@RequestBody Map<String, String> request) {
        try {
            String userInput = request.get("text");
            if (userInput == null || userInput.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Text cannot be empty."));
            }

            String prompt = "Rephrase this feedback to make it more professional, clear, and concise ad Give only one option and don't include the words you, your, * . Just give me as one sentence:\n\n" + userInput;

            Map<String, Object> requestBody = Map.of(
                    "contents", new Object[] {
                            Map.of("parts", new Object[] {
                                    Map.of("text", prompt)
                            })
                    }
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON); // ✅ Only content type
            // ❌ No Authorization header for API key from AI Studio

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            // ✅ Use API key in the query string
            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=AIzaSyAT5JG8Qgr-5DVupZTbdYo2o-BnVndELZQ";

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                return ResponseEntity.status(response.getStatusCode())
                        .body(Map.of("error", "Failed to get response from Gemini API."));
            }

            JsonNode root = objectMapper.readTree(response.getBody());
            String rephrasedText = root
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

            return ResponseEntity.ok(Map.of("rephrasedText", rephrasedText));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Failed to rephrase feedback due to an internal error."));
        }
    }
}
