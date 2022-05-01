package dev.roder.intqtoolbackend.Entities;

import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alternativ {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @Override
    public String toString(){
        JSONObject details = new JSONObject();
        details.put("id",alternativeID);
        details.put("alternative",alternative);

        return details.toString();

    }


    public String getDetailsForEdit(){
        JSONObject details = new JSONObject();
        details.put("id",alternativeID);
        details.put("alternative",alternative);
        details.put("rightAlternative",rightAlternative);

        return details.toString();

    }

}