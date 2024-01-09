package com.example.communitydemo.domain.board.entity;

import com.example.communitydemo.domain.GlobalTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String value;
    private int sort_order;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private boolean is_deleted;

    @OneToMany(mappedBy = "category")
    private List<Article> articles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return sort_order == category.sort_order && is_deleted == category.is_deleted && Objects.equals(id, category.id) && Objects.equals(label, category.label) && Objects.equals(value, category.value) && Objects.equals(created_at, category.created_at) && Objects.equals(updated_at, category.updated_at) && Objects.equals(articles, category.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, value, sort_order, created_at, updated_at, is_deleted, articles);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", sort_order=" + sort_order +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
