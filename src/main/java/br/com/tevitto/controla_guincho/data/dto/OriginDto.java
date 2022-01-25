package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class OriginDto implements Serializable {
    private Long id;
    private String description;

    public OriginDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginDto entity = (OriginDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ")";
    }
}
