package com.expeditors.quotes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/quotes")
public class QuotesController {

    private QuotesService quotes;

    @Autowired
    public QuotesController(QuotesService quotes) {
        this.quotes = quotes;
    }

    @GetMapping
    public List<String> getQuotes() {
        return quotes.getAllQuotes() ;
    }

    @GetMapping("/{indexId}")
    public String getQuoteByIndex(@PathVariable int indexId) {
        String quote = quotes.getQuoteByIndex(indexId);
        return quote;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addQuote(@RequestBody String quote) {
        quotes.addQuote(quote);
    }

    @PatchMapping("/{indexId}")
    public String updateQuote(@PathVariable int indexId,
                              @RequestBody String newQuote){

        String quote = quotes.getQuoteByIndex(indexId);
        return quotes.updateQuoteAt(indexId, newQuote);
    }

    @DeleteMapping("/{indexId}")
    public String deleteQuote(@PathVariable int indexId){
        return quotes.deleteQuote(indexId);
    }
}
