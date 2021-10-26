package kolekcje;

//klasa pojo, tutaj się nie odpala funkcji


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Owoc {
    private String name;
    private String color;
    private double prize;

}
