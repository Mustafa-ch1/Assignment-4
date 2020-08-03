/**
 * One particular node in a linked list of nodes containing int data.
 */
public class IntNode {
  
  private int data;  //The data in this Node
  private IntNode link; //The link to the next Node
  
  public IntNode(int initData, IntNode initLink){
    data = initData;
    link = initLink;
  }
  
  public int getData() {return data;}
  public IntNode getLink() {return link;}
  public void setData(int o) {data = o;}
  public void setLink(IntNode n) {link = n;}
  
  
}
