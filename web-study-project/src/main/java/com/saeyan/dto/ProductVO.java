package com.saeyan.dto;

/*
create table fruitList(
	code int primary key auto_increment,
    name varchar(30),
    price int,
    origin varchar(30),
    description varchar(1000),
    pictureurl varchar(50)
);
*/

public class ProductVO {
	
	private Integer code;
	private String name;
	private Integer price;
	private String origin;
	private String description;
	private String pictureUrl;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", name=" + name + ", price=" + price + ", origin=" + origin
				+ ", description=" + description + ", pictureUrl=" + pictureUrl + "]";
	}
	

	
}
