package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String path_img;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String password, String phone, String path_img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.path_img = path_img;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getPath_img() {
        return path_img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.path_img, entity.path_img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, phone, path_img);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "phone = " + phone + ", " +
                "path_img = " + path_img + ")";
    }
}
