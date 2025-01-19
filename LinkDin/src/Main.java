public class Main {
    public static void main(String args[]){

        LinkdinService linkdinService = new LinkdinService();
        linkdinService.addUSer("a1","123","ao");
        linkdinService.addUSer("a2","1234","a2o");
        linkdinService.sendConnection("a1","a2");
        linkdinService.setLoggedInUser("a1","123");
//        linkdinService.logOut();
        linkdinService.sendConnection("a1","a2");
        linkdinService.sentMessage("Hello there","a2");
        linkdinService.logOut();




    }
}
