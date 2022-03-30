# Baraka Banking System

This is a banking solution which allows our customers to register for new account, perform transactions & get acoount details. Below the features covered by this application.

● Creation of account
● Deletion of account
● Getting the balance
● List of accounts
● Money deposit
● Money withdrawal
● Money transfer
● International transfer

## Tech
 - Spring boot
 - Spring JPA
 - Java8
 - H2 database

## Swagger
[Baraka Banking System Swagger](http://localhost:9090/swagger-ui/#/)

## Bitbucket Repo
[Baraka Banking System](https://bitbucket.org/dashboard/repositories?search=cams)

## Ownership
 - Manish Bhargava

## Database Entities
##### AccountDetail
This entity will be responsible to keep account details for a particular customer. An customer can hold multiple accounts like Savings/Current.
##### Customer
It represents customer entity. Each customer is unique based on their registered government id & can have multiple accounts. Every new customer registration will setup default accountdetail entity as SAVINGS account with min balance 200 AED.
##### Transactions
This entity will keep transactions information like DEBIT/CREDIT etc. Each transaction will have one to many relation with AccountDetail.
##### Beneficiary
Customer can have registred beneficiary for frequent transactions.

## Services
##### Customer Service
This service will be use to perform any operation on Customer Entity like customer creation, deletion, get customer info.
##### AccountDetail Service
To perform AccountDetail related transactions.
##### Transactions Service
To handle & create transaction entries when customer perform deposits,withdrawls & transafers.
##### Transfer Service
This service will be used when customer perform deposits,withdrawls & transafers flows.
##### Bank Service
This service will be used when customer performs international transactions. This service will be responsible to integrate with third party banking systems.