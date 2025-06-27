package com.huynqb.productmanagement.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false, columnDefinition = "nvarchar(100)")
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer role; // 1 admin, 2 staff, 3 member

    // trang thai hoat dong: true = kich hoat, false = khoa
    @Column(nullable = false)
    private Boolean active = true;

    public boolean isAdmin() {
        return role != null && role.equals(1);
    }

    public boolean isStaff() {
        return role != null && role.equals(2);
    }

    public boolean isMember() {
        return role != null && role.equals(3);
    }

    public String getRoleName() {
        if (isAdmin()) {
            return "Admin";
        } else if (isStaff()) {
            return "Staff";
        } else if (isMember()) {
            return "Member";
        }
        return "Unknown";
    }

    public boolean canEdit() {
        return isAdmin() || isStaff();
    }

    public boolean canDelete() {
        return isAdmin();
    }

    public Account() {

    }

    public Account(String username, String name, String password, Integer role, Boolean active) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
