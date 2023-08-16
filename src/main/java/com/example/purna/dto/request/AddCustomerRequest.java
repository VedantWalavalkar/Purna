package com.example.purna.dto.request;

import com.example.purna.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddCustomerRequest {

    String name;

    String emailId;

    int age;

    String address;

    Gender gender;
}
