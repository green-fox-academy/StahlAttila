package com.greenfoxacademy.programmerfoxclub.Service;

import com.greenfoxacademy.programmerfoxclub.Model.Fox;
import com.greenfoxacademy.programmerfoxclub.Model.Trick;
import com.greenfoxacademy.programmerfoxclub.Repository.TrickList;
import com.greenfoxacademy.programmerfoxclub.Repository.FoxNameList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        list.findFoxQuery(fox.getName()).getTricks().add(new Trick(trickName));
    }

    public void addFoodOrDrinkAction(Fox fox, String food, String drink){
        long time = new Date().getTime();
        Timestamp ts = new Timestamp(time);
        list.findFoxQuery(fox.getName()).getActionHistory().add(ts.toString()+" : Changed diet to: "+food + " and "+drink);
    }

    public void addTrickAction(Fox fox, String trick){
        long time = new Date().getTime();
        Timestamp ts = new Timestamp(time);
        list.findFoxQuery(fox.getName()).getActionHistory().add(ts.toString()+ " : Learned: " + trick);
    }

    public List<String> get5latestAction(Fox fox){
        List<String> fiveLatestAction;
        if (fox.getActionHistory().size() > 5){
            fiveLatestAction = fox.getActionHistory().stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .limit(5)
                                                     .collect(Collectors.toList());
            return fiveLatestAction;
        }

        else return fox.getActionHistory();
    }

    @Override
    public List<String> tricksToLearn(Fox fox) {
        return trickList.tricksToLearnQuery(fox);
    }
}
