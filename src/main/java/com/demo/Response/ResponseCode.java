package com.demo.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class ResponseCode {
    public static final int SIGN_IN_SUCCESS = 2000;
    public static final int WRONG_PASSWORD = 2001;
    public static final int NO_ACCOUNT = 2002;
    public static final int REGISTER_SUCCESS = 2003;
    public static final int REGISTER_FAIL = 2004;
    public static final int UPDATE_SUCCESS = 2005;
    public static final int DELETE_SUCCESS = 2006;

    public static final int SIGN_IN_FAILED = 2007;
    public static final int SIGN_UP_FAILED = 2008;
    public static final int UPDATE_FAILED = 2009;
    public static final int DELETE_FAILED = 2010;

    public static final int SEARCH_SUCCESS = 3000;
    public static final int SEARCH_FAIL = 3001;

    public static final int ADD_FAVOURITE_SUCCESS = 4000;
    public static final int ADD_FAVOURITE_FAIL = 4001;
    public static final int UPDATE_FAVOURITE_SUCCESS = 4002;
    public static final int UPDATE_FAVOURITE_FAIL = 4003;
    public static final int DELETE_FAVOURITE_SUCCESS = 4004;
    public static final int DELETE_FAVOURITE_FAIL = 4005;
    public static final int ADD_NOTE_SUCCESS = 5000;
    public static final int ADD_NOTE_FAIL = 5001;
    public static final int DELETE_NOTE_SUCCESS = 5002;
    public static final int DELETE_NOTE_FAIL = 5003;
    public static final int UPDATE_NOTE_SUCCESS = 5004;
    public static final int UPDATE_NOTE_FAIL = 5005;

    public static final int ADD_LABEL_SUCCESS = 6000;

    public static final int ADD_CLASSIFICATION_SUCCESS = 7000;
    public static final int ADD_CLASSIFICATION_FAIL = 7001;

}
