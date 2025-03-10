package de.ostfalia.aud.ss25.base;

import java.time.LocalDate;

public class Member {
    private String id;
    private LocalDate joiningdate;
    private String surname;
    private String forename;
    private Group group;
    private boolean newsletter;

    public Member (String input){
        String[] inputArray = input.split(";");

        this.id = inputArray[0].trim();
        this.joiningdate = LocalDate.parse(inputArray[1].trim());
        this.surname = inputArray[2].trim();
        this.forename = inputArray[3].trim();
        this.group = Group.parse(inputArray[4].trim());
        this.newsletter = (boolean) inputArray[5];
    }

    public String getId(){
        return this.id;
    }
    public LocalDate getJoiningdate(){
        return this.joiningdate;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getForename(){
        return this.forename;
    }
    public Group getGroup(){
        return this.group;
    }
    public boolean hasNewsletter(){
        return this.newsletter;
    }
    @Override
    public boolean equals(Object o){                //Rick: "Vergleiche zwischen Strings sind stets ohne Berücksichtigung von * Groß/Kleinschreibung (case insensitive) durchzuführen."
        Member object = (Member) o;                 //      deshalb toLowerCase()
        return this.id.toLowerCase().equals(object.getId().toLowerCase());
    }
    @Override
    public String toStrinG(){               //Rick: Daten durch ";" getrennt
        String output = "";
        for (int i = 0; i < 6; i++){
            output += getId() + ";";
            output +=  String.parse(getJoiningdate())+ ";";
            output += getSurname() + ";";
            output += getForename() + ";";
            output += String.parse(getGroup()) + ";";
            output += String.parse(hasNewsletter());
        }
        return output;
    }


}