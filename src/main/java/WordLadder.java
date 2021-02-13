import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashMap<String, List<String>> dict = new HashMap<>();

        for(String word : wordList){
            for(int i = 0; i < word.length(); i++){
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = dict.getOrDefault(pattern, new ArrayList<>());
                list.add(word);
                dict.put(pattern, list);
            }
        }

        Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
        beginQueue.add(new Pair(beginWord,  1));
        HashMap<String, Integer> beginVisited = new HashMap<>();
        beginVisited.put(beginWord, 1);

        Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
        endQueue.add(new Pair(endWord, 1));
        HashMap<String, Integer> endVisited = new HashMap<>();
        endVisited.put(endWord, 1);

        while(!beginQueue.isEmpty() || !endQueue.isEmpty()){
            if(!beginQueue.isEmpty()){
                int result = BidirectionalBFS(beginQueue, beginVisited, endVisited, dict);
                if(result != -1){
                    return result;
                }
            }

            if(!endQueue.isEmpty()){
                int result = BidirectionalBFS(endQueue, endVisited, beginVisited, dict);
                if(result != -1){
                    return result;
                }
            }
        }

        return 0;
    }

    private int BidirectionalBFS(Queue<Pair<String, Integer>> queue, HashMap<String, Integer> visitedBySelf, HashMap<String, Integer> visitedByTheOther, HashMap<String, List<String>> dict){
        Pair<String, Integer> pair = queue.poll();
        String word = pair.getKey();
        for(int i = 0; i < word.length(); i++){
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
            List<String> list = dict.getOrDefault(pattern, new ArrayList<>());
            for(String transformedWord : list){
                if(visitedByTheOther.containsKey(transformedWord)){
                    if(visitedBySelf.containsKey(transformedWord)){
                        return visitedBySelf.get(transformedWord) + visitedByTheOther.get(transformedWord) - 1;
                    }
                    return pair.getValue() + visitedByTheOther.get(transformedWord);
                }

                if(!visitedBySelf.containsKey(transformedWord)){
                    visitedBySelf.put(transformedWord, pair.getValue() + 1);
                    queue.add(new Pair(transformedWord, pair.getValue() + 1));
                }
            }
        }
        return -1;
    }
}
