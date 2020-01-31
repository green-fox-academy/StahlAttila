package com.greenfoxacademy.programmerfoxclub.Service;

import com.greenfoxacademy.programmerfoxclub.Model.Fox;
import com.greenfoxacademy.programmerfoxclub.Model.TrickList;
import com.greenfoxacademy.programmerfoxclub.Repository.FoxNameList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxServiceImp implements FoxService {

    FoxNameList list;
    TrickList trickList;

    @Autowired
    public FoxServiceImp(FoxNameList list, TrickList trickList) {
        this.list = list;
        this.trickList = trickList;
    }


    @Override
    public void addFox(String name) {
        list.addFoxQuery(name);
    }

    @Override
    public Fox findFox(String name) {
        return list.findFoxQuery(name);
    }

    @Override
    public Boolean isNewFox(String name){
        return list.isNewFoxQuery(name);
    }

    @Override
    public List<Fox> foxList() {
        return list.foxListQuery();
    }

    public void addTrick(Fox fox, String trickName){
        list.findFoxQuery(fox.getName()).getTricks().add(trickName);
    }
}
