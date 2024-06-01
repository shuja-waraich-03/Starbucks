## Starbucks Membership System

# Overview
The Starbucks Membership System tracks customer coffee preferences and purchases. When customers swipe their membership cards, the system retrieves their preferences and updates their purchase count. After every three purchases, the system generates a coupon for a free coffee.

# Features
Customer Management: Add and manage customers with unique membership IDs and coffee preferences.
Purchase Tracking: Track the number of coffee purchases and automatically generate coupons.
Multiple Purchases: Handle multiple coffee purchases in a single transaction.
Customer Information Retrieval: Retrieve and display customer information, including coffee preferences and purchase history.
Exception Handling: Handle cases where a customer is not found in the system.

# Questions or Clarifications
Should the system handle different types of coupons or only "get one free" coupons?

Should the system allow customers to redeem multiple coupons in a single transaction?

How should the system handle updates to customer preferences?


# Design Decisions and Assumptions
The system is a simple in-memory application without persistent storage, data is stored in a datastructure.
Each customer has a unique membership ID.
The coffee count is reset to 0 after a coupon is generated.
Customer data is managed in a HashMap for quick lookups.
