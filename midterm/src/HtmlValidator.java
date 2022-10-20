import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {
    private ValidatorMain validator;
    private HtmlTag htmlTag;
    private Queue<HtmlTag> aQueue;
    public HtmlValidator(){
        Queue<HtmlTag> aQueue = new PriorityQueue();
    }
    public HtmlValidator(Queue<HtmlTag> tags){
        for(HtmlTag x : tags) {
            aQueue.add(x);
        }
    }
    public void addTag(HtmlTag tag) throws IllegalArgumentException{
        if (tag == null) throw new IllegalArgumentException("Not valid Argument!");
        aQueue.add(tag);
    }
    public Queue<HtmlTag> getTags() {
        return aQueue;
    }
    public void removeAll(String element) throws IllegalArgumentException{
        if (element == null) throw new IllegalArgumentException("Not valid tag");
        Iterator i = aQueue.iterator();
        String str = "";
        while (i.hasNext()) {
            str = i.next().toString();
            if (str.equals(element)) {
                i.remove();
            }
        }

    }
    public void validate() {
        String text = "";
        Stack stack = new Stack();
        int num = 0;
        Iterator i = aQueue.iterator();
        while (i.hasNext()) {
            if (i.next().toString().charAt(1) == '!') {
                text += "    ".repeat(num);
                text += i.next().toString();
                text += "\n";
            }
            else {

            }
            HtmlTag tag = (HtmlTag) i.next();
            if (tag.isOpenTag()) {
                stack.push(tag);
                num++;
            } else {

            }
            text += "    ".repeat(num);
            text += i.next().toString();
            text += "\n";

        }

    }

}
