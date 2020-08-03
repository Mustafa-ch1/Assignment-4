/**
 * A class to hold a list of int data, by
 * storing them as a linked list.
 */
import java.util.Arrays; 
public class IntLinkList {

    private IntNode top; //The reference to the first Node

    //=========== Solution code =============================
    //constructor will check if top is null we will assign it the object reference
    //otherwise loop through till its not null or or you reach a point when the next link 
    //assigned is null
    public IntLinkList(int[] data){
        top = null;
        for(int i=0;i<data.length;i++){
            IntNode newNode = new IntNode(i, null);
            if (top==null){
                top=newNode;
            } else{
                IntNode next = top;
                while(next!=null){
                    if(next.getLink()==null){
                        next.setLink(newNode);
                        break;
                    } else{
                        next = next.getLink();
                    }
                }
            }
        }
    }
    //this method will check with the if that if top or our first reference
    //top is equal to null or not nad return true accordingly 
    public boolean empty(){
        if(top==null){
            return true;}
        else{
            return false;
        }
    }
    //simply get the first int in the list 
    public int first(){
        return top.getData();
    }
    //will check if top is not equal to null and then will simply assign top the link
    public void removeFirst(){
        if(top!=null){
            top = top.getLink();
        }
    }
    //making deep copy of the original list while giving it new nodes
    public IntLinkList clone (){
        IntNode next = top;
        if(top==null){
            IntLinkList list = new IntLinkList();
            return list;
        }
        else{
            int[] data =  {};

            while(next!=null){
                int item = next.getData();
                data = Arrays.copyOf(data, data.length + 1);
                data[data.length - 1] = item;
                next = next.getLink();
            }
            IntLinkList list = new IntLinkList(data);
            return list;
        }
    }
    //checks if top pointers are same or not.will first check for null and 
    //they are no will check the data to see if they are exactly the same and if they 
    //are no will return false meaning integers are not the same
    private static boolean equals(IntNode  top1, IntNode top2){
        if(top1==null&&top2==null){
            return true;
        } 
        if (top1!=null&& top2!=null){
            if(top1.getData()!= top2.getData()){
                return false;
            }
            return equals(top1.getLink(),  top2.getLink());
        }
        return false;
    }
  //taking an empty list and inserting each element from the original and adding it
  //to this one while removing elements from the original making it eventually 
  //empty 
     private void makeSorted(IntLinkList origList, IntLinkList otherList){
      if(origList.empty()){
          if(!otherList.empty()){
                origList.top = otherList.top;
          }
      }else{
          
          int item = origList.first();
          otherList.ordInsert(item);
          origList.removeFirst();
          makeSorted(origList, otherList);
      }
  }
   public void inSort(){
    
      IntLinkList otherList = new IntLinkList();
      makeSorted(this, otherList);
  }


    //=========== Supplied code =============================

    public IntLinkList() {
        //A constructor that creates an empty list.
        top = null;
    }

    public void ordInsert(int newItem) {
        //Add the newItem so that the list remains sorted into
        //ascending order. This will not work unless the list
        //is currently in ascending order.
        IntNode prev = null;
        IntNode next = top;
        while(next!=null && next.getData()<newItem){
            prev = next;
            next = next.getLink();
        }
        //This item belongs between prev and next
        IntNode newNode = new IntNode(newItem,next);
        if(prev==null)
            top = newNode;
        else
            prev.setLink(newNode);
    }

    public void add(int newItem) {
        //Add the newItem at the FRONT of the list.
        top = new IntNode(newItem,top);
    }//add

    public String toString() {
        String answer = "<<";
        IntNode next = top;
        while(next!=null){
            answer += next.getData()+" ";
            next = next.getLink();
        }
        return answer+">>";
    }

    public boolean equals(IntLinkList other){
        return equals(top,other.top);
    }
}
