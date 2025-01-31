// Step 1: Iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Step 2: Concrete Iterator
class BookIterator implements Iterator<String> {
    private List<String> books;
    private int position = 0;

    public BookIterator(List<String> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return books.get(position++);
    }
}

// Step 3: Aggregate interface
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// Step 4: Concrete Aggregate
class BookCollection implements IterableCollection<String> {
    private List<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
    }

    public List<String> getBooks() {
        return books;
    }

    @Override
    public Iterator<String> createIterator() {
        return new BookIterator(books);
    }
}

// Step 5: Client
public class IteratorPatternDemo {
    public static void main(String[] args) {
        // Create a book collection
        BookCollection collection = new BookCollection();
        collection.addBook("Design Patterns");
        collection.addBook("Clean Code");
        collection.addBook("Refactoring");

        // Create an iterator for the collection
        Iterator<String> iterator = collection.createIterator();

        System.out.println("Traversing Book Collection:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
