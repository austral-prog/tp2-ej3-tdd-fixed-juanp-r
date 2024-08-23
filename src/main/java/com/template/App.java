package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (amount > 0 && accounts.containsKey(account)) {
             accounts.put(account, accounts.get(account) + amount);
        }
        return accounts;
    }

    public static Map<String,Integer> withdraw(Map<String, Integer> accounts, String account , int amount) {
        if (amount > 0 && accounts.containsKey(account) && amount < accounts.get(account)) {
            accounts.put(account, accounts.get(account) - amount);
        }
        return accounts;
    }

    public static Map<String,Integer> transfer(Map<String, Integer> accounts,String sender,String receiver, int amount) {
        if (amount > 0 && accounts.containsKey(sender) && accounts.containsKey(receiver) && amount <= accounts.get(sender) && sender != receiver) {
            accounts.put(receiver, accounts.get(receiver) + amount);
            accounts.put(sender, accounts.get(sender) - amount);
        }
        return accounts;
    }

}
