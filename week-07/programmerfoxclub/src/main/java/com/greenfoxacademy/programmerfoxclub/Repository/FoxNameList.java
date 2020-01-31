package com.greenfoxacademy.programmerfoxclub.Repository;

import com.greenfoxacademy.programmerfoxclub.Model.Fox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoxNameList {

    private List<Fox> foxList;

    public FoxNameList() {
        this.foxList = new ArrayList<>();
    }

    public void addFoxQuery(String name){
        this.foxList.add(new Fox(name));
    }

    public Fox findFoxQuery(String name) {
        Optional<Fox> foxToFind = foxList.stream().filter(f -> f.getName().equals(name)).findFirst();

        return foxToFind.orElse(null);
    }

    public Boolean isNewFoxQuery(String name) {
        Optional<Fox> foxToFind = foxList.stream().filter(f -> f.getName().equals(name)).findFirst();

        if(foxToFind.isPresent()){
            return false;
        }
        return true;
    }

    public List<Fox> foxListQuery(){
        return foxList;
    }
}
