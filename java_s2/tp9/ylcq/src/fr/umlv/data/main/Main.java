package fr.umlv.data.main;

import fr.umlv.data.LinkedLink;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println(new LinkedLink(0).add(1).add(2).add(3));
        LinkedLink ll = new LinkedLink("Salut").add("Michmich").add(2).add(3);
        System.out.println(ll);
        System.out.println(((String)ll.get(1).get()).length());
        */
        // Ex3.3
        // TODO
    }
    // Ex2.4
    // On est obligés de faire un cast parce que le compilateur
    // ne peut pas inférer le plus bas sous-type de Object. On doit lui
    // affirmer que nous sommes certains que notre objet est en fait un String.
    // On n'aime pas les casts parce que c'est unsafe.
}
