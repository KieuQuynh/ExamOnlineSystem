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
public class Pagger  {
     public static String generate(int pageIndex,int gap,int maxPage,String currentUrl, int courseID){
         String result="<ul class='page-numbers'>";
         
        if(pageIndex >gap +1) 
            result+=BaseWebComponent.generateHyperlink(currentUrl+"?page=1&coursename="+courseID, "First");
        
        // before pageIndex
        for(int i=pageIndex-gap;i<pageIndex;i++ ){
            if(i>0)
            result+=BaseWebComponent.generateHyperlink(currentUrl+"?page="+i+"&coursename="+courseID, i+"");
        }
        
        //position of PageIndex
        result+=  BaseWebComponent.generateTextBase(pageIndex+"");
         
        //position of after PageIndex
        for(int i=pageIndex+1 ;i<=pageIndex+gap;i++){
            if(i>0 && i<=maxPage)
             result+= BaseWebComponent.generateHyperlink(currentUrl+"?page="+i+"&coursename="+courseID, i+"");
        }
        
        //lastPage
        
        if(pageIndex<maxPage-gap) 
            result+=BaseWebComponent.generateHyperlink(currentUrl+"?page="+maxPage+"&coursename="+courseID, "Last");
         
        return result+"</ul>";
     }
}
