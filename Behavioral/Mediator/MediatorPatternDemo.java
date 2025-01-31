// Step 1: Mediator Interface
interface ChatMediator {
  void sendMessage(String message, User user);
  void addUser(User user);
}

// Step 2: Concrete Mediator
class ChatRoom implements ChatMediator {
  private List<User> users = new ArrayList<>();

  @Override
  public void sendMessage(String message, User user) {
      for (User u : users) {
          if (u != user) { // Do not send the message to the sender
              u.receive(message);
          }
      }
  }

  @Override
  public void addUser(User user) {
      users.add(user);
  }
}

// Step 3: Colleague Abstract Class
abstract class User {
  protected ChatMediator mediator;
  protected String name;

  public User(ChatMediator mediator, String name) {
      this.mediator = mediator;
      this.name = name;
  }

  public abstract void send(String message);
  public abstract void receive(String message);
}

// Step 4: Concrete Colleagues
class ConcreteUser extends User {
  public ConcreteUser(ChatMediator mediator, String name) {
      super(mediator, name);
  }

  @Override
  public void send(String message) {
      System.out.println(name + " sends: " + message);
      mediator.sendMessage(message, this);
  }

  @Override
  public void receive(String message) {
      System.out.println(name + " receives: " + message);
  }
}

// Step 5: Client
public class MediatorPatternDemo {
  public static void main(String[] args) {
      ChatMediator chatRoom = new ChatRoom();

      User user1 = new ConcreteUser(chatRoom, "Alice");
      User user2 = new ConcreteUser(chatRoom, "Bob");
      User user3 = new ConcreteUser(chatRoom, "Charlie");

      chatRoom.addUser(user1);
      chatRoom.addUser(user2);
      chatRoom.addUser(user3);

      user1.send("Hi everyone!");
      user2.send("Hello Alice!");
  }
}
+
