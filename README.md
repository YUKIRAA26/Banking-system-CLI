# Java Bank CLI

A simple command-line banking system built with Java. This project was created to practice Java fundamentals, OOP, collections, validation, and basic application structure.

## Features

* Create a bank account
* Account number validation
* Password validation
* Duplicate account number checking
* Account login system
* Limited login attempts
* Deposit money
* Withdraw money
* Check account balance
* Transfer money between accounts
* Prevent transfers to non-existent accounts
* Prevent transfers to your own account
* Prevent transfers when the sender has insufficient balance
* Input validation for numbers, decimals, and empty strings

## Technologies

* Java
* `HashMap`
* `Predicate`
* OOP
* Exception handling
* Java Collections Framework

## Project Structure

```text
Bank/
├── Account.java
├── AccountManager.java
├── BankManager.java
├── Exceptions.java
└── Main.java
```

### Account

Stores account information such as:

* Account number
* Name
* Password
* Balance

### AccountManager

Handles:

* Account creation
* Account login
* Account storage using `HashMap`

### BankManager

Handles:

* Deposits
* Withdrawals
* Balance checking
* Money transfers

### Exceptions

Handles and validates user input.

### Main

Controls the menus and overall program flow.

## How It Works

When the program starts, the user can:

1. Create an account
2. Log in
3. Exit

After successfully logging in, the user can:

1. Deposit
2. Withdraw
3. Check balance
4. Transfer money
5. Log out

## Example

```text
===== BANK SYSTEM =====
1. Create Account
2. Login
3. Exit

===== ACCOUNT =====
Welcome Jacob
1. Deposit
2. Withdraw
3. Check Balance
4. Transfer
5. Log out
```

## Learning Goals

This project is mainly for practicing:

* Classes and objects
* Encapsulation
* Getters and setters
* `HashMap`
* Generics
* `Predicate`
* Methods
* Loops and conditionals
* Exception handling
* Basic program architecture
* Managing application state

## Note

This is an educational CLI project and is **not intended for real banking or financial use**. Account data is currently stored only while the program is running.
