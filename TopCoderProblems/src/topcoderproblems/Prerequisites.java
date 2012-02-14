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
//    private String[] schedule;
//    private ClassComparator classComparator = new ClassComparator();
    private TreeSet<String> schedule = new TreeSet<>(new ClassComparator());

    public String[] orderClasses(String[] param0) {
        setClassPrerequisites(param0);
        if (classPrerequisites.isEmpty()) {
            return new String[0];
        }

//        TreeSet<String> schedule = new TreeSet<>(new ClassComparator());
        
        try {
            addToSchedule(new ArrayList<>(classPrerequisites.keySet()));
        } catch (IllegalArgumentException e) {
            return new String[0];
        }
        
//        Set<String> classes = classPrerequisites.keySet();
//        for (String className : classes) {
//            List<String> prerequisites = classPrerequisites.get(className);
//            try {
//                for (String prerequisite : map.getValue()) {
//                    if (!schedule.contains(prerequisite)) {
//                        schedule.add(prerequisite);
//                    }
//                }
//                String className = map.getKey();
//                if (!schedule.contains(className)) {
//                    schedule.add(className);
//                }                
//            } catch (IllegalArgumentException e) {
//                return new String[0];
//            }
//        }
        return schedule.toArray(new String[0]);
        
//        schedule = new String[classPrerequisites.size()];
//        for (Entry<String, List<String>> map : classPrerequisites.entrySet()) {
//            setSchedule(map.getKey(), map.getValue());
//        }
//        return schedule;
    }
    
    private void addToSchedule(List<String> classes) {        
        if (classes.isEmpty()) return;
        
        String className = classes.remove(0);
        List<String> prerequisites = classPrerequisites.get(className);
        if (prerequisites.isEmpty() && !schedule.contains(className)) {
            schedule.add(className);
            return;
        }
        
        addToSchedule(prerequisites);
        addToSchedule(classes);
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
            List<String> class1Prerequisites = classPrerequisites.get(class1);
            if (class1Prerequisites == null) {
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
            
//            if (classPrerequisites.get(class1).contains(class2)) {
//                return true;
//            }
//            
//            List<String> class2Prerequisites = classPrerequisites.get(class2);
//            for (String prerequisite : class2Prerequisites) {
//                return isClass2PrerequisiteOfClass1(class1, prerequisite);
//            }
//            
//            return false;
        }
        
    }
}
