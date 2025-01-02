package collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {

    private Deque<String> history = new ArrayDeque<String>();

    private String currentPage = null;

    public void visitPage(String url) {
        if(currentPage != null) {
            history.push(currentPage);
        }

        currentPage = url;
        System.out.println("방문 : " + url);
    }

    public String goBack() {
        if(!history.isEmpty()){
            String currentPage = history.pop();
            System.out.println("뒤로가기 : " + currentPage);
            return currentPage;
        }
        return null;
    }
}
