package com.example.readingList.inter;

import com.example.readingList.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository  extends JpaRepository<Book,Long>{

    List<Book> findByReader(String reader);

} 