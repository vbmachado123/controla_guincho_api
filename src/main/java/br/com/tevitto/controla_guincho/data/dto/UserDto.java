package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    private Long id;
    //    private String name;
//    private String email;
//    private String password;
    private String phone;
    private String path_img;
    private UserSystemDto userSystemDto;


    public UserSystemDto getUserSystemDto() {
        return userSystemDto;
    }

    public void setUserSystemDto(UserSystemDto userSystemDto) {
        this.userSystemDto = userSystemDto;
    }

    public UserDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    public Long getId() {
        return id;
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
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) && Objects.equals(getPhone(), userDto.getPhone()) && Objects.equals(getPath_img(), userDto.getPath_img()) && Objects.equals(getUserSystemDto(), userDto.getUserSystemDto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhone(), getPath_img(), getUserSystemDto());
    }
}
