import java.util.LinkedList;
import java.util.Optional;
import java.util.Iterator;
import java.util.Objects;

// 1.
public class FreeShoppingCart {

    private LinkedList<Book> books;

    public FreeShoppingCart() { 
        books = new LinkedList<Book>(); 
    }
    public void add(Book b) { 
        books.add(b);
    }
    // 2.
    public int numberOfBooks() { return books.size(); }
    // 3.
    public Optional<Book> longestTitle_Index() {
        if(numberOfBooks() <= 0)
            return Optional.empty();

        Book longestTitleBook = books.get(0);
        for(int i=1 ; i<numberOfBooks() ; ++i) {
            final int curlen = books.get(i).getTitle().length();
            final int lnglen = longestTitleBook.getTitle().length();
            if(curlen > lnglen)
                longestTitleBook = books.get(i);
        }

        return Optional.of(longestTitleBook);
    }
    // 4.
    public Optional<Book> longestTitle_Iterator() {
        if(numberOfBooks() <= 0)
            return Optional.empty();

        Iterator<Book> it = books.iterator();
        Book cur = it.next();
        Book longestTitleBook = cur;
        while(it.hasNext()) {
            cur = it.next();
            final int curlen = cur.getTitle().length();
            final int lnglen = longestTitleBook.getTitle().length();
            if(curlen > lnglen)
                longestTitleBook = cur;
        }

        return Optional.of(longestTitleBook);
    }
    // 5.
    // "javap -c" nous dit qu'une boucle foreach compile vers une boucle
    // avec Iterator.
    // Quand on le fait sur la classe Test, en revanche, ça compile directement
    // vers une boucle for normale à index.
    public Optional<Book> longestTitle() {
        if(numberOfBooks() <= 0)
            return Optional.empty();

        Book longestTitleBook = books.get(0);
        for(Book cur : books) {
            final int curlen = cur.getTitle().length();
            final int lnglen = longestTitleBook.getTitle().length();
            if(curlen > lnglen)
                longestTitleBook = cur;
        }

        return Optional.of(longestTitleBook);
    }

    // 6. 
    // Pire cas : O(n). Moyenne : O(n/2).
    public void removeFirstOccurence(Book b) {
        Objects.requireNonNull(b);
        books.remove(b);
    }

    // 7.
    // Le programme compile toujours parce que :
    // - get(int) est implémentée pour LinkedList (visiblement);
    // - C'est le but d'Iterator de marcher pour toutes collections;
    // - La boucle foreach marche car elle compile vers un Iterator.
    //
    // Non, ça n'améliore pas la complexité dans le pire cas. On ne peut pas
    // empêcher la totalité des éléments d'être parcourue.
    //
    // 8.
    // Bah sa complexité ne change pas.
    public void removeFirstOccurence_Iterator(Book b) {
        Objects.requireNonNull(b);
        for(Iterator<Book> it = books.iterator() ; it.hasNext() ;) {
            if(b.equals(it.next())) {
                it.remove();
                break;
            }
        }
    }
    // 9.
    // On doit utiliser la boucle foreach quand on veut rapidement itérer
    // sur une collection.
    // On doit utiliser un itérateur si on veut retirer des éléments à la
    // volée (si la méthode remove() de la collection ne suffit pas).
    //
    //
    // (Utilitaires pour les tests :)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre de livres: ").append(numberOfBooks()).append("\n");
        for(Book b : books)
            sb.append(b).append("\n");
        return sb.toString();
    }
    public void displayContents() {
        System.out.println(this);
    }

}
