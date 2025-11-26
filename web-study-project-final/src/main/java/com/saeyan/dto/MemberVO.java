package com.saeyan.dto;

/*
 * id INT AUTO_INCREMENT PRIMARY KEY,   
    name VARCHAR(50),
    user_id VARCHAR(50),
    user_pw VARCHAR(100),
    nick VARCHAR(30),
    phone VARCHAR(20),
    admin INT,
    email VARCHAR(100),
    reg_date DATE,
    address VARCHAR(200)
 */

public class MemberVO {
    private int memberId;
    private String name;
    private String userId;
    private String userpw;
    private String nick;
    private String phone;
    private int admin;
    private String email;
    private String regDate;
    private String address;
   public int getMemberId() {
      return memberId;
   }
   public void setMemberId(int memberId) {
      this.memberId = memberId;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public String getUserpw() {
      return userpw;
   }
   public void setUserpw(String userpw) {
      this.userpw = userpw;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getRegDate() {
      return regDate;
   }
   public void setRegDate(String regDate) {
      this.regDate = regDate;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
      
   }
   public String getNick() {
      return nick;
   }
   public void setNick(String nick) {
      this.nick = nick;
   }
   public int getAdmin() {
      return admin;
   }
   public void setAdmin(int admin) {
      this.admin = admin;
   }
   
}
