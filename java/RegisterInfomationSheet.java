/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ming
 */
public class RegisterInfomationSheet {

    /**
     *
     */
    protected String username1;

    /**
     *
     */
    protected String password1;
    RegisterInfomationSheet(){
        
    }
    
    RegisterInfomationSheet(String u, String p){
        username1 = u;
        password1 = p;
    }
    
    /**
     *
     * @param u
     */
    protected void setUsername(String u){
        username1= u;
    }

    /**
     *
     * @return
     */
    protected String getUsername(){
        return username1;
    }

    /**
     *
     * @param p
     */
    protected void setPassword(String p){
        password1 = p;
    }

    /**
     *
     * @return
     */
    protected String getPassword(){
        return password1;
    }
}
