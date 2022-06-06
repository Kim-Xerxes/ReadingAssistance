package com.demo.Entity.Key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteKey implements Serializable {
    private Integer uid;
    private String ISBN;
}
