package com.bank;

import java.util.*;

/**
 *
 * Input to the function will be amount and portfolio object. return an object with the amount being equally distributed based on the portfolio given.
 *
 * stocks: AAPL, EA, ATVI, OKTA, TEAM
 * portfolios: p1, ..., p4
 *
 *
 *  * p1: 0.4 p2, 0.2 AAPL, 0.4 EA
 *  * p2: 0.4 p3, 0.4 p4, 0.2 AAPL
 *  * p3: 0.2 EA, 0.8 ATVI
 *  * p4: 0.6 OKTA, 0.4 TEAM```
 *  *
 * Portfolio can be nested  : ```p1: 0.4 p2, 0.2 AAPL, 0.4 EA ```
 * Given the amount 1000$ and portfolio p4 as the input return as below
 * ```/**
 *  * e.g. Input given is p4, $1000 -> {"OKTA": $600, "TEAM": $400, ......}
 *  * p1 ->  ??
 *  * p2 ->  ??
 *  * p3 -> ??
 *  ```
 */

/**
 * The portfolio is given as a list of (fraction,stock) or (fraction,portfolio) pairs,
 */

public class Portfolio {
    Map<String, List<Company>> portfolioMap = new HashMap<>();
    Map<String, Integer> result = new HashMap<>();

    public static void main(String args[]){
        Portfolio p = new Portfolio();
        System.out.println(p.compute("p1", 1000));
    }


    public Portfolio(){
        List<Company> list1 = new ArrayList<>();
        list1.add(new Company(0.4, "p2"));
        list1.add(new Company(0.2, "AAPL"));
        list1.add(new Company(0.4, "EA"));

        List<Company> list2 = new ArrayList<>();
        list2.add(new Company(0.4, "p3"));
        list2.add(new Company(0.4, "p4"));
        list2.add(new Company(0.2, "AAPL"));

        List<Company> list3 = new ArrayList<>();
        list3.add(new Company(0.2, "EA"));
        list3.add(new Company(0.8, "ATVI"));

        List<Company> list4 = new ArrayList<>();
        list4.add(new Company(0.6, "OKTA"));
        list4.add(new Company(0.4, "TEAM"));

        portfolioMap.put("p1", list1);
        portfolioMap.put("p2", list2);
        portfolioMap.put("p3", list3);
        portfolioMap.put("p4", list4);
    }

    public Map<String, Integer> compute(String portfolio, int amount){

        List<Company> list = portfolioMap.get(portfolio); // p2, aapl, ea
        for (Company company : list){
            if (company.name == "p1" || company.name == "p2" ||company.name == "p3" ||company.name == "p4"){
                compute(company.name, (int) (amount*company.value));
            }
            else{
                result.put(company.name, result.getOrDefault(company.name, 0)+ (int) (amount*company.value));
            }
        }

        /*for (int i=0;i<list.size();i++){
            if (list.get(i).name == "p1" || list.get(i).name == "p2" ||list.get(i).name == "p3" ||list.get(i).name == "p4"){
                compute(list.get(i).name, (int) (amount*list.get(i).value));
            }
            else{
                result.put(list.get(i).name, result.getOrDefault(list.get(i).name, 0)+ (int) (amount*list.get(i).value));
            }
        }*/
        return result;
    }

}

class Company{
    double value;
    String name;

    public Company(double v, String p2) {
        this.value = v;
        this.name = p2;
    }

}
