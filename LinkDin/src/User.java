import java.util.ArrayList;
import java.util.List;
public class User {
        private final String userName;
        private final String id;
        private String password;

        private String email;
        private List<Message> messageList;
        private List<Message> outBoxMessageList;
        private List<Connection> connections;

        private List<Connection> connectionRequest;


        // Constructor
        public User(String userName, String id, String password,String email) {
            this.userName = userName;
            this.id = id;
            this.password = password;
            this.connections = new ArrayList<>();
            this.outBoxMessageList = new ArrayList<>();
            this.messageList = new ArrayList<>();
            connectionRequest = new ArrayList<>();
            this.email = email;
        }

        // Getters
        public String getUserName() {
            return userName;
        }

        public String getEmail(){
            return this.email;
        }

        public String getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

        public List<Message> getMessageList() {
            return messageList;
        }

        public List<Message> getOutBoxMessageList() {
            return outBoxMessageList;
        }

        public List<Connection> getConnections() {
            return connections;
        }

        // Setters
        public void setPassword(String password) {
            this.password = password;
        }

        public void setMessageList(Message message) {
            this.messageList.add(message);
        }

        public void setOutBoxMessageList(Message outBoxMessageList) {
            this.outBoxMessageList.add(outBoxMessageList);
        }

        public void setConnections(Connection connection) {
            this.connections.add(connection);
        }

        public List<Connection> getConnectionRequest(){
            System.out.println("I have got the connection "+this.userName);
            return this.connectionRequest;
        }



}
