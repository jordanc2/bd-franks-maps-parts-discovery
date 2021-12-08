package com.amazon.ata.maps.partsdiscovery;

import java.util.*;

/**
 * Helps expose key words from new editions of part catalogs.
 */
public class DevicePartDiscovery {

    // --- Part A ---
    /**
     * Calculate how often each word appears in a Catalog.
     * @param catalog The catalog to calculate word frequencies for.
     * @return A Map of words that appear in the catalog to the number of times they appear.
     */
    public Map<String, Integer> calculateWordCounts(PartCatalog catalog) {
        // PARTICIPANTS: Implement calculateWordCounts()
        // instantiate the object to be returned (returned Map)
        Map<String, Integer> returnedMap = new HashMap<>();

        for (String word : catalog.getCatalogWords()) { // iterate through all the words in the PartCatalog catalogWordList
            if (returnedMap.containsKey(word)) {       // check to see if the word is already in the returned Map
                                                      //  if it is in the returnedMap, increment its count by 1
                int currentCount = returnedMap.get(word); //  get the current count for the word from the returnedMap
                currentCount++;                     //  increment the current count
                returnedMap.put(word, currentCount);// put the current count for the word back in the returned
            } else {
            returnedMap.put(word, 1);            // if it's not in the returnedMap, add the current word with a count of 1
            }
        }
        return returnedMap; // return the object
    }

    // --- Part B ---
    /**
     * Removes a word from the provided word count map.
     * @param word the word to be removed
     * @param wordCounts the map to remove the word from
     */
    public void removeWord(String word, Map<String, Integer> wordCounts) {
        // PARTICIPANTS: Implement removeWord()
        wordCounts.remove(word); // remove the word provided from the Map provided
    }

    // --- Part C ---
    /**
     * Find the word that appears most frequently based on the word counts from a catalog.
     * @param wordCounts an association between a word and the total number of times it appeared in a catalog
     * @return The word that appears most frequently in the catalog to the number of times they appear.
     */
    public String getMostFrequentWord(Map<String, Integer> wordCounts) {
        // PARTICIPANTS: Implement getMostFrequentWord()
        // The word count is the VALUE in an entry in the Map
        // TreeMap will keep entries in KEY sequence - there is no version of Map that keeps value sequence (can't use)
        // Instantiate the return object
        String mostFrequentWord = ""; // initialize to an empty string

        int highestCountSoFar = 0;  // hold the highest count as we iterate through the Map

        // Iterate through the Map remembering the key with the highest wordCount
        // Map.Entry represents a single item of an entry in a Map
        // .entrySet() returns all the entries in a Map
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) { // iterates through each entry in Map wordcounts
                // if the VALUE in the current entry is greater than highestCountSoFar
            if (entry.getValue() > highestCountSoFar) {
                // remember the KEY as the current most frequent word & the VALUE as the highest value so far
                mostFrequentWord = entry.getKey();
                highestCountSoFar = entry.getValue();
            }
        }

//        // Alternate solution
//        Set<String> theKeys = wordCounts.keySet(); //Store all the Map keys in a Set
//        for (String aKey : theKeys) { // iterate through the Map keys, 1 at a time
//            if (wordCounts.get(aKey) > highestCountSoFar) {
//                mostFrequentWord = aKey;
//                highestCountSoFar = wordCounts.get(aKey);
//            }
//        }

        return mostFrequentWord;
    }

    // --- Part D ---
    /**
     * Calculates the TF-IDF score for each word in a catalog. The TF-IDF score for a word
     * is equal to the count * idf score. You can assume there will be an idfScore for each word
     * in wordCounts.
     * @param wordCounts - associates a count for each word from a catalog
     * @param idfScores - associates an IDF score for each word in the catalog
     * @return a map associating each word with its TF-IDF score.
     */
    public Map<String, Double> getTfIdfScores(Map<String, Integer> wordCounts, Map<String, Double> idfScores) {
        // PARTICIPANTS: Implement getTfIdfScores()
        // Instantiate the return object
        Map<String, Double> tf_IdfScores = new TreeMap<>(); // store entries in word(Key) order

        // Iterate through the wordCounts Map
        // Calculate the TF-IDF for each entry and store it in the returned Map
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            tf_IdfScores.put(entry.getKey(), entry.getValue() * idfScores.get(entry.getKey()));
            //                  the word      count for word  *  VALUE in idfScores for word
        }
        return tf_IdfScores; // return the Map with TF-IDF scores.
    }

    // --- Extension 1 ---
    /**
     * Gets the 10 highest (TF-IDF) scored words for a catalog.
     *
     * @param tfIdfScores - associates a TF-IDF score for each word in a catalog
     * @return a list of the 10 highest scored words for a catalog.
     */
    public List<String> getBestScoredWords(Map<String, Double> tfIdfScores) {
        // PARTICIPANTS: Implement getBestScoredWords()
        return Collections.emptyList();
    }

    // --- Extension 2 ---
    /**
     * Calculates the IDF score for each word in a set of catalogs. The IDF score for a word
     * is equal to the inverse of the total number of times appears in all catalogs.
     * Assume df is the sum of the counts of a single word across all catalogs, then idf = 1.0/df.
     *
     * @param catalogWordCounts - a list of maps that associate a count for each word for each catalog
     * @return a map associating each word with its IDF score.
     */
    public Map<String, Double> calculateIdfScores(List<Map<String,Integer>> catalogWordCounts) {
        // PARTICIPANTS: Implement getIdfScores()
        return Collections.emptyMap();
    }

}
