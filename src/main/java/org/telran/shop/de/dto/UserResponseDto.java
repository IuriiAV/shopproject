package org.telran.shop.de.dto;

public class UserResponseDto {

    private Long id;

    private String login;

    private String email;

    public UserResponseDto(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
