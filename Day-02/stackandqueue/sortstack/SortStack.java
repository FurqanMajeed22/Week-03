package stackandqueue.sortstack;
import java.util.Stack;
public class SortStack {
    public static void sort(int element, Stack<Integer> st) {
        if (st.isEmpty() || element <= st.peek()) {
            st.push(element);
            return;
        }
        int x = st.pop();
        sort(element, st);
        st.push(x);
    }

    public static   void solve(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int element = st.pop();
        solve(st);
        sort(element, st);
    }

    public static void main(String[] args) {
        Stack<Integer>st=new Stack<>();
        st.push(6);
        st.push(1);
        st.push(5);
        st.push(2);
        st.push(4);
        st.push(3);
        solve(st);
        while(!st.isEmpty()){
            System.out.println(st.pop());

        }


    }
}


