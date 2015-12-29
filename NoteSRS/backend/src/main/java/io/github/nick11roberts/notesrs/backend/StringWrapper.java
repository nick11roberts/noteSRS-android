package io.github.nick11roberts.notesrs.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class StringWrapper {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public StringWrapper(String data){
        this.setData(data);
    }

    public StringWrapper(){}
}