package com.Test.day20191129;

import java.io.Serializable;
import java.util.Random;

public class Attritube implements Serializable{
	Random rand = new Random();
public String name="ÕÅÈý";
public String sex="ÄÐ";
public int age=20;
public int money=100;
public int food=1;
public int strong=10;
public int smart=10;
public int date=5;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public int getFood() {
	return food;
}
public void setFood(int food) {
	this.food = food;
}

}
