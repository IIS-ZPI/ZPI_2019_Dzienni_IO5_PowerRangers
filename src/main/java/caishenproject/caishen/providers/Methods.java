package caishenproject.caishen.providers;

import caishenproject.caishen.providers.data.DataForResponse;


import java.util.*;

final class Methods {

    private Methods(){
        throw new UnsupportedOperationException();
    }

    public static double getMedian(List<DataForResponse> rates) {
        List<Double> rateValues = new ArrayList<>();
        int arraySize = rates.size() - 1;
        for (DataForResponse rate : rates) {
            rateValues.add(rate.getMid());
        }
        Collections.sort(rateValues);
        return arraySize % 2 > 0 ? rateValues.get((arraySize / 2)) :
                (rateValues.get((arraySize / 2)) + rateValues.get((arraySize / 2) - 1)) / 2;
    }

    public static double getDominant(List<DataForResponse> rates) {
        Map<Double, Integer> rateValues = new HashMap<>();
        for (DataForResponse rate : rates) {
            if (!rateValues.isEmpty() && rateValues.containsKey(rate.getMid())) {
                int count = rateValues.get(rate.getMid());
                rateValues.replace(rate.getMid(), count + 1);
            } else {
                rateValues.put(rate.getMid(), 0);
            }
        }
        Map<Double, Integer> sortedValues = sortByValue(rateValues);
        Map.Entry<Double, Integer> entry = sortedValues.entrySet().iterator().next();
        return entry.getKey();
    }


    public static double getStandardDeviation(List<DataForResponse> rates) {
        double mean = getMean(rates);
        double temp = 0.0;
        for (DataForResponse rate : rates) {
            temp += (rate.getMid() - mean) * (rate.getMid() - mean);
        }
        return temp / (rates.size() - 1);
    }


    public static double calculateCoefficientOfVariation(List<DataForResponse> rates) {
        return getStandardDeviation(rates) / getMean(rates) * 100;
    }


    private static double getMean(List<DataForResponse> rates) {
        double sum = 0.0;
        for (DataForResponse rate : rates) {
            sum += rate.getMid();
        }
        return sum / rates.size();
    }

    private static Map<Double, Integer> sortByValue(Map<Double, Integer> unsortedMap) {

        List<Map.Entry<Double, Integer>> list =
                new LinkedList<>(unsortedMap.entrySet());

        list.sort(Comparator.comparing(o -> (o.getValue())));

        Map<Double, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Double, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


}
