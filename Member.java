
import java.io.File;
import java.io.LineNumberReader;
import java.time.LocalDate; //Importiert LocalDate, um später darauf zuzugreifen.
import java.io.FileReader;

class Member{

    private String id;              //Deklaration der Klassenattribute, um die jeweiligen Mitgliedsdaten zu speichern.
    private LocalDate joiningdate;
    private String surname;
    private String forename;
    private Group group;
    private boolean newsletter;


    public Member(String line){

        String[] sections = line.split(";");    //Teilt den übergebenen String in die einzelnen Daten auf, Trennzeichen Semikolon. Durch die trim-Methode, werden führende
                                                     //und hinten drangehangene Leerzeichen entfernt.

        this.id = sections[0].trim();       //ID wird einfach als String übernommen.
        this.joiningdate = LocalDate.parse(sections[1].trim()); //Der Datum-String wird in ein Datum konvertiert.
        this.surname = sections[2].trim();  //...
        this.forename = sections[3].trim(); //...
        this.group = Group.valueOf(sections[4].trim()); //Der String für die Gruppe wird in den passenden Enum-Wert konvertiert.
        this.newsletter = Boolean.valueOf(sections[5].trim()); //Der String für den Newsletter wird in einen boolean-Wert konvertiert.

        }

        public String getId(){ //Gibt die ID zurück.
            return this.id;
        }

        public LocalDate getJoiningdate(){  //Gibt das Beitrittsdatum zurück.
            return this.joiningdate;
        }
        public String getSurname(){ //Gibt den Namen zurück.
            return this.surname;
        }
        public String getForename(){ //Gibt den Vornamen zurück.
            return this.forename;
        }

        public Group getGroup(){ //Gibt die jeweilige Gruppe zurück.
            return this.group;
        }
        public boolean hasNewsletter(){ //Gibt zurück, ob der Newsletter abonniert wurde.
            return this.newsletter;
        }
        @Override
        public boolean equals(Object o){    //Gibt zurück, ob es sich um den gleichen Member handelt.

            Member objectToCompare = (Member) o;    //Das Casten war nötig, um auf die Klassenmethode getId() zuzugreifen.
            return this.id.equals(objectToCompare.getId());
        }

        @Override   //Gibt die Daten im CSV-Format zurück.
        public String toString(){
            return String.format("%s;%s;%s;%s;%s;%s", this.id,this.joiningdate.toString(),this.surname,this.forename,this.group.toString(),Boolean.toString(this.newsletter));
        }

    }
