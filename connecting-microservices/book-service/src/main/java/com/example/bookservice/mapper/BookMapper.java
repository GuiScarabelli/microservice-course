package com.example.bookservice.mapper;

import com.example.bookservice.entity.Book;
import java.util.List;

public class BookMapper {
  public static BookListing toDto(Book entity) {
    if (entity == null) {
      return null;
    }

    BookListing dto = new BookListing();
    dto.setPrice(entity.getPrice());
    dto.setLaunchDate(entity.getLaunchDate());
    dto.setAuthor(entity.getAuthor());
    dto.setTitle(entity.getTitle());
    return dto;
  }

  public static List<BookListing> toDto(List<Book> entities) {
    return entities.stream().map(BookMapper::toDto).toList();
  }
}
