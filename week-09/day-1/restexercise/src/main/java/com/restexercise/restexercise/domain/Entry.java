package com.restexercise.restexercise.Domain;

import java.util.List;

public class Entry {

    private List<Log> entries;
    private Integer entryCount;

    public Entry(List<Log> logs) {
        this.entries = logs;
        this.entryCount = entries.size();
    }

    public List<Log> getEntries() {
        return entries;
    }

    public void setEntries(List<Log> entries) {
        this.entries = entries;
    }

    public Integer getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(Integer entryCount) {
        this.entryCount = entryCount;
    }

}
