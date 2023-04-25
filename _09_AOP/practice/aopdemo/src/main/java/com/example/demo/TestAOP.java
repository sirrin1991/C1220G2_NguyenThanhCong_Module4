package com.example.demo;

public class TestAOP {
    private String message;

    public TestAOP(String message) {
        this.message = "hello bros";
    }

    public void mt1() {
        System.out.println(" start mt1 ");
        System.out.println(" end mt1 ");
    }

    public void mt2() {
        System.out.println(" start mt2 ");
        System.out.println(" end mt2 ");
    }

    public void mt3() {
        System.out.println(3);
        System.out.println(33);
        throw new IllegalArgumentException("error parameter");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
