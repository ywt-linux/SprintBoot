package com.example.dbapplication.Message;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

//message包的基本信息
@Entity
@Table
public class Message {
    @Id
    @SequenceGenerator(
            name = "message_sequence",
            sequenceName = "message_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "message_sequence"
    )
    private long id;
    private String name; //车主姓名
    private String place; //发生地点
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime doa; //发生日期
    private Integer accidentKind; //事故类型
    private String carNumber; //车牌号
    private boolean status;//是否已经处理的状态
    @Transient
    private Integer testNumber; //测试数字无意义,后续改为随机生成的数字

    public Message() {

    }

    public Message(long id,
                   String name,
                   String place,
                   LocalDateTime doa,
                   Integer accidentKind,
                   String carNumber,
                   boolean status
                   ) {

        this.id = id;
        this.name = name;
        this.place = place;
        this.doa = doa;
        this.accidentKind = accidentKind;
        this.carNumber = carNumber;
        this.status = status;
    }

    public Message(String name,
                   String place,
                   LocalDateTime doa,
                   Integer accidentKind,
                   String carNumber,
                   boolean status
                   ) {
        this.name = name;
        this.place = place;
        this.doa = doa;
        this.accidentKind = accidentKind;
        this.carNumber = carNumber;
        this.status = status;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getDoa() {
        return doa;
    }

    public void setDoa(LocalDateTime doa) {
        this.doa = doa;
    }

    public Integer getAccidentKind() {
        return accidentKind;
    }

    public void setAccidentKind(Integer accidentKind) {
        this.accidentKind = accidentKind;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getTestNumber() {
        return (Integer) (int)(Math.random()*200 + 300);
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", doa=" + doa +
                ", accidentKind=" + accidentKind +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
