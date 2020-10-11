public class RankFromStream {
    private RankNode root;

    public void track(int x){
        if(root == null){
            root = new RankNode(x);
        } else {
            root.insert(x);
        }
    }

    public int getRankOfNumber(int x){
        return root.findRankOfNum(x);
    }
    private class RankNode{
        public int data;
        public RankNode left;
        public RankNode right;
        public int leftSize;
        public int duplicateCount;

        public RankNode(){

        }

        public RankNode(int data){
            this.data = data;
        }

        public void insert(int data){
            if(this.data == data){
                duplicateCount++;
            }

            if(this.data < data){
                if(right != null){
                    right.insert(data);
                } else{
                    right = new RankNode(data);
                }
            }else{
                if(left != null){
                    left.insert(data);
                }else{
                    left = new RankNode(data);
                }
                leftSize++;
            }
        }

        public int findRankOfNum(int data){
            if(this.data == data){
                return leftSize + duplicateCount;
            } else if(this.data < data){
                return leftSize + duplicateCount + 1 + right.findRankOfNum(data);
            }else{
                return left.findRankOfNum(data);
            }
        }
    }
}
