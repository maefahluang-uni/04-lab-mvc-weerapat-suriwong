package th.mfu;

import java.util.Date;

public class Concert {

    //TODO: add attributes
private int id;
private String title;
private String performer;
private Date date;
private String description ;
    public Concert() {
    }
    public Concert(String title, String description) {
        //TODO: set attributes
this.title=title;
this. description= description ;
    }
 public String getTitle() {
    // TODO: return title
    return title;
 }
 public String getDescription(){
    //TODO: return description
    return description ;
}
//Todo: add getters and setters
public int getld (){
    return id;
}
public void setld(int id){
    this.id = id ;
}
 public void setTitle (String title)
{
    this.title = title;
}

public String getPerformer(){
return performer;
}
public void setPerformer(String performer){
    this.performer = performer;

}
public void setDate(Date date){
    this.date = date;
}
public void setDescription(String description){
    this.description = description;
  }
}
 //TODO: add getters and setters for all attributes
    // You can use Source action/generate getter setter function