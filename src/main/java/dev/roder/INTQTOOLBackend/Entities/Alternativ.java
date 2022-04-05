package dev.roder.INTQTOOLBackend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alternativ {

    @Id
    private Integer alternativeID;

    private String alternative;


    private boolean rightAlternative;

    public Alternativ(){

    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Integer getAlternativeID() {
        return alternativeID;
    }

    public void setAlternativeID(Integer alternativeID) {
        this.alternativeID = alternativeID;
    }

    public boolean isRightAlternative() {
        return rightAlternative;
    }

    public void setRightAlternative(boolean rightAlternative) {
        this.rightAlternative = rightAlternative;
    }

}