package lk.ijse.stumanagement.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    private String id;
    private String name;
    private String email;
    private String city;
    private String level;
}
