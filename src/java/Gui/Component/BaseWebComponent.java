/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Component;

/**
 *
 * @author Admin
 */
public class BaseWebComponent {
     public static String generateHyperlink(String url,String label){
         return ( "<li><a href=\""+url+"\"> "+label+"</a></li>");
     }
     
     public static String generateTextBase(String label){
         return ("<li><span>"+label+"</span></li>");
     }
}

