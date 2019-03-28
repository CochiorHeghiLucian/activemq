package com.example.demo.dto;

import lombok.Data;

@Data
public class TestDTO {
    private String text;
    private Integer intNumber;

    @Override
    public String toString() {
        return "TestDTO{" +
                "text='" + text + '\'' +
                ", intNumber=" + intNumber +
                '}';
    }
}
