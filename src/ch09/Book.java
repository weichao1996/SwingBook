/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch09;

/**
 *
 * @author wei__chao
 */
public class Book {
    String BookID;
    String BookName;
    String Author;
    String Press;
    String PressDate;
    String Status;
    Book(){
    
    }
    Book(String BookID,String BookName,String Author,String Press,String PressDate,String Status){
       this.BookID=BookID;
       this.BookName=BookName;
       this.Author=Author;
       this.Press=Press;
       this.PressDate=PressDate;
       this.Status=Status;
    }
}
