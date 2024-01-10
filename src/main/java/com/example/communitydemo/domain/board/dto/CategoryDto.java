package com.example.communitydemo.domain.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CategoryDto {

    @Getter
    @Setter
  public static class CategoryBaseResponse {
      private Long id;
      private String label;
      private String value;
      private int sort_order;
      private LocalDateTime created_at;
      private LocalDateTime updated_at;

      public CategoryBaseResponse(Long id, String label, String value, int sort_order, LocalDateTime created_at, LocalDateTime updated_at) {
          this.id = id;
          this.label = label;
          this.value = value;
          this.sort_order = sort_order;
          this.created_at = created_at;
          this.updated_at = updated_at;
      }


  }
}
