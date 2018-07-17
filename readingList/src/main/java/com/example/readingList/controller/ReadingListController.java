package com.example.readingList.controller;

import com.example.readingList.domain.Book;
import com.example.readingList.inter.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @GetMapping("/{reader}")
    public String readersBook(@PathVariable("reader") String reader,Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);

        if (readingList != null) {
            model.addAttribute("books",readingList);
        }

        return "readingList";
    }

    public String addToReadingList(@PathVariable("books")String reader,Book book){

        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

} 