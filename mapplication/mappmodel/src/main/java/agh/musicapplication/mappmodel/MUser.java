/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.musicapplication.mappmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Agatka
 */
@Entity
@Table(name = "muser")
public class MUser extends MBasicEntity {
    
    @Column(unique = true)
    @NotNull
    @Size(min = 1)
    private String login;
    
    @Column(name = "pass")
    @NotNull
    @Size(min = 6)
    private String password;
    
    @Column
    private String name;
    
    @Column
    private String surname;
    
    @Column
    private String rank;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date age;
    
    @Column
    private String description;
    
    @OneToMany(mappedBy = "user")
    private List<MUserReview> mUserReviews;
    
    @OneToMany(mappedBy = "user")
    private List<MUserBand> mUserBands;

    public MUser() {
        mUserReviews = new ArrayList<>();
        mUserBands = new ArrayList<>();
    }

    public MUser(String login, String password, String name, String surname, String rank, Date age, String description) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.rank = rank;
        this.age = age;
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MUserReview> getmUserReviews() {
        return mUserReviews;
    }

    public void setmUserReviews(List<MUserReview> mUserReviews) {
        this.mUserReviews = mUserReviews;
    }
}
