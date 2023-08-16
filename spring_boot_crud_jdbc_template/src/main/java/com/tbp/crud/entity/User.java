package com.tbp.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
            private int id;
            private  String first_name;
            private  String last_name;
            private int age;
            private  String email_ID;

}
