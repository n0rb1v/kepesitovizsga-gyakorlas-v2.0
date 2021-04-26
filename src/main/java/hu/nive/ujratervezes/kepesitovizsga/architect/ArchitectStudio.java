package hu.nive.ujratervezes.kepesitovizsga.architect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ArchitectStudio {
    private Map<String, Plan> planMap = new HashMap<>();

    public void addPlan(String s, Plan plan) {
        if (s == null || plan == null) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        planMap.put(s,plan);
    }

    public Plan getPlanWithMaxSquareMeter() {
        int max = 0;
        Plan plan = null;
        for (String item: planMap.keySet()) {
            int x = planMap.get(item).calculateSquareMeter();
            if (x > max) {
                max = x;
                plan = planMap.get(item);
            }
        }
        return plan;
    }

    public Plan getPlanByWorkingTitle(String s) {
        if (s.isBlank()) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        if (planMap.get(s) == null) {
            throw new IllegalArgumentException("No such project.");
        }
        return planMap.get(s);
    }

    public Plan getPlanByProjectName(String s) {
        if (s.isBlank()) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        for (String item : planMap.keySet()) {
            if (planMap.get(item).getProjectName().equals(s)) {
                return planMap.get(item);
            }
        }
        throw new IllegalArgumentException("No such project.");
    }

    public List<Plan> getSmallerPlans(int i) {
        List<Plan> result = new ArrayList<>();
        for (String item: planMap.keySet()) {
            int x = planMap.get(item).calculateSquareMeter();
            if (x < i) {
                result.add(planMap.get(item));
            }
        }
        return result;
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }List<Plan> result = new ArrayList<>();
        for (String item: planMap.keySet()) {
            PlanType x = planMap.get(item).getType();
            if (x == type) {
                result.add(planMap.get(item));
            }
        }
        return result;
    }
}

