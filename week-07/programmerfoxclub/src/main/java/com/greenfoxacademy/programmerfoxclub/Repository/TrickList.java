package com.greenfoxacademy.programmerfoxclub.Repository;

import com.greenfoxacademy.programmerfoxclub.Model.Fox;
import com.greenfoxacademy.programmerfoxclub.Model.Trick;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class TrickList {
    /*private List<Trick> trickList;*/
    private List<String> trickListAsStrig;

    public TrickList() {
        /*this.trickList = new ArrayList<>();
        trickList.add(new Trick("write HTML"));
        trickList.add(new Trick("write CSS"));
        trickList.add(new Trick("suck a dick"));
        trickList.add(new Trick("do a kickflip"));*/
        this.trickListAsStrig = new ArrayList<>();
        trickListAsStrig.add("write HTML");
        trickListAsStrig.add("write CSS");
        trickListAsStrig.add("suck a dick");
        trickListAsStrig.add("do a kickflip");
    }

    public List<String> tricksToLearnQuery(Fox fox) {

        return trickListAsStrig.stream().filter(t -> !fox.getTricksAsString().contains(t)).collect(Collectors.toList());
    }
}
