Feature: Search and Place the order for products

  Scenario: SearchExperience for products searched in both home and offers page
    Given user is on homePage
    When user searched product with "tom" searched results should display and extract the actual name of product
		And user clicks on "TopDeals" link and search with "tom" in offerspage to check if product exists
		Then verify  homPageProductname and offerPageProdutname 
		