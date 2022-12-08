import java.util.*;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {
    public Queue<HtmlTag> aQueue;
    public HtmlValidator(){
        aQueue = new LinkedList<>();
    }
    public HtmlValidator(Queue<HtmlTag> tags){
        aQueue = new LinkedList<>();
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
        Iterator<HtmlTag> i = aQueue.iterator();
        HtmlTag openingTag = new HtmlTag(element,true);
        HtmlTag closingTag = new HtmlTag(element,false);
        HtmlTag tag;
        while (i.hasNext()) {
            tag = i.next();
            if (tag.matches(openingTag)||tag.matches(closingTag)) {
                i.remove();
            }
        }

    }
    public void validate() {
        String text = "";
        Stack stack = new Stack();
        int num = 0;
        Iterator<HtmlTag> i = aQueue.iterator();
        while (i.hasNext()) {
            HtmlTag crrTag = i.next();
            if (crrTag.isSelfClosing()) {
                if (!crrTag.isOpenTag()) {
                    text = text + "ERROR unexpected tag: " + crrTag + "\n";
                }else {
                    text += "    ".repeat(num);
                    text += crrTag.toString();
                    text += "\n";
                }
            }
            else {
                if(crrTag.isOpenTag()) {
                    text += "    ".repeat(num);
                    text += crrTag.toString();c
                    text += "\n";
                    stack.push(crrTag);
                    num++;
                } else {
                    if (stack.isEmpty()) {
                        text = text + "ERROR unexpected tag: " + crrTag + "\n";
                    }else {
                        if (crrTag.matches((HtmlTag) stack.peek())) {
                            num--;
                            stack.pop();
                            text += "    ".repeat(num);
                            text += crrTag.toString();
                            text += "\n";
                        }else {
                            text = text + "ERROR unexpected tag: " + crrTag + "\n";
                        }
                    }
                }
            }


        }
        while (!stack.isEmpty()) {
            text = text + "ERROR unclosed tag: " + stack.pop() + "\n";
        }
        System.out.println(text);


    }

}
