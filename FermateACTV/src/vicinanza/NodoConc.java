/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vicinanza;

/**
 *
 * @author PS03
 */
public class NodoConc <T> {

  public T info;     //campo informazione
  public NodoConc <T> next;   //campo link

  //costruttore

  public NodoConc (T  info, NodoConc <T>  next){
    this.info = info;
    this.next = next;
  }

}
