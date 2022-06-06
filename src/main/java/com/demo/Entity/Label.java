package com.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private Integer uid;
    private String content;

    public void setTid(Integer tid) {this.tid = tid;}
    public Integer getTid() {return tid;}
    public void setUid(Integer uid) {this.uid = uid;}
    public Integer getUid() {return uid;}
    public void setContent(String content) {this.content = content;}
    public String getContent() {return content;}
}
