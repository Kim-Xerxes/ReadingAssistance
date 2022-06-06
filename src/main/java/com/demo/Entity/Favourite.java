package com.demo.Entity;

import com.demo.Entity.Key.FavouriteKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(value = FavouriteKey.class)
public class Favourite {
    @Id
    private Integer uid;
    @Id
    private String ISBN;

    private Integer tid;
    private String time;
    private String progress;

    public Integer getUid() {return uid;}
    public void setUid(Integer uid) {this.uid = uid;}
    public String getISBN() {return ISBN;}
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}
    public Integer getTid() {return tid;}
    public void setTid(Integer tid) {this.tid = tid;}
    public String getProgress() {return progress;}
    public void setProgress(String progress) {this.progress = progress;}
}
