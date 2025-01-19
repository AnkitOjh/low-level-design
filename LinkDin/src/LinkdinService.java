import Notification.Observer.EmailNotification;
import Notification.Observer.IObserver;
import Notification.Observer.Observable.IObservalble;
import Notification.Observer.Observable.NotificationImpl;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LinkdinService {
    private User loggedInUser;
    private ConcurrentHashMap<String,User> hashMap ;
    private ConcurrentHashMap<String, Job> jobConcurrentHashMap;

    private IObservalble observable;
    public LinkdinService(){
        this.observable = new NotificationImpl();
        this.hashMap = new ConcurrentHashMap<>();
        this.jobConcurrentHashMap = new ConcurrentHashMap<>();
    }

    public void addUSer(String userName,String password,String email){
        if(hashMap.containsKey(userName) == true){
            System.out.println("User already exists");
        }
        else{
            User user = new User(userName,idGenerator(),password,email);
            System.out.println("user added succesfully");
            hashMap.put(userName,user);
        }
    }

    public void setLoggedInUser(String userName, String password){
       if(hashMap.containsKey(userName) == false){
           System.out.println("User doesn't exists");
       }
       else{
            if(hashMap.get(userName).getPassword().equalsIgnoreCase(password)){
                this.loggedInUser = hashMap.get(userName);
            }
            else{
                throw new RuntimeException("Wrong Password");
            }
       }
    }
    public void logOut(){
        this.loggedInUser = null;
        System.out.println("Successfully logged out");
    }

    public void sendConnection(String userName,String connectUSerName){
        if(loggedInUser == null || loggedInUser.equals(userName) == false){
            throw new RuntimeException("Invalid logged in user");
        }
        else{
            Connection connection = new Connection();
            if(hashMap.containsKey(connectUSerName) == false){
                System.out.println("This user doesn't exist");
            }
            else{
                connection.addUser(hashMap.get(connectUSerName));
                hashMap.get(userName).setConnections(connection);
                hashMap.get(connectUSerName).getConnectionRequest().add(connection);
                IObserver observer = new EmailNotification(hashMap.get(connectUSerName).getEmail());
                observable.addObserver(observer);
                observable.update("Email Notification");
                observable.removeObserver(observer);
            }

        }
    }

    public void acceptConnectionRequest(String userName){
        if(loggedInUser.getUserName().equalsIgnoreCase(userName)){
            User user = hashMap.get(userName);
            user.setConnections(user.getConnectionRequest().get(0));
        }
        else{
            System.out.println("Ypu are not current logged in user to see connection");
        }

    }

    public void sentMessage(String message,String userName){
        Message message1 = new Message(idGenerator(),message);
        observable.addObserver(new EmailNotification(hashMap.get(userName).getEmail()));
        observable.update("Email notification");
    }

    private String idGenerator(){
        return "RES" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }


}
