import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScoreOfParenthesis {
    public int scoreOfParenthesis(String s){
        TreeNode root = new TreeNode();
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                TreeNode node = new TreeNode();
                if(stack.empty()){
                    root.addChild(node);
                }else{
                    stack.peek().addChild(node);
                }
                stack.push(node);
            }else{
                stack.pop();
            }
        }

        int score = 0;
        for(TreeNode child : root.children){
            score += child.score();
        }
        return score;
    }

    class TreeNode{
        private List<TreeNode> children;

        public TreeNode(){
            children = new ArrayList<>();
        }

        public void addChild(TreeNode node){
            children.add(node);
        }

        public int score(){
            if(children.isEmpty()){
                return 1;
            }else{
                int score = 0;
                for(TreeNode child : children){
                    score += child.score();
                }
                return 2 * score;
            }
        }
    }
}
