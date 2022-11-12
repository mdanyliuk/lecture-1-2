import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    /**
     * Returns a map, which consists of top-5 most using hashtags from given list of strings.
     * If same hashtag presences in the same string more than 1 time, it counts as 1 appearance.
     *
     * @param list given list of strings, must be not null
     * @return a map, in which keys are most using hashtags and values are numbers of hashtag's appearance.
     */
    public Map<String, Integer> getTopHashTags(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Parameter must be not null");
        }
        Map<String, Integer> countHashTagMap = new HashMap<>();
        for (String str : list) {
            Set<String> setOfHashTags = getSetOfHashTags(str);
            for (String hashTag : setOfHashTags) {
                if (countHashTagMap.containsKey(hashTag)) {
                    countHashTagMap.put(hashTag, countHashTagMap.get(hashTag) + 1);
                } else {
                    countHashTagMap.put(hashTag, 1);
                }
            }
        }
        return countHashTagMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Set<String> getSetOfHashTags(String str) {
        Set<String> res = new HashSet<>();
        String[] splitted = str.split("\\s+");
        for (String word : splitted) {
            if ("#".equals(word.substring(0, 1))) {
                res.add(word);
            }
        }
        return res;
    }
}
