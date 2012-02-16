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
    private HashMap<String, Integer> classIndex = new HashMap<>();
    private String[] schedule;
    private ClassComparator classComparator = new ClassComparator();

    public String[] orderClasses(String[] param0) {
        setClassPrerequisites(param0);
        if (classPrerequisites.isEmpty()) {
            return new String[0];
        }

        schedule = new String[classPrerequisites.size()];
        for (Entry<String, List<String>> map : classPrerequisites.entrySet()) {
            try {
                for (String prerequisite : map.getValue()) {
                    addToSchedule(prerequisite);
                }
                addToSchedule(map.getKey());
            } catch (IllegalArgumentException e) {
                return new String[0];
            }
        }

        return schedule;
    }

    private void addToSchedule(String className) {
        if (classIndex.containsKey(className)) {
            return;
        }
        
        if (schedule[0] == null) {
            schedule[0] = className;
            classIndex.put(className, 0);
            return;
        }
        
        int startIndex = 0;
        List<String> prerequisites = classPrerequisites.get(className);
        for (String prerequisite : prerequisites) {
            if (classIndex.containsKey(prerequisite)) {
                int prerequisiteIndex = classIndex.get(prerequisite);
                if (startIndex < classIndex.get(prerequisite)) {
                    startIndex = prerequisiteIndex;
                }
            }
        }
        
        for (int i = startIndex; i < classIndex.size(); i++) {         
            int preCompareResult = classComparator.compare(className, schedule[i]);
            int postCompareResult = (schedule[i + 1] == null) ?
                    0 :
                    classComparator.compare(className, schedule[i + 1]);
            int insertPosition = -1;
            if (preCompareResult <= 0) {
                insertPosition = i;
            }
            
            if (preCompareResult > 0 && postCompareResult <= 0) {
                insertPosition = i + 1;
            }
            
            if (insertPosition > -1) {
                shiftSchedule(insertPosition);
                schedule[insertPosition] = className;
                classIndex.put(className, insertPosition);
                return;
            }
        }
    }
    
    private void shiftSchedule(int startIndex) {
        if (schedule[startIndex] != null) {
            for (int j = classIndex.size(); j > startIndex; j--) {
                schedule[j] = schedule[j - 1];
            }
        }        
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
            if (classPrerequisites.get(class1) == null ||
                classPrerequisites.get(class2) == null) {
                throw new IllegalArgumentException();
            }

            boolean isClass2PrerequisiteOfClass1 = isClass2PrerequisiteOfClass1(class1, class2);
            boolean isClass1PrerequisiteOfClass2 = isClass2PrerequisiteOfClass1(class2, class1);

            if (isClass2PrerequisiteOfClass1 && isClass1PrerequisiteOfClass2) {
                throw new IllegalArgumentException();
            }

            if (isClass2PrerequisiteOfClass1) {
                return 1;
            }

            if (isClass1PrerequisiteOfClass2) {
                return -1;
            }

            String classNumber1 = this.getClassNumber(class1);
            String classNumber2 = this.getClassNumber(class2);
            int compareResult = classNumber1.compareTo(classNumber2);
            if (compareResult != 0) {
                return compareResult;
            }

            return class1.compareTo(class2);
        }

        private String getClassNumber(String className) {
            return className.substring(className.length() - 3, className.length());
        }

        private boolean isClass2PrerequisiteOfClass1(String class1, String class2) {            
            return classPrerequisites.get(class1).contains(class2);
        }
    }
}
