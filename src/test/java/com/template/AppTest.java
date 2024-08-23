package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.deposit;
import static com.template.App.withdraw;
import static com.template.App.transfer;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    Map<String, Integer> accounts = new HashMap<>();

    {
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        accounts.put("zero", 0);

    }

    @Test
    public void testDeposit() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }

    @Test
    public void testDepositNegativeAmount() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    public void testDepositImaginaryFriend() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "santi", 5);
        //assertFalse(updatedAccounts.containsKey("santi"));
        assertNull(updatedAccounts.get("santi"));
    }
//withdraw  Tests
    @Test
    public void tesWithdrawMoneyLoss(){
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", 5);
        assertEquals(15, updatedAccounts.get("juan"));
    }

    @Test
    public void testWithdrawNegativeAmount(){
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", -5);
        assertEquals(20, updatedAccounts.get("juan"));
    }

    @Test
    public void testWithdrawNoBalance(){
        Map<String, Integer> updatedAccounts = withdraw(accounts, "zero", 5);
        assertEquals(0,updatedAccounts.get("zero"));
    }
    @Test
    public void testWithdrawImaginaryFriend(){
        Map<String, Integer> updatedAccounts = withdraw(accounts, "santi", 5);
        assertNull(updatedAccounts.get("santi"));
    }
    //tests transferencias
    @Test
    public void testTransferBalanceChange(){
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan","mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
        assertEquals(15, updatedAccounts.get("juan"));
    }
    @Test
    public void testTransferNegativeAmount(){
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan","mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    public void testTransferFirstImaginaryFriend(){
        Map<String, Integer> updatedAccounts = transfer(accounts, "santi","mati", 5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertNull(updatedAccounts.get("santi"));
    }
    @Test
    public void testTransferSecondImaginaryFriend(){
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati","santi", 5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertNull(updatedAccounts.get("santi"));
    }
    @Test
    public void testTransferBothImaginaryFriend(){
        Map<String, Integer> updatedAccounts = transfer(accounts, "santi","sebastian", 5);
        assertNull(updatedAccounts.get("santi"));
        assertNull(updatedAccounts.get("sebastian"));
    }
    @Test
    public void testTransferSenderNoBalance() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "zero", "mati", 5);
        assertEquals(0, updatedAccounts.get("zero"));
        assertEquals(10, updatedAccounts.get("mati"));
    }
    @Test
    public void testTransferReceiverNoBalance() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "zero", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        assertEquals(5, updatedAccounts.get("zero"));
    }
    @Test
    public void testTransferReceiverEqualAccounts() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }
}
