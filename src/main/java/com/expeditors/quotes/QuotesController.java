package com.expeditors.quotes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/quotes")
public class QuotesController {

    private QuotesService quotes;

    public QuotesController(QuotesService quotes) {
        this.quotes = quotes;
    }

    @GetMapping
    public List<String> getQuotes() {
        return quotes.getAllQuotes() ;
    }

    /**
     * This is an Approach that can be used to return
     * the quote stored for ID = indexId
     * In case QuoteIndexOutOfBoundsException is thrown it will
     * be caught using the ResponseStatusException
     */
    @GetMapping("/v1/{indexId}")
    public String getQuoteByIndex1(@PathVariable int indexId) {

        try {
            return quotes.getQuoteByIndex(indexId);

        } catch (QuoteIndexOutOfBoundsException qex) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "ResponseStatusException");
        }
    }

    /**
     * This is another Approach that can be used to return
     * the quote stored for ID = indexId
     * In case QuoteIndexOutOfBoundsException is thrown it will
     * be caught using the Handler
     */
    @GetMapping("/v2/{indexId}")
    public String getQuoteByIndex(@PathVariable int indexId) {

        return  quotes.getQuoteByIndex(indexId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addQuote(@RequestBody String quote) {
        quotes.addQuote(quote);
    }

    @PatchMapping("/{indexId}")
    public String updateQuote(@PathVariable int indexId,
                              @RequestBody String newQuote) {

        return quotes.updateQuoteAt(indexId, newQuote);
    }

    @DeleteMapping("/{indexId}")
    public String deleteQuote(@PathVariable int indexId){
        return quotes.deleteQuote(indexId);
    }

}
