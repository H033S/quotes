package com.expeditors.quotes;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuotesService {
    private List<String> quotes = new ArrayList<>(
            Arrays.asList(
                    "The only way to do great work is to love what you do. - Steve Jobs\n",
                    "Believe you can and you're halfway there. - Theodore Roosevelt\n",
                    "I have not failed. I've just found 10,000 ways that won't work. - Thomas Edison\n"));

    public List<String> getAllQuotes() {
        return quotes;
    }

    public String getQuoteByIndex(int index) {
        if (index >= 0 && index < quotes.size()) {
            return quotes.get(index);
        } else {
            return "";
        }
    }

    public String addQuote(String quote) {
        String decodedQuote = URLDecoder.decode(quote, StandardCharsets.UTF_8);
        quotes.add(decodedQuote);
        return decodedQuote;
    }

    public String updateQuoteAt(int index, String newQuote){
        String decodedQuote = URLDecoder.decode(newQuote, StandardCharsets.UTF_8);
        quotes.set(index, decodedQuote);
        return decodedQuote;
    }

    public String deleteQuote(int index){
        return quotes.size() >= index ? "" : quotes.remove(index);
    }

}
