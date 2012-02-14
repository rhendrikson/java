/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topcoderproblems;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 */
public class Prerequisites {

    private HashMap<String, List<String>> classPrerequisites = new HashMap<>();

    public String[] orderClasses(String[] param0) {
        setClassPrerequisites(param0);
        if (classPrerequisites.isEmpty()) {
            return new String[0];
        }

        TreeSet<String> schedule = new TreeSet<>(new ClassComparator());
        for (Entry<String, List<String>> map : classPrerequisites.entrySet()) {
            for (String prerequisite : map.getValue()) {
                if (!schedule.contains(prerequisite)) {
                    schedule.add(prerequisite);
                }
            }
            String className = map.getKey();
            if (!schedule.contains(className)) {
                schedule.add(className);
            }
        }

        return schedule.toArray(new String[0]);
    }

    private void setClassPrerequisites(String[] classes) {
        for (String classList : classes) {
            if (!classList.matches("^[A-Z]{3,4}[1-9]{1}[0-9]{2}:( [A-Z]{3,4}[1-9]{1}[0-9]{2})*$")) {
                classPrerequisites.clear();
                return;
            }
            
            ArrayList<String> tokenizedClasses = new ArrayList<>();
            for (StringTokenizer tokenizer = new StringTokenizer(classList, " "); tokenizer.hasMoreTokens();) {
                tokenizedClasses.add(tokenizer.nextToken());
            }
            String className = tokenizedClasses.get(0).substring(0, tokenizedClasses.get(0).length() - 1);
            classPrerequisites.put(className, tokenizedClasses.size() == 1 ? new ArrayList<String>() : tokenizedClasses.subList(1, tokenizedClasses.size()));
        }
    }

    private class ClassComparator implements Comparator<String> {

        @Override
        public int compare(String class1, String class2) {
            int compareResult = class1.compareTo(class2);
            
            if (compareResult == 0) {
                return 0;
            }
            
//            if (classPrerequisites.get(class1).contains(class2)) {
//                return -1;
//            }

            return compareResult;
        }
    }
}
