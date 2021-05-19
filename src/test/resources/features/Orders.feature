@Orders 
Feature: TBL Product & SKU download 

Scenario Outline: 
	Lazada user is able to download TBL product and SKU details 

	Given Customer opens the homepage for the "<URL>" 
	When Customer login to system by providing "<Email>" and "<Password>" 
	
	Examples: 
		| URL                             |Email|Password|
		| https://sellercenter.lazada.sg/apps/seller/login    |amitrs@specom.io|Singpost123456|